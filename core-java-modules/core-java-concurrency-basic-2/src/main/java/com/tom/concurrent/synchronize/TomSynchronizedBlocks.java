/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/10
 */
package com.tom.concurrent.synchronize;

import lombok.Data;

@Data
public class TomSynchronizedBlocks {

    private int count = 0;
    private static int staticCount = 0;

    void performSynchronisedTask() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }

    static void performStaticSyncTask() {
        synchronized (TomSynchronizedBlocks.class) {
            setStaticCount(getStaticCount() + 1);
        }
    }



    static int getStaticCount() {
        return staticCount;
    }

    private static void setStaticCount(int staticCount) {
        TomSynchronizedBlocks.staticCount = staticCount;
    }
}
