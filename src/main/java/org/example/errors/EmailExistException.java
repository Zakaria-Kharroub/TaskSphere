package org.example.errors;

public class EmailExistException extends RuntimeException {
    public EmailExistException() {
        super("Email already exist");
    }
}
