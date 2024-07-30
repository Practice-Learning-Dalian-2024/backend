package io.blog.controller;

import io.blog.model.request.LoginRequestDTO;
import io.blog.model.request.RegisterRequestDTO;
import io.blog.service.UserService;
import io.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService service) {
        this.userService = service;
    }

    @PostMapping("/login")
    public Response<?> login(@RequestBody LoginRequestDTO log) {
        // TODO
        boolean notExist = userService.checkIfUsernameExists(log.getUsername());
        if(notExist){
            return new Response<>(401,"Incorrect username or password",null);
        }

        boolean equalPassword = userService.checkPassword(log.getUsername(), log.getPassword());
        if(equalPassword){
            return new Response<>(200,"Successfully login",null);
        }else {
            return new Response<>(401,"Incorrect username or password",null);
        }
    }

    @PostMapping("/register")
    public Response<?> register(@RequestBody RegisterRequestDTO reg) {
        // TODO
        boolean notExist = userService.checkIfUsernameExists(reg.getUsername());
        if (notExist) {
            userService.register(reg.getUsername(), reg.getPassword());
            return new Response<>(200, "Successfully registered", null);
        } else {
            return new Response<>(409, "Username already exists", null);
        }
    }
}
