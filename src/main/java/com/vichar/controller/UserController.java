package com.vichar.controller;

import com.vichar.DTO.UserDTO;
import com.vichar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vichar/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public ResponseEntity<UserDTO> addUserHandler(@Valid @RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = this.userService.adduser(userDTO);
        return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<UserDTO> updateUserHandler(@Valid @RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = this.userService.updateUser(userDTO);
        return new ResponseEntity<>(userDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserHandler(@PathVariable Integer userId) {
        String message = this.userService.deleteUser(userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUserHandler() {
        List<UserDTO> userDTO1 = this.userService.getAllUser();
        return new ResponseEntity<>(userDTO1, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByIdHandler(@PathVariable Integer userId) {
        UserDTO userDTO1 = this.userService.getUserById(userId);
        return new ResponseEntity<>(userDTO1, HttpStatus.OK);
    }


}
