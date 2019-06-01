package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.VerifyCode;
import com.example.demo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

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
    @RequestMapping(value="/createImg")
    public void createImg(HttpServletResponse response, HttpServletRequest  request) throws IOException {
        //创建对象
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage bi = vc.getImage();
        //获得图片的文本内容
        String text = vc.getText();
        // 将系统生成的文本内容保存到session中
        request.getSession().setAttribute("text", text);
        //向浏览器输出图片
        vc.output(bi, response.getOutputStream());
    }
}
