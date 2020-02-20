

/**
 * Immutable Implementations
 * 不变性是一个功能强大，与语言无关的概念，在Java中相当容易实现。
 * 简单地说，一个类实例在构造后无法修改其内部状态时是不可变的。
 * 在Java中创建不可变类的最简单方法是声明所有字段为private和final，而不提供setter
 *
 * @author TomLuo
 * @date 2020/2/16
 */
package com.tom.concurrent.threadsafety.services;

import lombok.Getter;

@Getter
public class MessageService {

    private final String message;

    public MessageService(String message) {
        this.message = message;
    }
}
