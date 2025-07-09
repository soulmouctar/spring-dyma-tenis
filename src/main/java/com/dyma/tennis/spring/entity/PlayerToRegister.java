package com.dyma.tennis.spring.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record PlayerToRegister(
        @NotBlank(message = "ce champ First Name est vide")
        String firstName,
        @NotBlank(message = "ce champ Last Name est vide")
        String lastName,
        @PastOrPresent(message = "ce champ date doit etre inferieur ou egale a aujourd'hui ")
        LocalDate birthDate,
        @PositiveOrZero(message = "ce champ doit etre superieur ou egal a zero")
        int points

) {

}
