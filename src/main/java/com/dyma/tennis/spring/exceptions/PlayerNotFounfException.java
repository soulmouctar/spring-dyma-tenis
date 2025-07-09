package com.dyma.tennis.spring.exceptions;

public class PlayerNotFounfException extends RuntimeException{
    public PlayerNotFounfException(String lastName) {
        super("Player with last name '" + lastName + "' not found.");
    }
}
