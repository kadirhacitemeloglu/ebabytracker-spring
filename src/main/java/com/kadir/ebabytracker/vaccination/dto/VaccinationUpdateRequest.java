package com.kadir.ebabytracker.vaccination.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.time.LocalDate;


public record VaccinationUpdateRequest (
    @NotBlank(message = "name can not be empty!")
    String vaccineName,
    @NotNull(message = "Date can not be null!")
    LocalDate vaccinationDate,
    @NotNull(message = "Dose is required")
    @Positive(message = "Dose no must be positive")
    Integer doseNumber,
    String notes
    ){
    }

