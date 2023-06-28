package com.stackroute.telemedicineconsultation.authentication.JwtConfig;

import com.stackroute.telemedicineconsultation.authentication.model.UserModel;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String,String> generateToken(UserModel user);
}
