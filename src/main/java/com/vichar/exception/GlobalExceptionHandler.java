package com.vichar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommentException.class)
    public ResponseEntity<MyErrorDetails> commentExceptionHandler(CommentException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(PostException.class)
    public ResponseEntity<MyErrorDetails> postExceptionHandler(PostException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CategotyException.class)
    public ResponseEntity<MyErrorDetails> categoryExceptionHandler(CategotyException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> genericExceptionHandler(Exception e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // No Handler Found Exception Handler

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> myExpHandler(NoHandlerFoundException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();

        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    // Method Argument NotValid Exception Handler

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> MANVExceptionHandler(MethodArgumentNotValidException me) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setDetails("Validation Error");
        err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }
}
