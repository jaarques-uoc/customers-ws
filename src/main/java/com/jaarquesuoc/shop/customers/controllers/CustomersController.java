package com.jaarquesuoc.shop.customers.controllers;

import com.jaarquesuoc.shop.customers.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomersController {

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable final String id) {
        return Customer.builder()
            .id(id)
            .email("test@email.com")
            .fullName("Test full name")
            .address("Test address")
            .country("Test country")
            .creationDate(LocalDateTime.now())
            .build();
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return IntStream.range(0, 10)
            .mapToObj(i -> getCustomer(String.valueOf(i)))
            .collect(Collectors.toList());
    }
}
