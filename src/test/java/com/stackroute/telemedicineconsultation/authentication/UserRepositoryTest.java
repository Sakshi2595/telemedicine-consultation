package com.stackroute.telemedicineconsultation.authentication;

import com.stackroute.telemedicineconsultation.authentication.model.UserModel;
import com.stackroute.telemedicineconsultation.authentication.repository.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private UserModel testUser;

    @BeforeEach
    public void setUp() {
        testUser = new UserModel();
        testUser.setEmailId("test@example.com");
        testUser.setPassword("password123");
        entityManager.persist(testUser);
        entityManager.flush();
    }

    @Test
    public void testFindByEmailId() {
        UserModel foundUser = userRepository.findByEmailId("test@example.com");
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals(testUser.getEmailId(), foundUser.getEmailId());
    }

    @Test
    public void testFindByEmailIdAndPassword() {
        UserModel foundUser = userRepository.findByEmailIdAndPassword("test@example.com", "password123");
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals(testUser.getEmailId(), foundUser.getEmailId());
        Assertions.assertEquals(testUser.getPassword(), foundUser.getPassword());
    }
}
