package com.backend.jcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.jcrud.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
}
