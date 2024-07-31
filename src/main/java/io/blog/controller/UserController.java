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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public Response<?> login(@RequestBody LoginRequestDTO log) {
        boolean notExist = service.checkIfUsernameExists(log.getUsername());
        if (notExist) {
            return new Response<>
                    (401, "Incorrect username or password", null);
        }

        boolean equalPassword = service.checkPassword
                (log.getUsername(), log.getPassword());
        if (equalPassword) {
            String username = log.getUsername();
            LoginResponseDTO resp = new LoginResponseDTO
                    (service.getId(username), service.getRole(username));
            return new Response<>(200, "Successfully login", resp);
        } else {
            return new Response<>
                    (401, "Incorrect username or password", null);
        }
    }

    @PostMapping("/register")
    public Response<?> register(@RequestBody RegisterRequestDTO reg) {
        boolean notExist = service.checkIfUsernameExists(reg.getUsername());
        if (notExist) {
            service.register(reg.getUsername(), reg.getPassword());
            return new Response<>
                    (200, "Successfully registered", null);
        } else {
            return new Response<>
                    (409, "Username already exists", null);
        }
    }

    @GetMapping("/user/{user_id}")
    public Response<?> UserInfo(@PathVariable String user_id) {
        boolean IfExist = service.checkIfUserIdExists(user_id);
        if (IfExist) {
            UserResponseDTO resp = service.UserInfoReturn
                    (Integer.parseInt(user_id));
            return new Response<>(200, "Successfully", resp);
        } else {
            return new Response<>(404, "Not Found", null);
        }
    }

    @PutMapping("/user/edit")
    public Response<?> edit(@RequestBody @Validated UserInfo userInfo) {
        service.updateInformation(userInfo);
        UserResponseDTO userResponseDTO = service.UserInfoReturn(userInfo.getId());
        return new Response<>(200, "Successfully", userResponseDTO);
    }

    @PutMapping("/user/password")
    public Response<?> password(@RequestBody PasswordRequestDTO pass) {
        String id = pass.getId();
        String oldPwd = pass.getOldpassword();
        String newPwd = pass.getNewpassword();
        String rePwd = pass.getPasswordrepeat();

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) ||
                !StringUtils.hasLength(rePwd) || !StringUtils.hasLength(id)) {
            return new Response<>(400, "Bad Request", null);
        }

        boolean IfExist = service.checkIfUserIdExists(id);
        if (!IfExist) {
            return new Response<>(404, "Not Found", null);
        }

        if (!rePwd.equals(newPwd)) {
            return new Response<>(400, "Not same Password", null);
        }

        String username = service.findUsernameByUserId(id);

        boolean equalPassword = service.checkPassword
                (username, oldPwd);
        if (equalPassword) {
            service.updatePassword(Integer.parseInt(id), oldPwd, newPwd);
            return new Response<>(200, "Successfully update", null);
        } else {
            return new Response<>
                    (401, "Incorrect  OldPassword", null);
        }
    }
}
