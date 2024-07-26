package io.blog.model.database;

import lombok.Data;

/*
CREATE TABLE IF NOT EXISTS admin
(
    id      SERIAL PRIMARY KEY,
    user_id INT REFERENCES user_info (id) ON DELETE CASCADE NOT NULL
);
 */

@Data
public class Admin {
    private String id;
    private String userId;
}
