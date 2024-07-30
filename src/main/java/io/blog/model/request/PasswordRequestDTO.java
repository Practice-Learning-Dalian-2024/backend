package io.blog.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordRequestDTO {
    String id;
    String oldpassword;
    String newpassword;
    String passwordrepeat;
}
