package com.dyma.tennis.spring.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record Player(
        @NotBlank(message = "ce champ First Name est vide") String firstName,
        @NotBlank(message = "ce champ Last Name est vide") String lastName,
        @PastOrPresent(message = "ce champ date doit etre inferieur ou egale a aujourd'hui ") LocalDate birthDate,
        @Valid  Rank rank
) {
}
