package io.blog.mapper;

import io.blog.model.database.UserInfo;
import io.blog.model.response.UserCommonInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // Can CREATE, READ, UPDATE, and DELETE user.
    void create(UserInfo user);

    void update(UserInfo user);

    void delete(int id);

    UserCommonInfo read(int id);

    List<UserCommonInfo> readAll();

    void updatePassword(int id, String salt, String passwordHash);
}
