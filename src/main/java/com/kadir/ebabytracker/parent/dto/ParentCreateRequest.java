package com.kadir.ebabytracker.parent.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public record ParentCreateRequest (
    String fullName,
    @Email
    String email,
    @NotBlank
    String password
    ){}
