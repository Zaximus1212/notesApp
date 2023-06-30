package com.devmountain.noteApp2.services;

import com.devmountain.noteApp2.DTO.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDTO userDTO);

    List<String> userLogin(UserDTO userDTO);
}
