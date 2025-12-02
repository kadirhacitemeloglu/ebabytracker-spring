package com.kadir.ebabytracker.vaccination.dto;





import java.time.LocalDate;


public record  VaccinationDto(

    Long id,
    String vaccineName,
    LocalDate vaccinationDate,
    Integer doseNumber,
    String notes,
    Long babyId
)
{
}