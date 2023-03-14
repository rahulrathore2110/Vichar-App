package com.vichar.exception;

public class CommentException extends RuntimeException {
    public CommentException() {
    }

    public CommentException(String message) {
        super(message);
    }
}
