package com.tom.runnablecallable;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
@Slf4j
public class EventLoggingTask implements  Runnable{


    @Override
    public void run() {
        log.info("Message");
    }
}
