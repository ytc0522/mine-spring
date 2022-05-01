package org.example.mine.spring.beans.exceptions;

public class BeanException extends RuntimeException{

    public BeanException() {
    }

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
