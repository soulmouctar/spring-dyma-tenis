package com.dyma.tennis.spring.entity;

import java.time.LocalDate;

public record Player(
        String id,
        String firstName,
        String lastName,
        LocalDate birthDate,
        Rank rank
) {
}
