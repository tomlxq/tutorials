package com.tom.rethrow.custom;

public class InvalidDataException extends Exception {

    public InvalidDataException(Exception e) {
        super(e);
    }
}
