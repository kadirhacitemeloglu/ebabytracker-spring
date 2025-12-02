package com.kadir.ebabytracker.baby.dto;


import com.kadir.ebabytracker.baby.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;


public record BabyCreateRequest (

    @NotBlank(message = "Name cannot be empty")
     String name,
    @NotNull(message = "Gender is required")
     Gender gender,
    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be positive")
     Double weight,
    @NotNull(message = "Height is required")
    @Positive(message =  "Height must be positive")
     Double height,
    @NotNull(message =  "Birthday is required")
    @Past(message =  "Birth day must be in the past!")
     LocalDate birthDay,
    @NotNull (message = "Parent ID is required")
     Long parentId,
     String notes
)
{}
