package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;


@RequestMapping(value = "/img")
@Controller
public class ImgPush {

    @RequestMapping(value = "/pimg")                       //上传图片
    public void img(HttpServletResponse httpServletResponse,@RequestParam("file") MultipartFile file) throws IOException {

        System.out.println("开始");

        PrintWriter printWriter = httpServletResponse.getWriter();
       System.out.println("长度:"+file.isEmpty());
        File savePath = new File("C:/Users/魏嘉欣/eclipse-workspace/Homestay/target/classes/static/img/space");
        System.out.println(savePath.getPath());
        String fileName=file.getOriginalFilename();
        try {

                    if (fileName.indexOf("\\") >= 0) {
                        long date = new Date().getTime();
                        fileName=date+fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());

                        System.out.println(fileName);
                    }else {
                        long date = new Date().getTime();
                        fileName=date+fileName;
                    }
            System.out.println("1:"+fileName);
                    // 写入文件到保存路径中
            Files.copy(file.getInputStream(), new File(savePath, fileName).toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("失败");

        }
        if(file==null) {
            printWriter.print("0");
        }
        else {
            printWriter.print(fileName);
        }
    }

}