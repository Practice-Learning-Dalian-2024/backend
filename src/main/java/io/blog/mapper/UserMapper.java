package io.blog.mapper;

import io.blog.model.database.UserInfo;
import io.blog.model.response.UserResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // Can CREATE, READ, UPDATE, and DELETE user.
    void create(UserInfo user);

    void update(UserInfo user);

    void delete(int id);

    UserResponseDTO read(int id);

    List<UserResponseDTO> readAll();

    void updatePassword(int id, String salt, String passwordHash);

    String findUsername(String username);

    String findUserSalt(String username);

    String findUserHash(String username);

    boolean getIsAdmin(String username);

    Integer findUserId(int id);

    String findUsernameByUserId(Integer userId);

    int getIdByUsername(String username);
}
