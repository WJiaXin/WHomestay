package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    //依赖注入
    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/find")
    public String findUserByName(HttpSession session) {
        //调用dao层
        User user = userService.selectUserByName("test");
        session.setAttribute("user",user);
        return "home";//返回的是Json数据，因为RestController注解中有@ResponseBody的作用
    }

}
