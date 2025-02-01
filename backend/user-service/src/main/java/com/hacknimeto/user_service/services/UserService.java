package com.hacknimeto.user_service.services;

import com.hacknimeto.user_service.entities.User;
import com.hacknimeto.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        return (BCrypt.checkpw(password, user.getPassword()))? user : null;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
