package com.example.coffeedee.repository;

import com.example.coffeedee.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.deleted = false and c.id = :id")
    Customer getCustomerById(Long id);
}