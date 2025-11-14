package com.kadir.ebabytracker.baby.model;

import com.kadir.ebabytracker.parent.model.Parent;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "babies")
public class Baby{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    @Column(length = 400)
    private String notes;

    @Column(nullable = false)
    private LocalDate birthDay;

    private Double weight;
    private Double height;

    @ManyToOne
    @JoinColumn(name = "parent_id" , nullable = false)
    private Parent parent;

}
