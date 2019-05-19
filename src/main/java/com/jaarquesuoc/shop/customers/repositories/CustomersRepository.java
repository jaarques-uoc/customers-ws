package com.jaarquesuoc.shop.customers.repositories;

import com.jaarquesuoc.shop.customers.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomersRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmailAndPassword(final String email, final String password);

    Long countByEmail(final String email);
}
