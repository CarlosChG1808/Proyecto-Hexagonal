package com.tecsup.example.hexagonal.application.port.input;

import com.tecsup.example.hexagonal.domain.model.User;

import java.util.List;

public interface UserService {

    User createUser(User newUser);

    User findUser(Long id);

    User findByLastName(String lastName);

    User findByDni(String dni);

    List<User> findByAgeLessThan(Integer age);

}
