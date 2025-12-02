package com.kadir.ebabytracker.baby.dto;


import com.kadir.ebabytracker.baby.model.Gender;


import java.time.LocalDate;


public record BabyDto (

     Long id,
     String name,
     Gender gender,
     String notes,
     LocalDate BirthDay,
     Double weight,
     Double height
)
{}
