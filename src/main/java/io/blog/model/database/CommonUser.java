package io.blog.model.database;

import lombok.Data;

/*
CREATE TABLE IF NOT EXISTS common_user
(
    id      SERIAL PRIMARY KEY,
    user_id INT REFERENCES user_info (id) ON DELETE CASCADE NOT NULL
);
 */

@Data
public class CommonUser {
    private String id;
    private String userId;
}
