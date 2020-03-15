
package com.tom.java9.language.stream;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@Slf4j
public class CollectorImprovementUnitTest {
    @Test
    public void givenList_whenSatifyPredicate_thenMapValueWithOccurences() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 5);

        Map<Integer, Long> result = numbers.stream().filter(val -> val > 3).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        assertEquals(1, result.size());

        result = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.filtering(val -> val > 3, Collectors.counting())));

        assertEquals(4, result.size());
    }

    @Test
    public void givenListOfBlogs_whenAuthorName_thenMapAuthorWithComments() {
        Blog blog1 = new Blog("1", "Nice", "Very Nice");
        Blog blog2 = new Blog("2", "Disappointing", "Ok", "Could be better");
        List<Blog> blogs = List.of(blog1, blog2);

        Map<String, List<List<String>>> authorComments1 = blogs.stream().collect(Collectors.groupingBy(Blog::getAuthorName, Collectors.mapping(Blog::getComments, Collectors.toList())));

        assertEquals(2, authorComments1.size());
        assertEquals(2, authorComments1.get("1").get(0).size());
        assertEquals(3, authorComments1.get("2").get(0).size());
        log.info("{}", JSON.toJSONString(authorComments1, true));
        Map<String, List<String>> authorComments2 = blogs.stream().collect(Collectors.groupingBy(Blog::getAuthorName, Collectors.flatMapping(blog -> blog.getComments().stream(), Collectors.toList())));

        assertEquals(2, authorComments2.size());
        assertEquals(2, authorComments2.get("1").size());
        assertEquals(3, authorComments2.get("2").size());
        log.info("{}", JSON.toJSONString(authorComments2, true));
    }
}

@Getter
@AllArgsConstructor
class Blog {
    private String authorName;
    private List<String> comments;

    public Blog(String authorName, String... comments) {
        this.authorName = authorName;
        this.comments = List.of(comments);
    }
}