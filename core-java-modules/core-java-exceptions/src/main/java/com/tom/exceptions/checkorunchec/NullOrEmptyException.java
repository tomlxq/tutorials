package com.tom.exceptions.checkorunchec;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class NullOrEmptyException extends RuntimeException {
    public NullOrEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
