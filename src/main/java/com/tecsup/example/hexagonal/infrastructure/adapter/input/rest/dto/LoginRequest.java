package com.tecsup.example.hexagonal.infrastructure.adapter.input.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class LoginRequest {

    private String email;
    private String password;
}
