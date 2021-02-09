package com.garr.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garr.ws.entities.Category;
import com.garr.ws.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
