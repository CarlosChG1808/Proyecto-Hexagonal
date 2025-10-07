package com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.repository;

import com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {


    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByLastName(String lastName);

    Optional<UserEntity> findByDni(String dni);

    List<UserEntity> findByAgeLessThan(Integer age);
}
