package io.blog.model.database;

import lombok.Data;

/*
CREATE TABLE IF NOT EXISTS blog
(
    id            SERIAL PRIMARY KEY,
    author        INT REFERENCES user_info (id) NOT NULL,
    title         VARCHAR(255)                  NOT NULL,
    content_path  VARCHAR(255)                  NOT NULL,
    time          TIMESTAMP                     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    category      SMALLINT                      NOT NULL,
    visitor_count INT                           NOT NULL DEFAULT 0,
    like_count    INT                           NOT NULL DEFAULT 0,
    status        SMALLINT                      NOT NULL DEFAULT 0,
    brief         VARCHAR(255)                  NOT NULL
);
 */

@Data
public class Blog {
    private int id;
    private int author;
    private String title;
    private String contentPath;
    private long time;
    private short category;
    private int visitorCount;
    private int likeCount;
    private short status;
    private String brief;
}
