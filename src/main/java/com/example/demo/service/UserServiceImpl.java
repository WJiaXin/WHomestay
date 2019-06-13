package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public void insertUser(User user){
         userDao.insertUser(user);
    }
    @Override
    public User findUserById(String user_id){
        return userDao.findUserById(user_id);
    }
    public int verification(String user_id){
        return userDao.verification(user_id);
    }
}
