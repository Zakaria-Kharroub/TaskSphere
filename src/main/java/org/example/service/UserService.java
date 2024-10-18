package org.example.service;

import org.example.domaine.User;
import org.example.errors.UserIsNullException;
import org.example.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public void saveUser(User user) {
        if (user == null) {
            throw new UserIsNullException();
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("name obligatoire");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("email not null ou empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("password not null ou empty");
        }
        if (user.getRole() == null) {
            throw new IllegalArgumentException("role not null");
        }

        // Check for existing email
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("email already used");
        }

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


//    public void updateTokenDelete(User user) {
//        userRepository.updateTokenDelete(user);
//    }
}