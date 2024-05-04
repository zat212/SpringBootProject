//package com.assignment.testproject.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public void createUser(User user) {
//        userRepository.save(user);
//    }
//    public boolean authenticateUser(String username, String password) {
//        User user = userRepository.findByEmail(username);
//        return user != null && user.getPassword().equals(password);
//    }
//}
