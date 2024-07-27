package io.blog.service;

import io.blog.mapper.UserMapper;
import io.blog.model.database.UserInfo;
import io.blog.util.RandomStringGenerator;
import io.blog.util.SHA256Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public int register(String username, String password) {
        String salt = RandomStringGenerator.generateRandomString(16);
        String saltedPassword = password + salt;
        String hash = SHA256Generator.generateSHA256Hash(saltedPassword);
        UserInfo info = new UserInfo();
        info.setUsername(username);
        info.setPasswordHash(hash);
        info.setSalt(salt);
        mapper.create(info);
        // TODO
        return 0;
    }

    public boolean updatePassword
            (int id, String oldPassword, String newPassword) {
        throw new RuntimeException("TODO"); // TODO
    }

    public void updateInformation(UserInfo info) {
        throw new RuntimeException("TODO"); // TODO
    }
}
