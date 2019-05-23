package com.jaarquesuoc.shop.customers.controllers;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.dtos.InitialisationDto;
import com.jaarquesuoc.shop.customers.services.CustomersService;
import com.jaarquesuoc.shop.customers.services.SessionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jaarquesuoc.shop.customers.dtos.InitialisationDto.InitialisationStatus.OK;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InitialisationController {

    private final CustomersService customersService;

    private final SessionsService sessionsService;

    @GetMapping("/init")
    public InitialisationDto initialiseDB() {
        customersService.cleanDb();

        sessionsService.adminSignup(buildAdmin());
        sessionsService.customerSignup(buildSimpleCustomer());

        return InitialisationDto.builder()
            .initialisationStatus(OK)
            .metadata(customersService.getAllCustomerDtos())
            .build();
    }

    private CustomerDto buildAdmin() {
        return buildCustomer("admin@uoc.edu", "Admin user");
    }

    private CustomerDto buildSimpleCustomer() {
        return buildCustomer("user@uoc.edu", "Normal user");
    }

    private CustomerDto buildCustomer(final String email, final String fullName) {
        return CustomerDto.builder()
            .email(email)
            .password("1234")
            .fullName(fullName)
            .address("Random Address street, 123")
            .country("Andorra")
            .build();
    }
}
