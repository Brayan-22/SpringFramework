package com.alejandro.restsecurityjwt.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    private Set<String> roles;
}
