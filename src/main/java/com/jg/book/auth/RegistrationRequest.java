package com.jg.book.auth;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "First name is required")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    
    @NotEmpty(message = "Last name is required")
    @NotBlank(message = "Last name cannot be blank")
    
    @NotEmpty(message = "Email is required")
    @NotBlank(message = "Email cannot be blank")
    private String lastName;
    
    @NotEmpty(message = "Date of birth is required")
    @NotBlank(message = "Date of birth cannot be blank")
    @Email(message = "Email must be valid") 
    private String email;
    
    @NotBlank(message = "Password cannot be blank")
    @NotEmpty(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    
}
