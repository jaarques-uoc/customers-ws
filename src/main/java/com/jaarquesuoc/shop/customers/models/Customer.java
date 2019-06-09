package com.jaarquesuoc.shop.customers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

    @Indexed(unique=true)
    private String email;

    private String encryptedPassword;

    private String fullName;

    private String address;

    private String country;

    @Builder.Default()
    private LocalDateTime date = LocalDateTime.now();

    private String role;
}
