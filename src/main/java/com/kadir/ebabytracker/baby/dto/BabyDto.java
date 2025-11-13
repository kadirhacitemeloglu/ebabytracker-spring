package com.kadir.ebabytracker.baby.dto;


import com.kadir.ebabytracker.baby.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BabyDto {

    private Long id;
    private String name;
    private Gender gender;
    private String notes;
    private LocalDate BirthDay;
    private Double weight;
    private Double height;

}
