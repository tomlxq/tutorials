

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */

package com.tom.concurrent.threadsafety.services;

import lombok.Getter;


@Getter
public class StateHolder {

    private final String state;

    public StateHolder(String state) {
        this.state = state;
    }
}