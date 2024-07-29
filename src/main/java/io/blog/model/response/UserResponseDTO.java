package io.blog.model.response;

import lombok.Data;

@Data
public class UserCommonInfo {
    private int id;
    private boolean canceled;
    private String username;
    private String name;
    private boolean role;
    private String gender;
    private String registerTime;
    private String avatarPath;
    private String email;
    private String phone;
    private String site;
    private String bio;
}
