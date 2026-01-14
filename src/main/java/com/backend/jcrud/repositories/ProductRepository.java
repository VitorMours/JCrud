package com.backend.jcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.jcrud.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
