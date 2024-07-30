package io.blog.controller;

import io.blog.service.UserService;
import io.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response<?> login() {
        // TODO
        return null;
    }

    @PostMapping("/register")
    public Response<?> register(String username, String password) {
        // TODO
        boolean notExist = userService.checkIfUsernameExists(username);
        if (notExist) {
            userService.register(username, password);
            return new Response<>(200, "Successfully registered", null);
        } else {
            return new Response<>(409, "Username already exists", null);
        }
    }
}
