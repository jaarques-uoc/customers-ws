package com.jaarquesuoc.shop.customers.controllers;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.services.CustomersService;
import com.jaarquesuoc.shop.customers.services.SessionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InitialisationController {

    private final CustomersService customersService;

    private final SessionsService sessionsService;

    @GetMapping("/init")
    public List<CustomerDto> initialiseDB() {
        customersService.cleanDb();
        sessionsService.adminSignup(buildAdmin());
        sessionsService.customerSignup(buildSimpleCustomer());
        return customersService.getAllCustomerDtos();
    }

    private CustomerDto buildAdmin() {
        return buildCustomer("admin@uoc.com");
    }

    private CustomerDto buildSimpleCustomer() {
        return buildCustomer("customer@uoc.com");
    }

    private CustomerDto buildCustomer(final String email) {
        return CustomerDto.builder()
            .email(email)
            .password("1234")
            .fullName("UOC admin")
            .address("Some random address")
            .country("Some random country")
            .build();
    }
}
