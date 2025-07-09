package com.dyma.tennis.spring.entity;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record Rank(
        @Positive(message = "La position doit etre positive") int position,
        @PositiveOrZero(message = "ce champ soit etre suerieur ou egal a zero") int points
) {

}
