package com.backend.jcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.jcrud.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
