package com.example.user_service.controllers;


import com.example.user_service.entities.User;
import com.example.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // Set other fields as needed
        
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

//@GetMapping
//public List<User> getAllUsers() {
//    List<User> users = userRepository.findAll();
//    System.out.println("Retrieved users: " + users); // This will print the toString() from @Data
//    return users;
//}
//@PostMapping
//public User createUser(@RequestBody User user) {
//    System.out.println("Received user: " + user); // Print the received user object
//    User savedUser = userRepository.save(user);
//    System.out.println("Saved user: " + savedUser); // Print the saved user object
//    return savedUser;
//}
}