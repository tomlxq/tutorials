package com.tom.concurrent.delayqueue;

import com.google.common.primitives.Ints;
import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@ToString
public class DelayObject implements Delayed {
    private String data;
    /**
     * 队列中使用元素的时间=当前时间+延迟时间
     */
    private long startTime;

    DelayObject(String data, long delayInMilliseconds) {
        this.data = data;
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    /**
     * 当使用者尝试从队列中取出一个元素时，DelayQueue将执行getDelay（）以确定是否允许从队列中返回该元素。
     * 如果getDelay（）方法将返回零或负数，则意味着可以从队列中检索它。
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    /**
     * 因为DelayQueue中的元素将根据到期时间进行排序。
     * 首先到期的项目将保留在队列的开头，而到期时间最长的元素将保留在队列的末尾
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return Ints.saturatedCast(this.startTime - ((DelayObject) o).startTime);
    }
}