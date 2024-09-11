package com.co.leader.admin.infrastructure.boot.encoder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testPasswordEncoderNotNull() {
        assertNotNull(passwordEncoder, "PasswordEncoder should not be null");
    }

    @Test
    void testPasswordEncoding() {
        String rawPassword = "securePassword123";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Encoded Password: "+ encodedPassword);

        assertNotNull(encodedPassword, "Encoded password should not be null");
        assertNotEquals(rawPassword, encodedPassword, "Encoded password should not match raw password");
    }

    @Test
    void testPasswordMatching() {
        String rawPassword = "admin";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Encoded Password: "+ encodedPassword);

        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword),
                "Encoded password should match raw password when checked");
    }
}