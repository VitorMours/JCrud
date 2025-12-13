package com.backend.jcrud.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.backend.jcrud.models.Post;
import com.backend.jcrud.services.PostService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController 
@RequestMapping("/posts")
public class PostControler {

    @Autowired 
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok().body(posts);
    }


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post newPost = postService.create(post);
        return ResponseEntity.ok().body(newPost);
    }

}
