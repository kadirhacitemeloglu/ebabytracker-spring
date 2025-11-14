package com.kadir.ebabytracker.parent.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParentDto {

    private Long id;
    private String fullName;
    private String eMail;
    private String password;



}
