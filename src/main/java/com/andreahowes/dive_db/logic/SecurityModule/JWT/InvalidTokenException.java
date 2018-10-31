package com.andreahowes.dive_db.logic.SecurityModule.JWT;

public class InvalidTokenException extends RuntimeException{

    public InvalidTokenException(String message) {
        super(message);
    }
}