package com.github.seif.apirest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        Long id,
        @NotBlank(message = "Name is required")  String name,
        @Email(message = "Email must be valid") String email
) {}
