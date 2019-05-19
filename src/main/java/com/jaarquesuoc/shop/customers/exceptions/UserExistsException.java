package com.jaarquesuoc.shop.customers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class UserExistsException extends RuntimeException {

    public UserExistsException(final String email) {
        super("User already exists on the DB: " + email);
    }
}
