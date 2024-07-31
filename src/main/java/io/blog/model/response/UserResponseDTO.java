package io.blog.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private int id;
    private boolean canceled;
    private String username;
    private String name;
    private boolean role;
    private Date birthday;
    private String gender;
    private String registerTime;
    private String avatarPath;
    private String email;
    private String phone;
    private String site;
    private String bio;
}
