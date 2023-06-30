package com.devmountain.noteApp2.services;

import com.devmountain.noteApp2.DTO.UserDTO;
import com.devmountain.noteApp2.entities.User;
import com.devmountain.noteApp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder PasswordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDTO userDTO) {
        List<String> response = new ArrayList<>();
        User user = new User(userDTO);
        userRepository.saveAndFlush(user);
        response.add("User added successfully");
        return response;
    }

    @Override
    public List<String> userLogin(UserDTO userDTO) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDTO.getUsername());
        if(userOptional.isPresent()) {
            if(PasswordEncoder.matches(userDTO.getPassword(), userOptional.get().getPassword())) {
                response.add("User login successful");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password is incorrect");
            }
        } else {
            response.add("Username or password is incorrect");
        }
        return response;
    }


}
