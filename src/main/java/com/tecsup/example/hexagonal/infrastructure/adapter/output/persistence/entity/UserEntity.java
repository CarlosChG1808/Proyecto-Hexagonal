package com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "lastname", length = 100)
    private String lastName;

    @Column(name = "mother_last_name", length = 100)
    private String motherLastName;

    @Column(name = "age")
    private Integer age;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 150)
    private String email;

    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private RoleEntity role;
}
