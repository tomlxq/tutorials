package com.tom.modules.main;

import com.tom.modules.hello.HelloModules;

public class MainApp {
    public static void main(String[] args) {
        HelloModules.doSomething();

        HelloModules module = new HelloModules();
        module.sayHello();
    }
}
