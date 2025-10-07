package com.tecsup.example.hexagonal.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String lastname;
    private String motherLastname;
    private Integer age;
    private String dni;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean enabled;

    private Role role;

    // Business logic methods - PURE domain logic!
    public boolean hasValidEmail() {
        return email != null &&
                email.contains("@") &&
                email.contains(".") &&
                email.length() > 5;
    }

    public boolean hasValidName() {
        return name != null &&
                !name.trim().isEmpty() &&
                name.length() >= 2;
    }
    //Validar DNI
    public boolean hasValidDni() {
        return dni != null && !dni.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
