package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    abstract User  selectUserByName(String name);
}
