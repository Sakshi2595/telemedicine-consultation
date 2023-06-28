package com.stackroute.telemedicineconsultation.authentication.service;

import com.stackroute.telemedicineconsultation.authentication.exception.UserAlreadyExistsException;
import com.stackroute.telemedicineconsultation.authentication.exception.UserNotFoundException;
import com.stackroute.telemedicineconsultation.authentication.model.UserModel;
import com.stackroute.telemedicineconsultation.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public UserModel register(UserModel user) throws UserAlreadyExistsException {

        if(userRepository.findByEmailId(user.getEmailId())!=null)
        {
            throw new UserAlreadyExistsException();
        }else {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            return userRepository.save(user);
        }
    }

    @Override
    public UserModel login(UserModel user) throws UserNotFoundException {

        UserModel user1 = userRepository.findByEmailId(user.getEmailId());
        System.out.println(user1);

        if (passwordEncoder.matches(user.getPassword(),user1.getPassword())){
            return user1;
        }else{
            throw new UserNotFoundException();
        }

    }

    // implement the getAllUser form UserService
    @Override
    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }


}
