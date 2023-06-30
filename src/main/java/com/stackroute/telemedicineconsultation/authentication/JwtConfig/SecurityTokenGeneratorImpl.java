package com.stackroute.telemedicineconsultation.authentication.JwtConfig;

import com.stackroute.telemedicineconsultation.authentication.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    // @Value("${jwt.secretKey}")
    // private String secretKey;

    // @Override
    // public Map<String, String> generateToken(UserModel user) {
    //     Map<String, String> map = new HashMap<>();
    //     long currentTimeInMilli = System.currentTimeMillis();
    //     String jwtToken = Jwts.builder()
    //             .setSubject(user.getEmailId())
    //             .setIssuedAt(new Date(currentTimeInMilli))
    //             .setExpiration(new Date(currentTimeInMilli + 600000))
    //             .signWith(SignatureAlgorithm.HS512, secretKey)
    //             .compact();
    //     map.put("token", jwtToken);
    //     map.put("message", "User successfully logged in");
    //     map.put("emailId", user.getEmailId());
    //     return map;
    // }

    private final String secretKey;

public SecurityTokenGeneratorImpl(@Value("${jwt.secretKey}") String secretKey) {
    this.secretKey = secretKey;
}

@Override
public Map<String, String> generateToken(UserModel user) {
    long currentTimeInMilli = System.currentTimeMillis();
    String jwtToken = Jwts.builder()
            .setSubject(user.getEmailId())
            .setIssuedAt(new Date(currentTimeInMilli))
            .setExpiration(new Date(currentTimeInMilli + 600000))
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();

    Map<String, String> map = new HashMap<>();
    map.put("token", jwtToken);
    map.put("message", "User successfully logged in");
    map.put("emailId", user.getEmailId());

    return map;
}




}
