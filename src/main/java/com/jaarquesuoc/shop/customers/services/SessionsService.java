package com.jaarquesuoc.shop.customers.services;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.dtos.CustomerRole;
import com.jaarquesuoc.shop.customers.mappers.CustomersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.jaarquesuoc.shop.customers.dtos.CustomerRole.ADMIN;
import static com.jaarquesuoc.shop.customers.dtos.CustomerRole.CUSTOMER;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SessionsService {

    private final EncryptionService encryptionService;

    private final CustomersService customersService;

    public Optional<CustomerDto> login(final CustomerDto customerDto) {
        return customersService.getCustomerByEmail(customerDto.getEmail())
                .filter(
                        customer -> encryptionService
                                .matchesPassword(customerDto.getPassword(), customer.getEncryptedPassword())
                )
                .map(CustomersMapper.INSTANCE::toCustomerDto);
    }

    public Optional<CustomerDto> customerSignup(final CustomerDto customerDto) {
        return signup(customerDto, CUSTOMER);
    }

    public Optional<CustomerDto> adminSignup(final CustomerDto customerDto) {
        return signup(customerDto, ADMIN);
    }

    public Optional<CustomerDto> signup(final CustomerDto customerDto, final CustomerRole customerRole) {
        customerDto.setPassword(encryptionService.encryptPassword(customerDto.getPassword()));
        customerDto.setRole(customerRole);

        return customersService.createCustomerDto(customerDto);
    }
}
