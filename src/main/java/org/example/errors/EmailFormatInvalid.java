package org.example.errors;

public class EmailFormatInvalid extends RuntimeException {
    public EmailFormatInvalid() {
        super("Email format is invalid");
    }
}
