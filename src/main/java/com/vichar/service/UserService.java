package com.vichar.service;

import com.vichar.DTO.UserDTO;
import com.vichar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO adduser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO getUserById(Integer userId);

    List<UserDTO> getAllUser();

    String deleteUser(Integer userId);
}
