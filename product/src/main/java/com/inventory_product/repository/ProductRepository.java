package com.inventory_product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory_product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
	Optional<Product> findByProductId(String productId);

}


