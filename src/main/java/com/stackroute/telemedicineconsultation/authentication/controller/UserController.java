package com.stackroute.telemedicineconsultation.authentication.controller;

import com.stackroute.telemedicineconsultation.authentication.JwtConfig.SecurityTokenGenerator;
import com.stackroute.telemedicineconsultation.authentication.exception.UserAlreadyExistsException;
import com.stackroute.telemedicineconsultation.authentication.exception.UserNotFoundException;
import com.stackroute.telemedicineconsultation.authentication.model.UserModel;
import com.stackroute.telemedicineconsultation.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UserController {

    private UserService userService;


    private SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public UserController(UserService userService , SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody UserModel user) throws UserNotFoundException {

        UserModel user1 = userService.login(user);

        if (user1 == null) {
            return new ResponseEntity<>("login failed", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(securityTokenGenerator.generateToken(user1), HttpStatus.OK);

    }

    //write a controller method to get all users get the get all user metheod from service
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() throws UserNotFoundException {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }






}
