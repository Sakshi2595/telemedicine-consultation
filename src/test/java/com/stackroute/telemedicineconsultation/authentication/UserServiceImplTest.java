package com.stackroute.telemedicineconsultation.authentication;

import com.stackroute.telemedicineconsultation.authentication.exception.UserAlreadyExistsException;
import com.stackroute.telemedicineconsultation.authentication.exception.UserNotFoundException;
import com.stackroute.telemedicineconsultation.authentication.model.UserModel;
import com.stackroute.telemedicineconsultation.authentication.repository.UserRepository;
import com.stackroute.telemedicineconsultation.authentication.service.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testRegister_UserDoesNotExist_ShouldRegisterUser() throws UserAlreadyExistsException {
        UserModel user = new UserModel();
        user.setEmailId("test@example.com");
        user.setPassword("password");

        when(userRepository.findByEmailId(user.getEmailId())).thenReturn(null);
        when(userRepository.save(any(UserModel.class))).thenReturn(user);

        UserModel registeredUser = userService.register(user);

        assertNotNull(registeredUser);
        assertEquals(user.getEmailId(), registeredUser.getEmailId());
        // Add more assertions if needed
    }

    @Test
    public void testRegister_UserAlreadyExists_ShouldThrowUserAlreadyExistsException() {
        UserModel user = new UserModel();
        user.setEmailId("test@example.com");
        user.setPassword("password");

        when(userRepository.findByEmailId(user.getEmailId())).thenReturn(user);

        assertThrows(UserAlreadyExistsException.class, () -> userService.register(user));
    }

    @Test
    public void testLogin_ValidCredentials_ShouldReturnUserModel() throws UserNotFoundException {
        UserModel user = new UserModel();
        user.setEmailId("test@example.com");
        user.setPassword("password");

        when(userRepository.findByEmailId(user.getEmailId())).thenReturn(user);
        when(passwordEncoder.matches(user.getPassword(), user.getPassword())).thenReturn(true);

        UserModel loggedInUser = userService.login(user);

        assertNotNull(loggedInUser);
        assertEquals(user.getEmailId(), loggedInUser.getEmailId());
        // Add more assertions if needed
    }

    @Test
    public void testLogin_InvalidCredentials_ShouldThrowUserNotFoundException() {
        UserModel user = new UserModel();
        user.setEmailId("test@example.com");
        user.setPassword("password");

        when(userRepository.findByEmailId(user.getEmailId())).thenReturn(user);
        when(passwordEncoder.matches(user.getPassword(), user.getPassword())).thenReturn(false);

        assertThrows(UserNotFoundException.class, () -> userService.login(user));
    }

    // Add more test cases for other methods if needed

}
