package com.tom.concurrent.synchronize;

import lombok.Data;

/**
 * The Synchronized Keyword
 * The synchronized keyword can be used on different levels:
 *
 * Instance methods
 * Static methods
 * Code blocks
 * When we use a synchronized block, internally Java uses a monitor also known as monitor lock or intrinsic lock, to provide synchronization. These monitors are bound to an object, thus all synchronized blocks of the same object can have only one thread executing them at the same time.
 *
 * @author TomLuo
 * @date 2020/2/10
 */
@Data
public class TomSynchronizedMethods {

    private int sum = 0;
    private int syncSum = 0;

    static int staticSum = 0;

    void calculate() {
        setSum(getSum() + 1);
    }

    synchronized void synchronisedCalculate() {
        setSyncSum(getSyncSum() + 1);
    }

    static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    /*public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    int getSyncSum() {
        return syncSum;
    }

    private void setSyncSum(int syncSum) {
        this.syncSum = syncSum;
    }*/
}