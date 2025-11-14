package com.kadir.ebabytracker.baby.dto;


import com.kadir.ebabytracker.baby.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BabyCreateRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Gender is required")
    private Gender gender;

    private String notes;
    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be positive")
    private Double weight;
    @NotNull(message = "Height is required")
    @Positive(message =  "Height must be positive")
    private Double height;
    @NotNull(message =  "Birthday is required")
    @Past(message =  "Birth day must be in the past!")
    private LocalDate birthDay;

    @NotNull (message = "Parent ID is required")
    private Long parentID;



}
