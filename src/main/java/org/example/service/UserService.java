package org.example.service;

import org.example.domaine.User;
import org.example.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}