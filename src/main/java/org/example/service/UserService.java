package org.example.service;

import org.example.domaine.User;
import org.example.errors.EmailExistException;
import org.example.errors.UserIsEmptyException;
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
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new UserIsEmptyException();
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailExistException();
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