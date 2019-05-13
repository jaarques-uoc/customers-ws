package com.jaarquesuoc.shop.customers.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerDto {

    private String id;

    private String email;

    private String fullName;

    private String address;

    private String country;

    private LocalDateTime creationDate;
}