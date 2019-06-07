package com.jaarquesuoc.shop.customers.services;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.exceptions.UserExistsException;
import com.jaarquesuoc.shop.customers.mappers.CustomersMapper;
import com.jaarquesuoc.shop.customers.models.Customer;
import com.jaarquesuoc.shop.customers.repositories.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomersService {

    private final EncryptionService encryptionService;

    private final CustomersRepository customersRepository;

    public List<CustomerDto> getAllCustomerDtos() {
        return customersRepository.findAll().stream()
            .map(CustomersMapper.INSTANCE::toCustomerDto)
            .collect(toList());
    }

    public Optional<CustomerDto> getCustomerDtoById(final String id) {
        return customersRepository.findById(id)
            .map(CustomersMapper.INSTANCE::toCustomerDto);
    }

    public Optional<CustomerDto> getCustomerDtoByEmailAndPassword(final CustomerDto customerDto) {
        return customersRepository.findByEmail(customerDto.getEmail())
            .filter(customer -> encryptionService.matchesPassword(customerDto.getPassword(), customer.getPassword()))
            .map(CustomersMapper.INSTANCE::toCustomerDto);
    }

    public Optional<CustomerDto> createCustomerDto(final CustomerDto customerDto) {
        if (customersRepository.countByEmail(customerDto.getEmail()) > 0) {
            throw new UserExistsException(customerDto.getEmail());
        }

        Customer customer = CustomersMapper.INSTANCE.toCustomer(customerDto);
        CustomerDto createdCustomerDto = CustomersMapper.INSTANCE.toCustomerDto(customersRepository.save(customer));

        return Optional.ofNullable(createdCustomerDto);
    }

    public void cleanDb() {
        customersRepository.deleteAll();
    }
}
