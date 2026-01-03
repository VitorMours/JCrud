package com.backend.jcrud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.jcrud.models.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
