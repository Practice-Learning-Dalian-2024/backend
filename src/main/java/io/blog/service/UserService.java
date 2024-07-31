package io.blog.service;

import io.blog.mapper.UserMapper;
import io.blog.model.database.UserInfo;
import io.blog.model.response.UserResponseDTO;
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

    public void register(String username, String password) {
        String salt = RandomStringGenerator.generateRandomString(16);
        String saltedPassword = password + salt;
        String hash = SHA256Generator.generateSHA256Hash(saltedPassword);
        UserInfo info = new UserInfo();
        info.setUsername(username);
        info.setPasswordHash(hash);
        info.setSalt(salt);
        mapper.create(info);
    }

    public void updatePassword
            (int id, String oldPassword, String newPassword) {
        String salt = RandomStringGenerator.generateRandomString(16);
        String saltedPassword = newPassword + salt;
        String hash = SHA256Generator.generateSHA256Hash(saltedPassword);
        mapper.updatePassword(id, salt, hash);
    }

    public void updateInformation(UserInfo info) {
        mapper.update(info);
    }

    public boolean checkIfUsernameExists(String username) {
        String str = mapper.findUsername(username);
        return str == null;
    }

    public boolean checkPassword(String username, String password) {

        String salt = mapper.findUserSalt(username);
        String saltedPassword = password + salt;
        String hash = mapper.findUserHash(username);

        return hash.equals(SHA256Generator.generateSHA256Hash(saltedPassword));
    }

    public boolean getRole(String username) {
        return mapper.getIsAdmin(username);
    }

    public boolean checkIfUserIdExists(String userId) {
        Integer id = mapper.findUserId(Integer.parseInt(userId));
        return id != null;
    }

    public UserResponseDTO UserInfoReturn(int id) {
        return mapper.read(id);
    }

    public String findUsernameByUserId(String id) {
        Integer user_id = Integer.parseInt(id);
        return mapper.findUsernameByUserId(user_id);
    }

    public Integer getId(String username) {
        return mapper.getIdByUsername(username);
    }

    public void follow(int follower, int followee) {
        if (mapper.isFollowing(follower, followee)) {
            mapper.unfollow(follower, followee);
        } else {
            mapper.follow(follower, followee);
        }
    }
}
