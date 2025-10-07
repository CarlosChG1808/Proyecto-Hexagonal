package com.tecsup.example.hexagonal.application.service;

import com.tecsup.example.hexagonal.application.port.input.UserService;
import com.tecsup.example.hexagonal.application.port.output.UserRepository;
import com.tecsup.example.hexagonal.domain.exception.InvalidUserDataException;
import com.tecsup.example.hexagonal.domain.exception.UserNotFoundException;
import com.tecsup.example.hexagonal.domain.model.Role;
import com.tecsup.example.hexagonal.domain.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User newUser) {

        // Validation logic can be added here
        validateUserInput(newUser);

        //set default values
        if (newUser.getRole() == null)
            newUser.setRole(Role.USER);

        // Save the user using the repository
        User user = this.userRepository.save(newUser);

        //user.setName("Margot"); // Garbage line for testing purposes

        return user;

    }

    @Override
    public User findUser(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }

        User user = this.userRepository.findById(id)
                .orElseThrow( ()-> new UserNotFoundException(id) );

        return user;
    }

    @Override
    public User findByLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        User user = this.userRepository.findByLastName(lastName)
                .orElseThrow(() -> new UserNotFoundException("User not found with last name" + lastName));
        return user;
    }

    @Override
    public User findByDni(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("Dni cannot be empty");
        }

        User user = this.userRepository.findByDni(dni)
                .orElseThrow(() -> new UserNotFoundException("User not found with dni" + dni));
        return user;
    }


    @Override
    public List<User> findByAgeLessThan(Integer age) {
        if (age == null || age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }

        List<User> user = this.userRepository.findByAgeLessThan(age);
        return user;
    }

    private void validateUserInput(User newUser) {

        if (!newUser.hasValidName())
            throw new InvalidUserDataException("Invalid email");

        if (!newUser.hasValidEmail())
            throw new InvalidUserDataException("Invalid email");

        if (!newUser.hasValidDni())
            throw new InvalidUserDataException("Invalid dni");
    }
}
