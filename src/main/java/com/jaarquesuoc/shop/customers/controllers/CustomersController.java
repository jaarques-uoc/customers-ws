package com.jaarquesuoc.shop.customers.controllers;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.services.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomer(@PathVariable final String id) {
        return customersService.getCustomerDto(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() {
        return customersService.getAllCustomerDtos();
    }
}
