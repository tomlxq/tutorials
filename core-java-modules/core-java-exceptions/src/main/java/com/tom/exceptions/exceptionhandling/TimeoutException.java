package com.tom.exceptions.exceptionhandling;

/**
 * If we don't want to handle the exception ourselves or we want to generate our exceptions for others to handle, then we need to get familiar with the throw keyword
 *
 * @author TomLuo
 * @date 2020/2/6
 */
public class TimeoutException extends Exception {
    public TimeoutException(String message) {
        super(message);
    }
}
