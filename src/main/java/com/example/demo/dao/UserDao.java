package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    abstract void insertUser(User user);//通过实例化的对象user，将数据插入到user表。
    abstract User findUserById(String user_id);//通过用户id查找用户的信息。
    abstract int  verification(String user_id);//用于验证用户是否登录或者注册。
}
