package com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.repository;

import com.tecsup.example.hexagonal.application.port.output.UserRepository;
import com.tecsup.example.hexagonal.domain.model.User;
import com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.entity.UserEntity;
import com.tecsup.example.hexagonal.infrastructure.adapter.output.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Slf4j
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;

    private final UserMapper userMapper;

    @Override
    public User save(User user) {

        // Domain to Entity
        UserEntity userEntity = this.userMapper.toEntity(user);

        // Save entity
        UserEntity entityCreated = this.jpaRepository.save(userEntity);

        log.info("User created: {}", entityCreated);

        // Entity to Domain
        return this.userMapper.toDomain(entityCreated);
    }

    @Override
    public Optional<User> findById(Long id) {

        return this.jpaRepository.findById(id).map(this.userMapper::toDomain);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.jpaRepository.findByEmail(email).map(this.userMapper::toDomain);
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        return this.jpaRepository.findByLastName(lastName).map(this.userMapper::toDomain);
    }

    @Override
    public Optional<User> findByDni(String dni){
        return this.jpaRepository.findByDni(dni).map(this.userMapper::toDomain);
    }

    @Override
    public List<User> findByAgeLessThan(Integer age) {
        return this.jpaRepository.findByAgeLessThan(age)
                .stream()
                .map(this.userMapper::toDomain)
                .collect(Collectors.toList());
    }
}