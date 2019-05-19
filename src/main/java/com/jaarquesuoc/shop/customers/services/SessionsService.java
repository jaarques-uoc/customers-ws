package com.jaarquesuoc.shop.customers.services;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.dtos.CustomerType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.jaarquesuoc.shop.customers.dtos.CustomerType.ADMIN;
import static com.jaarquesuoc.shop.customers.dtos.CustomerType.CUSTOMER;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SessionsService {

    private final EncryptionService encryptionService;

    private final CustomersService customersService;

    public Optional<CustomerDto> login(final CustomerDto customerDto) {
        return customersService.getCustomerDtoByEmailAndPassword(customerDto);
    }

    public Optional<CustomerDto> customerSignup(final CustomerDto customerDto) {
        return signup(customerDto, CUSTOMER);
    }

    public Optional<CustomerDto> adminSignup(final CustomerDto customerDto) {
        return signup(customerDto, ADMIN);
    }

    public Optional<CustomerDto> signup(final CustomerDto customerDto, final CustomerType customerType) {
        customerDto.setPassword(encryptionService.encryptPassword(customerDto.getPassword()));
        customerDto.setType(customerType);

        return customersService.createCustomerDto(customerDto);
    }
}
