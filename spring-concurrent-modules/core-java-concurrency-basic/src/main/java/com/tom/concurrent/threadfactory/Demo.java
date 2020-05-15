package com.tom.concurrent.threadfactory;

public class Demo {

	public void execute() {
        TomThreadFactory factory = new TomThreadFactory("TomThreadFactory");
        for (int i = 0; i < 10; i++) {
            Thread t = factory.newThread(new Task());
            t.start();
        }
    }

}
