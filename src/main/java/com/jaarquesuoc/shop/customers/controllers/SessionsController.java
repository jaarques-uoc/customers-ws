package com.jaarquesuoc.shop.customers.controllers;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.services.SessionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SessionsController {

    private final SessionsService sessionsService;

    @PostMapping("/login")
    public CustomerDto login(@RequestBody final CustomerDto customerDto) {
        return sessionsService.login(customerDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/signup")
    public CustomerDto signup(@RequestBody final CustomerDto customerDto) {
        return sessionsService.customerSignup(customerDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
