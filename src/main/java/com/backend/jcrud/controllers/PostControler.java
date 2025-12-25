package com.backend.jcrud.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.backend.jcrud.models.Post;
import com.backend.jcrud.services.PostService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post searchedPost = postService.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(searchedPost);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        System.out.println(post);
        Post newPost = postService.create(post);
        return ResponseEntity.ok().body(newPost);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails){
        Post updatedPost = postService.updatePost(id, postDetails);
        return ResponseEntity.ok().body(updatedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
