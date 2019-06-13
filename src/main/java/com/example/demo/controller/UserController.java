package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.VerifyCode;
import com.example.demo.service.UserServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    //依赖注入
    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/createImg")
    public void createImg(HttpServletResponse response, HttpServletRequest request) throws IOException {
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

    //注册后台方法
    @RequestMapping(value = "/register")
    public void register(HttpServletResponse response, HttpServletRequest request) throws IOException {
        User user = new User();//创建一个user对象

        PrintWriter printWriter = response.getWriter();
        //获取前端由ajax传过来的值
        String user_id = request.getParameter("user_id");
        String user_name = request.getParameter("user_name");
        String user_pwd = request.getParameter("user_pwd1");
        String inputCordZ = request.getParameter("inputCordZ");
        //获取验证码的值
        String text = request.getParameter("text");//获取验证码的值
        int flag = userService.verification(user_id);//查询用户是否已经注册
        if ((!inputCordZ.equals(text)) && flag == 0) { //判断用户是否已经注册， //判断验证码是否输入正确
            //实例化user对象
            user.setUser_id(user_id);
            user.setUser_name(user_name);
            user.setUser_pwd(user_pwd);
            //调用Service层方法将数据插入数据库
            userService.insertUser(user);
            printWriter.print(9);//用户已经注册，返回9
            //创建用户文件夹
            File file = new File("C:/Users/liutong/IdeaProjects/Homestay/target/classes/static/img/user/" + user_id);
            // 指定路径如果没有则创建并添加
            //获取父目录
            File fileParent = file.getParentFile();
          //判断是否存在
            if (!fileParent.exists()) {
                //创建父目录文件
                fileParent.mkdirs();
            }
            file.mkdir();
        }
    }

    //登录后台方法
    @RequestMapping(value = "/login")
    public void login(HttpServletResponse response, HttpServletRequest request) throws IOException {
        User user = new User();//创建一个user对象
        PrintWriter printWriter = response.getWriter();
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage bi = vc.getImage();
        //获得图片的文本内容
        String text = vc.getText();
        //获取前端由ajax传过来的值
        String user_id = request.getParameter("inputPhone");
        String user_pwd = request.getParameter("inputPassword");
        String inputCordZ = request.getParameter("inputCord1");
        //获取验证码的值
        System.out.println("！！！！！！！！！！！！inputCordZ值： "+inputCordZ);
        System.out.println("！！！！！！！！！！！！！！！！！！！text值： "+text);
        System.out.println("！！！！！！！！！！！！！！！！！！！输入密码值： "+user_pwd);
        int flag = userService.verification(user_id);//查看该id在user表中是否有记录。
        //判断验证码是否输入正确
        if (flag != 0) {
            user = userService.findUserById(user_id); //通过id，找到用户所有信息
            System.out.println("！！！！！！！！！！！！！！！！！！！正确密码值： "+user.getUser_pwd());
            if (!inputCordZ.equals(text) && user.getUser_pwd().equals(user_pwd)) {//判断验证码和密码是否输入正确
                JSONObject json = JSONObject.fromObject(user);
                printWriter.print(json.toString());
                request.setAttribute("userLogin", user);//密码正确，将用户信息发送带缓存。
            }
        }
    }
    //获取信息
    @RequestMapping(value = "/getInFo")
    public void getInFo(HttpServletResponse response, HttpServletRequest request) throws IOException{
        User user =new User();
        user = (User)request.getAttribute("userLogin");
        PrintWriter printWriter = response.getWriter();
        JSONObject json = JSONObject.fromObject(user);
        printWriter.print(json.toString());
    }
    @RequestMapping(value = "/upInFo")
    public void upInFo(HttpServletResponse response, HttpServletRequest request) throws IOException{

    }
}
