package com.tecsup.example.hexagonal.infrastructure.adapter.input.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String lastName;
    private String motherLastName;
    private Integer age;
    private String dni;
    private String phoneNumber;
    private String email;
}
