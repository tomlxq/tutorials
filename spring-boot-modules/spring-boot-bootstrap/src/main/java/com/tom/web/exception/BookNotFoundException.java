

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/25
 */
package com.tom.web.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(final String message) {
        super(message);
    }

    public BookNotFoundException(final Throwable cause) {
        super(cause);
    }
}
