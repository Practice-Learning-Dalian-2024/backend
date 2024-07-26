package io.blog.controller;

import io.blog.util.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class AuthController {
    @PostMapping("/login")
    public Response<?> login() {
        // TODO
        return null;
    }

    @PostMapping("/register")
    public Response<?> register() {
        // TODO
        return null;
    }
}
