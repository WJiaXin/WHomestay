package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    abstract void insertUser(User user);
    abstract User findUserById(String user_id);
    abstract int  verification(String user_id);
}
