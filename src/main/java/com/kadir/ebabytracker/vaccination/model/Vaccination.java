package com.kadir.ebabytracker.vaccination.model;

import com.kadir.ebabytracker.baby.model.Baby;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vaccinations")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String vaccineName;

    @Column(nullable = false)
    private LocalDate vaccinationDate;

    private Integer doseNumber;

    @Column(length = 400)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "baby_id",nullable = false)
    private Baby baby;




}
