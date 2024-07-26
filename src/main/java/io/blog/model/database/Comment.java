package io.blog.model.database;

import lombok.Data;

/*
CREATE TABLE IF NOT EXISTS comment
(
    id         SERIAL PRIMARY KEY,
    commenter  INT REFERENCES user_info (id)              NOT NULL,
    blog       INT REFERENCES blog (id) ON DELETE CASCADE NOT NULL,
    is_nested  BOOLEAN                                    NOT NULL,
    parent     INT REFERENCES comment (id) ON DELETE CASCADE,
    content    TEXT                                       NOT NULL,
    time       TIMESTAMP                                  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    like_count INT                                        NOT NULL DEFAULT 0,
    status     SMALLINT                                   NOT NULL DEFAULT 0
);
 */

@Data
public class Comment {
    private int id;
    private int commenter;
    private int blog;
    private boolean isNested;
    private int parent;
    private String content;
    private long time;
    private int likeCount;
    private short status;
}
