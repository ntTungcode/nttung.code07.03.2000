package com.example.coffeedee.repository;

import com.example.coffeedee.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.deleted = false and o.id = :id")
    Order getOrderById(Long id);
}