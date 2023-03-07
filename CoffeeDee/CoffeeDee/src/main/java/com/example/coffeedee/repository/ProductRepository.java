package com.example.coffeedee.repository;

import com.example.coffeedee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.deleted = false and p.id = :id")
    Product findProductById(Long id);

    @Query("select p from Product p where p.deleted = false")
    List<Product> getProducts();

    @Query("select p from Product p where p.deleted = false and p.category.id = :id")
    List<Product> getProductsByCategoryId(Long id);

    @Query("select p from Product p where p.deleted = false and p.productName like concat('%',:searchText,'%') or p.description like concat('%',:searchText,'%')")
    List<Product> findProductsByProductNameOrDescription(String searchText);
}
