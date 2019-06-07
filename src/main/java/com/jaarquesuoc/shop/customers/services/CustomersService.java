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

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomersService {

    private final CustomersRepository customersRepository;

    public List<CustomerDto> getAllCustomerDtos() {
        List<Customer> customers = customersRepository.findAll();

        return CustomersMapper.INSTANCE.toCustomerDtos(customers);
    }

    public Optional<CustomerDto> getCustomerDtoById(final String id) {
        return customersRepository.findById(id)
            .map(CustomersMapper.INSTANCE::toCustomerDto);
    }

    public Optional<Customer> getCustomerByEmail(final CustomerDto customerDto) {
        return customersRepository.findByEmail(customerDto.getEmail());
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
