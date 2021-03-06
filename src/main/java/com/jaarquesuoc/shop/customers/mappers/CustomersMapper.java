package com.jaarquesuoc.shop.customers.mappers;

import com.jaarquesuoc.shop.customers.dtos.CustomerDto;
import com.jaarquesuoc.shop.customers.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomersMapper {

    CustomersMapper INSTANCE = Mappers.getMapper(CustomersMapper.class);

    @Mapping(target = "password", ignore = true)
    CustomerDto toCustomerDto(Customer customer);

    @Mapping(target = "encryptedPassword", source = "password")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    Customer toCustomer(CustomerDto customerDto);

    List<CustomerDto> toCustomerDtos(List<Customer> customers);
}
