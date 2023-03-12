package com.vichar.serviceimpl;

import com.vichar.DTO.UserDTO;
import com.vichar.exception.UserException;
import com.vichar.model.User;
import com.vichar.repository.UserDao;
import com.vichar.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;


    private User dtoToUser(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO, User.class);
        return user;
    }

    private UserDTO userToDto(User user) {
        UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO adduser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);

        User savedUser = this.userDao.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user =
                this.userDao.findById(userDTO.getId()).orElseThrow(() -> new UserException("User not found with this " +
                        "id : " + userDTO.getId()));


        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());
        User updatedUser = this.userDao.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user =
                this.userDao.findById(userId).orElseThrow(() -> new UserException("User not found with this id : " + userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = this.userDao.findAll();

        List<UserDTO> userDTOS = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public String deleteUser(Integer userId) {
        User user =
                this.userDao.findById(userId).orElseThrow(() -> new UserException("User not found with this id : " + userId));

        this.userDao.delete(user);

        return "User deleted successfully";
    }
}
