package com.tom.exceptions.exceptionhandling;

import java.io.IOException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
public class PlayerScoreException extends Exception {

    public PlayerScoreException(Exception e) {
        super(e);
    }
}
