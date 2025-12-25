package com.backend.jcrud.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.jcrud.models.Post;
import com.backend.jcrud.models.User;
import com.backend.jcrud.repositories.PostRepository;
import com.backend.jcrud.repositories.UserRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Post> getAllPosts() {
        List<Post> postsList = postRepository.findAll();
        return postsList;
    }

    public Post findById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        return post;
    }

    @Transactional
    public Post create(Post postDetails) {
        User postUser = postDetails.getUser();

        if (postUser == null) {
            throw new IllegalArgumentException("O usuário (owner) deve ser fornecido para criar um Post.");
        }

        User userToSet;
        if (postUser.getId() != null) {
            userToSet = userRepository.findById(postUser.getId()).orElseGet(() -> {
                postUser.setId(null);
                return userRepository.save(postUser);
            });
        } else {
            userToSet = userRepository.save(postUser);
        }

        postDetails.setUser(userToSet);
        Post newPost = postRepository.save(postDetails);
        return newPost;
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            Post updatedPost = postRepository.save(post);
            return updatedPost;
        }
        return null;
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
