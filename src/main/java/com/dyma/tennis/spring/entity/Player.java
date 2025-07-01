package com.dyma.tennis.spring.entity;

import java.time.LocalDate;

public record Player(
        String id,
        String firstName,
        LocalDate birthDate,
        Rank rank
) {
}
