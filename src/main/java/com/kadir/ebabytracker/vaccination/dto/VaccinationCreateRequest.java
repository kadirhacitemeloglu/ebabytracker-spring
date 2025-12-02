package com.kadir.ebabytracker.vaccination.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VaccinationCreateRequest(

        @NotBlank(message = "Vaccine name cannot be empty")
        String vaccineName,

        @NotNull(message = "Vaccination date is required")
        LocalDate vaccinationDate,

        Integer doseNumber,

        String notes,

        @NotNull(message = "Baby ID is required")
        Long babyId
) {
}
