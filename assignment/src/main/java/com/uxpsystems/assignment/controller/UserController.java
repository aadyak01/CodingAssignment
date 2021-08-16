package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.entity.User;
import com.uxpsystems.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/auth")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public List<User> loadAllUsers(){
         return userService.getAllUser();
    }

    @GetMapping("/getUserById/{id}")
    public Optional<User> findByID(@PathVariable Long id){
            return  userService.findUserByID(id);

    }

    @PostMapping("/postUser")
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);

    }
}
