package io.blog.controller;

import io.blog.model.database.UserInfo;
import io.blog.service.UserService;
import io.blog.util.Response;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class AuthController {


    private UserService userService;

    @PostMapping("/login")
    public Response<?> login() {
        // TODO
        return null;
    }

    @PostMapping("/register")
    public Response<?> register(String username,String password) {
        // TODO
        //判断用户名是否重复
        UserInfo userInfo = userService.findByUserName(username);
        if(userInfo == null){
            userService.register(username,password);
            return Response.success();
        }else {
            return Response.error("用户名已存在");
        }
    }
}
