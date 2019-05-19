package com.jaarquesuoc.shop.customers.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encryptPassword(final String password) {
        return encoder.encode(password);
    }

    public boolean matchesPassword(final String password, final String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }
}
