package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.dao.UserDAO;
import com.uxpsystems.assignment.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDAO userDao;

    public List<User> getAllUser(){
        return userDao.findAll();
    }


    public Optional<User> findUserByID(Long id){
        return userDao.findById(id);
    }


    public User addUser(User user){
        return userDao.save(user);
    }

    public User updateUser(User user){
        return userDao.save(user);
    }


    public void deleteUserById(Long id){
        userDao.deleteById(id);

    }
}
