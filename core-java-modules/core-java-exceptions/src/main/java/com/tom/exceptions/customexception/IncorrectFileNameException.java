package com.tom.exceptions.customexception;

import java.io.FileNotFoundException;

/**
 * Custom checked Exception
 *
 * @author TomLuo
 * @date 2020/2/6
 */
public class IncorrectFileNameException  extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * We've created and used a custom exception, so the user can now know what the exact exception is. Is this enough? We are consequently losing the root cause of the exception.
     *
     * To fix this, we can also add a java.lang.Throwable parameter to the constructor. This way, we can pass the root exception to the method call:
     * @param errorMessage
     * @param err
     */
    public IncorrectFileNameException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}