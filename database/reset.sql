DROP TABLE IF EXISTS user_info;
CREATE TABLE IF NOT EXISTS user_info
(
    id            SERIAL PRIMARY KEY,
    cancelled     BOOLEAN            NOT NULL DEFAULT FALSE,
    username      VARCHAR(40) UNIQUE NOT NULL,
    name          VARCHAR(70),
    birthday      DATE,
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

DROP TABLE IF EXISTS common_user;
CREATE TABLE IF NOT EXISTS common_user
(
    id      SERIAL PRIMARY KEY,
    user_id INT REFERENCES user_info (id) ON DELETE CASCADE NOT NULL
);

DROP TABLE IF EXISTS admin;
CREATE TABLE IF NOT EXISTS admin
(
    id      SERIAL PRIMARY KEY,
    user_id INT REFERENCES user_info (id) ON DELETE CASCADE NOT NULL
);

DROP TABLE IF EXISTS blog;
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

DROP TABLE IF EXISTS comment;
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