package com.jcrud.api.resources;

import com.jcrud.api.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotations.RestController;
import org.springframework.web.bind.annotations.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    private ResponseEntity<User> findAll(){

        User default_user = new User(name="Lucas");
        return ResponseEntity.ok().body(default_user);
    }
}