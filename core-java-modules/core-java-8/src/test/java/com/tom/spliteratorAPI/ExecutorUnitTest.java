package com.tom.spliteratorAPI;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExecutorUnitTest {
    Article article;
    Stream<Author> stream;
    Spliterator<Author> spliterator;
    Spliterator<Article> split1;
    Spliterator<Article> split2;

    @Before
    public void init() {
        article = new Article(Arrays.asList(new Author("Ahmad", 0), new Author("Eugen", 0), new Author("Alice", 1),
                new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
                new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
                new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
                new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
                new Author("Mike", 0), new Author("Michał", 0), new Author("Loredana", 1)), 0);
        stream = article.getListOfAuthors().stream();
        split1 = Executor.generateElements().spliterator();
        split2 = split1.trySplit();
        spliterator = new RelatedAuthorSpliterator(article.getListOfAuthors());
    }

    @Test
    public void
    givenAStreamOfAuthors_whenProcessedInParallel_countProducesWrongOutput() {
        assertThat(Executor.countAutors(stream.parallel())).isGreaterThan(9);
    }

    @Test
    public void givenAstreamOfAuthors_whenProcessedInParallelWithCustomSpliterator_coubtProducessRightOutput() {
        Stream<Author> stream2 = StreamSupport.stream(spliterator, true);
        assertThat(Executor.countAutors(stream2.parallel())).isEqualTo(9);
    }

    @Test
    public void givenSpliterator_whenAppliedToAListOfArticle_thenSplittedInHalf() {
        assertThat(new Task(split1).call()).containsSequence(Executor.generateElements().size() / 2 + "");
        assertThat(new Task(split2).call()).containsSequence(Executor.generateElements().size() / 2 + "");
    }

    @Test
    public void givenSpliterator_whenAppliedToAListOfArticle_thenSplittedInHalf2() {
        Spliterator<Article> split1 = Executor.generateElements().spliterator();
        Spliterator<Article> split2 = split1.trySplit();
        log.info("Size: " + split1.estimateSize());
        log.info("Characteristics: " + split1.characteristics());
        assertThat(new Task(split1).call())
                .containsSequence(Executor.generateElements().size() / 2 + "");

        assertThat(new Task(split2).call())
                .containsSequence(Executor.generateElements().size() / 2 + "");

    }
}