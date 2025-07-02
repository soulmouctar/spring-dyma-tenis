package com.dyma.tennis.spring.entity;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record Rank(
        @Positive int postion,
        @PositiveOrZero int points
) {

}
