package io.blog.controller;

import io.blog.model.database.UserInfo;
import io.blog.model.request.LoginRequestDTO;
import io.blog.model.request.PasswordRequestDTO;
import io.blog.model.request.RegisterRequestDTO;
import io.blog.model.response.LoginResponseDTO;
import io.blog.model.response.UserResponseDTO;
import io.blog.service.UserService;
import io.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
        boolean notExist = userService.checkIfUsernameExists(log.getUsername());
        if (notExist) {
            return new Response<>
                    (401, "Incorrect username or password", null);
        }

        boolean equalPassword = userService.checkPassword
                (log.getUsername(), log.getPassword());
        if (equalPassword) {
            LoginResponseDTO resp = new LoginResponseDTO
                    (userService.getRole(log.getUsername()));
            return new Response<>(200, "Successfully login", resp);
        } else {
            return new Response<>
                    (401, "Incorrect username or password", null);
        }
    }

    @PostMapping("/register")
    public Response<?> register(@RequestBody RegisterRequestDTO reg) {
        boolean notExist = userService.checkIfUsernameExists(reg.getUsername());
        if (notExist) {
            userService.register(reg.getUsername(), reg.getPassword());
            return new Response<>
                    (200, "Successfully registered", null);
        } else {
            return new Response<>
                    (409, "Username already exists", null);
        }
    }

    @GetMapping("/user/{user_id}")
    public Response<?> UserInfo(@PathVariable String user_id){
        boolean IfExist = userService.checkIfUserIdExists(user_id);
        if(IfExist){
            UserResponseDTO resp = userService.UserInfoReturn
                    (Integer.parseInt(user_id));
            return new Response<>(200,"Successfully",resp);
        }else {
            return new Response<>(404,"Not Found",null);
        }
    }

    @PutMapping("/user/edit")
    public Response<?> edit(@RequestBody UserInfo userInfo){
        userService.updateInformation(userInfo);
        return new Response<>(200,"Successfully",userInfo);
    }

    @PutMapping("/user/password")
    public Response<?> password(@RequestBody PasswordRequestDTO pass){
        String id = pass.getId();
        String oldPwd = pass.getOldpassword();
        String newPwd = pass.getNewpassword();
        String rePwd = pass.getPasswordrepeat();

        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) ||
        !StringUtils.hasLength(rePwd) || !StringUtils.hasLength(id) ){
            return new Response<>(400,"Bad Request",null);
        }

        boolean IfExist = userService.checkIfUserIdExists(id);
        if(!IfExist){
            return new Response<>(404,"Not Found",null);
        }

        if(!rePwd.equals(newPwd)){
            return new Response<>(400,"Not same Password",null);
        }

        String username = userService.findUsernameByUserId(id);

        boolean equalPassword = userService.checkPassword
                (username, oldPwd);
        if (equalPassword) {
             userService.updatePassword(Integer.parseInt(id),oldPwd,newPwd);
             return new Response<>(200,"Successfully update",null);
        } else {
            return new Response<>
                    (401, "Incorrect  OldPassword", null);
        }
    }
}
