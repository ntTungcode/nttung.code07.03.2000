package com.example.coffeedee.repository;

import com.example.coffeedee.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query("select w from Warehouse w where w.deleted = false")
    List<Warehouse> getWarehouses();

    @Query("select w from Warehouse w  where w.deleted = false and w.product.id = ?1")
    Warehouse getWarehouseByProductId(Long productId);

}
