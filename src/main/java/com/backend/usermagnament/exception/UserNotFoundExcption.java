package com.backend.usermagnament.exception;

public class UserNotFoundExcption extends RuntimeException{
    public UserNotFoundExcption(String message) {
        super(message);
    }
}
