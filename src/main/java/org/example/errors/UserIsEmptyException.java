package org.example.errors;

public class UserIsEmptyException extends RuntimeException {
    public UserIsEmptyException() {
        super("User is empty");
    }

}
