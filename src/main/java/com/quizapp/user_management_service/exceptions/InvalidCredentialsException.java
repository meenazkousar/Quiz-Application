// InvalidCredentialsException.java
package com.quizapp.user_management_service.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}

