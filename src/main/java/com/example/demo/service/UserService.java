package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    abstract User  selectUserByName(String name);
}
