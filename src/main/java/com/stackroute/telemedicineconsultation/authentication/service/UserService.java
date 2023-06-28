package com.stackroute.telemedicineconsultation.authentication.service;

import com.stackroute.telemedicineconsultation.authentication.exception.UserAlreadyExistsException;
import com.stackroute.telemedicineconsultation.authentication.exception.UserNotFoundException;
import com.stackroute.telemedicineconsultation.authentication.model.UserModel;

import java.util.List;


public interface UserService {
    UserModel register(UserModel user) throws UserAlreadyExistsException;
    UserModel login(UserModel user) throws UserNotFoundException;

    List<UserModel> getAllUser();

}
