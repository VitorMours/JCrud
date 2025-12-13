package com.backend.jcrud.services; 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.jcrud.models.Post;
import com.backend.jcrud.repositories.PostRepository; 

@Service 
public class PostService {

    @Autowired 
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        List<Post> postsList = postRepository.findAll(); 
        return postsList;
    }

    public Post findById(Long id){
        Post post = postRepository.findById(id).orElse(null);
        return post;
    }

    public Post create(Post post){
        Post newPost = postRepository.save(post);
        return newPost;
    }

    public Post updatePost(Long id, Post postDetails){
        Post post = postRepository.findById(id).orElse(null);
        if(post != null){
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            Post updatedPost = postRepository.save(post);
            return updatedPost;
        }
        return null;
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }
}

