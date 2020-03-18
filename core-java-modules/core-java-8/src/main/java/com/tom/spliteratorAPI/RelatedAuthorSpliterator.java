package com.tom.spliteratorAPI;


import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class RelatedAuthorSpliterator implements Spliterator<Author> {
    private final List<Author> list;
    AtomicInteger current = new AtomicInteger();

    public RelatedAuthorSpliterator(List<Author> list) {
        this.list = list;
    }

    /**
     * tryAdvance –在当前索引位置将作者传递给消费者，并增加其位置
     *
     * @param action
     * @return
     */
    @Override
    public boolean tryAdvance(Consumer<? super Author> action) {

        action.accept(list.get(current.getAndIncrement()));
        return current.get() < list.size();
    }

    /**
     * trySplit –定义拆分机制，在我们的示例中，当id匹配时创建RelatedAuthorSpliterator，拆分将列表分为两部分
     *
     * @return
     */
    @Override
    public Spliterator<Author> trySplit() {
        int currentSize = list.size() - current.get();
        if (currentSize < 10) {
            return null;
        }
        for (int splitPos = currentSize / 2 + current.intValue(); splitPos < list.size(); splitPos++) {
            if (list.get(splitPos).getRelatedArticleId() == 0) {
                Spliterator<Author> spliterator = new RelatedAuthorSpliterator(list.subList(current.get(), splitPos));
                current.set(splitPos);
                return spliterator;
            }
        }
        return null;
    }

    /**
     * estateSize –是列表大小和当前迭代作者的位置之间的差
     *
     * @return
     */
    @Override
    public long estimateSize() {
        return list.size() - current.get();
    }

    /**
     * characteristics–返回Spliterator特性，在本例中为SIZED，因为estimatedSize（）方法返回的值是精确的；
     * 此外，CONCURRENT表示此Spliterator的源可以被其他线程安全地修改。
     *
     * @return
     */
    @Override
    public int characteristics() {
        return CONCURRENT;
    }

}