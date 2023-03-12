package com.vichar.service;

import com.vichar.DTO.UserDTO;
import com.vichar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserDTO adduser(UserDTO userDTO);

    public UserDTO updateUser(UserDTO userDTO);

    public UserDTO getUserById(Integer userId);

    public List<UserDTO> getAllUser();

    public String deleteUser(Integer userId);
}
