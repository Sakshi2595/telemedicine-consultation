package com.stackroute.telemedicineconsultation.authentication;

import com.stackroute.telemedicineconsultation.authentication.JwtConfig.SecurityTokenGenerator;
import com.stackroute.telemedicineconsultation.authentication.controller.UserController;
import com.stackroute.telemedicineconsultation.authentication.exception.UserAlreadyExistsException;
import com.stackroute.telemedicineconsultation.authentication.exception.UserNotFoundException;
import com.stackroute.telemedicineconsultation.authentication.model.UserModel;
import com.stackroute.telemedicineconsultation.authentication.service.UserService;

import antlr.collections.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    private UserController userController;
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @BeforeEach
    public void setUp() {
        userService = mock(UserService.class);
        securityTokenGenerator = mock(SecurityTokenGenerator.class);
        userController = new UserController(userService, securityTokenGenerator);
    }

    @Test
    public void testRegisterUser_Success() throws UserNotFoundException, UserAlreadyExistsException {
        UserModel user = new UserModel("john", "password");
        when(userService.register(user)).thenReturn(user);
        
        ResponseEntity<?> response = userController.registerUser(user);
        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).register(user);
    }

    // @Test
    // public void testLogin_Success() throws UserNotFoundException {
    //     UserModel user = new UserModel("john", "password");
    //     UserModel loggedInUser = new UserModel("john", "password");
    //     when(userService.login(user)).thenReturn(loggedInUser);
    //     String token = "token";
    //     //when(securityTokenGenerator.generateToken(loggedInUser)).thenReturn(token);

    //     ResponseEntity<?> response = userController.login(user);

    //     assertEquals(HttpStatus.OK, response.getStatusCode());
    //     assertEquals(token, response.getBody());
    //     verify(userService, times(1)).login(user);
    //     verify(securityTokenGenerator, times(1)).generateToken(loggedInUser);
    // }

    @Test
    public void testLogin_UserNotFound() throws UserNotFoundException {
        UserModel user = new UserModel("john", "password");
        when(userService.login(user)).thenReturn(null);

        ResponseEntity<?> response = userController.login(user);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("login failed", response.getBody());
        verify(userService, times(1)).login(user);
        verify(securityTokenGenerator, never()).generateToken(any());
    }

    @Test
    public void testGetAllUsers_Success() throws UserNotFoundException {
        UserModel user1 = new UserModel("john", "password");
        UserModel user2 = new UserModel("jane", "password");
       // when(userService.getAllUser()).thenReturn(List.of(user1, user2));

        ResponseEntity<?> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
       // assertEquals(List.of(user1, user2), response.getBody());
        verify(userService, times(1)).getAllUser();
    }
}
