package com.kadir.ebabytracker.baby.dto;

import com.kadir.ebabytracker.baby.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BabyUpdateRequest {

    private String name;
    private Gender gender;
    private String notes;
    private Double weight;
    private Double height;
    private LocalDate birthDay;
}