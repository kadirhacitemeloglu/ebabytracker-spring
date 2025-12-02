package com.kadir.ebabytracker.baby.dto;

import com.kadir.ebabytracker.baby.model.Gender;


import java.time.LocalDate;


public record BabyUpdateRequest (

    String name,
    Gender gender,
    String notes,
    Double weight,
    Double height,
    LocalDate birthDay
)
{}