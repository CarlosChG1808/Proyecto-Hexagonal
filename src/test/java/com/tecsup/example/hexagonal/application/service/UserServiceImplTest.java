package com.tecsup.example.hexagonal.application.service;

import com.tecsup.example.hexagonal.application.port.output.UserRepository;
import com.tecsup.example.hexagonal.domain.exception.UserNotFoundException;
import com.tecsup.example.hexagonal.domain.model.Role;
import com.tecsup.example.hexagonal.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        // Aquí puedes inicializar los mocks y el servicio
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void createUser() {

        Long ID = 50L;
        String NAME = "Juana";
        String LAST_NAME = "Perez";
        String MOTHER_LAST_NAME = "Garcia";
        Integer AGE = 25;
        String DNI = "12345678";
        String PHONE_NUMBER = "987654321";
        String EMAIL = "juana@demo.com";

        // Initial Condition
        User newUser = User.builder()
                .name(NAME)
                .lastname(LAST_NAME)
                .motherLastname(MOTHER_LAST_NAME)
                .age(AGE)
                .dni(DNI)
                .phoneNumber(PHONE_NUMBER)
                .email(EMAIL)
                .build();

        User savedUser = User.builder()
                .id(ID)
                .name(NAME)
                .lastname(LAST_NAME)
                .motherLastname(MOTHER_LAST_NAME)
                .age(AGE)
                .dni(DNI)
                .phoneNumber(PHONE_NUMBER)
                .email(EMAIL)
                .role(Role.USER)
                .build(); // new User(ID, NAME, EMAIL);

        // Mocking the repository behavior
        when(userRepository.save(newUser)).thenReturn(savedUser);

        // Execute the service method
        User realUser = userService.createUser(newUser);

        // Validate the results
        assertNotNull(realUser);
        assertEquals(ID, realUser.getId());
        assertEquals(NAME, realUser.getName());
        assertEquals(LAST_NAME, realUser.getLastname());
        assertEquals(MOTHER_LAST_NAME, realUser.getMotherLastname());
        assertEquals(AGE, realUser.getAge());
        assertEquals(DNI, realUser.getDni());
        assertEquals(PHONE_NUMBER, realUser.getPhoneNumber());
        assertEquals(EMAIL, realUser.getEmail());
        assertEquals(Role.USER, realUser.getRole());

    }

    @Test
    void findUser() {
        Long ID = 100L;
        String NAME = "Jaime";
        String LAST_NAME = "Lopez";
        String MOTHER_LAST_NAME = "Martinez";
        Integer AGE = 30;
        String DNI = "87654321";
        String PHONE_NUMBER = "999888777";
        String EMAIL = "jaime@demo.com";

        // Initial Condition
        User existingUser = User.builder()
                .id(ID)
                .name(NAME)
                .lastname(LAST_NAME)
                .motherLastname(MOTHER_LAST_NAME)
                .age(AGE)
                .dni(DNI)
                .phoneNumber(PHONE_NUMBER)
                .email(EMAIL)
                .build(); // new User(ID, NAME, EMAIL);

        // Mocking the repository behavior
        when(userRepository.findById(100L)).thenReturn(Optional.of(existingUser));

        // Execute the service method
        User realUser = userService.findUser(100L);

        // Validate the results
        assertNotNull(realUser);

        // hope values, real values
        assertEquals(ID, realUser.getId());
        assertEquals(NAME, realUser.getName());
        assertEquals(LAST_NAME, realUser.getLastname());
        assertEquals(MOTHER_LAST_NAME, realUser.getMotherLastname());
        assertEquals(AGE, realUser.getAge());
        assertEquals(DNI, realUser.getDni());
        assertEquals(PHONE_NUMBER, realUser.getPhoneNumber());
        assertEquals(EMAIL, realUser.getEmail());

    }

    @Test
    public void findUser_NotFound() {
        Long ID_UNKNOW = 999L;

        // Mocking the repository behavior to return empty
        when(userRepository.findById(ID_UNKNOW)).thenReturn(Optional.empty());

        // Execute the service method and expect an exception
        assertThrows(UserNotFoundException.class,
                () -> userService.findUser(ID_UNKNOW));

    }
    @Test
    void findByLastName() {
        // Given
        String LAST_NAME = "Fernandez";

        User existingUser = User.builder()
                .id(150L)
                .name("Roberto")
                .lastname(LAST_NAME)
                .motherLastname("Silva")
                .age(32)
                .dni("55667788")
                .phoneNumber("987555666")
                .email("roberto@demo.com")
                .build();

        when(userRepository.findByLastName(LAST_NAME)).thenReturn(Optional.of(existingUser));

        // When
        User realUser = userService.findByLastName(LAST_NAME);

        // Then
        assertNotNull(realUser);
        assertEquals(LAST_NAME, realUser.getLastname());
    }

    @Test
    void findByDni() {
        // Given
        String DNI = "44556677";

        User existingUser = User.builder()
                .id(250L)
                .name("Carmen")
                .lastname("Vasquez")
                .motherLastname("Rojas")
                .age(27)
                .dni(DNI)
                .phoneNumber("987444555")
                .email("carmen@demo.com")
                .build();

        when(userRepository.findByDni(DNI)).thenReturn(Optional.of(existingUser));

        // When
        User realUser = userService.findByDni(DNI);

        // Then
        assertNotNull(realUser);
        assertEquals(DNI, realUser.getDni());
    }

    @Test
    void findByAgeLessThan() {
        // Given
        Integer AGE_LIMIT = 30;

        User user1 = User.builder()
                .id(10L)
                .name("Sofia")
                .lastname("Cruz")
                .motherLastname("Mendoza")
                .age(24)
                .dni("33445566")
                .phoneNumber("987333444")
                .email("sofia@demo.com")
                .build();

        User user2 = User.builder()
                .id(11L)
                .name("Diego")
                .lastname("Morales")
                .motherLastname("Vargas")
                .age(28)
                .dni("22334455")
                .phoneNumber("987222333")
                .email("diego@demo.com")
                .build();

        List<User> expectedUsers = Arrays.asList(user1, user2);

        when(userRepository.findByAgeLessThan(AGE_LIMIT)).thenReturn(expectedUsers);

        // When
        List<User> realUsers = userService.findByAgeLessThan(AGE_LIMIT);

        // Then
        assertNotNull(realUsers);
        assertEquals(2, realUsers.size());
    }
}













