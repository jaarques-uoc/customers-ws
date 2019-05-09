package com.jaarquesuoc.shop.customers.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Customer {

    private String id;

    private String email;

    private String fullName;

    private String address;

    private String country;

    private LocalDateTime creationDate;
}
