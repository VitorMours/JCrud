package com.backend.jcrud.services;

import org.springframework.stereotype.Service;
import com.backend.jcrud.models.User;
import com.backend.jcrud.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
  
    @Autowired
    private UserRepository userRepository;

    public String getServiceStatus() {
        return "User Service is running.";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
