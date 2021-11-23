package com.example.aftercovidversion2.exception;

public class AfterCovidException extends RuntimeException{

    public AfterCovidException() {
        super();
    }

    public AfterCovidException(String message) {
        super(message);
    }

    public AfterCovidException(String message, Throwable cause) {
        super(message, cause);
    }

    public AfterCovidException(Throwable cause) {
        super(cause);
    }
}
