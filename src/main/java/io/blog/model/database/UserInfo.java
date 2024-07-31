package io.blog.model.database;

import lombok.Data;

import java.sql.Date;

/*
CREATE TABLE IF NOT EXISTS user_info
(
    id            SERIAL PRIMARY KEY,
    cancelled     BOOLEAN            NOT NULL DEFAULT FALSE,
    username      VARCHAR(40) UNIQUE NOT NULL,
    name          VARCHAR(70),
    role          BOOLEAN            NOT NULL DEFAULT FALSE,
    gender        VARCHAR(255)       NOT NULL DEFAULT 'uncertain',
    salt          CHAR(16)           NOT NULL,
    password_hash CHAR(64)           NOT NULL,
    register_time TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    avatar_path   VARCHAR(255),
    email         VARCHAR(100),
    phone         VARCHAR(20),
    site          VARCHAR(255),
    bio           TEXT
);
 */

@Data
public class UserInfo {
    private int id;
    private boolean cancelled;
    private String username;
    private String name;
    private Date birthday;
    private boolean role;
    private String gender;
    private String salt;
    private String passwordHash;
    private long registerTime;
    private String avatarPath;
    private String email;
    private String phone;
    private String site;
    private String bio;
}
