package com.vichar.exception;

import java.util.function.Supplier;

public class UserException extends RuntimeException {
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }
}
