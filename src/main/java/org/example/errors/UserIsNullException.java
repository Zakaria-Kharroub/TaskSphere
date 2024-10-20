package org.example.errors;

public class UserIsNullException extends RuntimeException{
    public UserIsNullException() {
        super("User must not be null");
    }
}
