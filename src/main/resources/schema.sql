CREATE TABLE IF NOT EXISTS m_user (
    user_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(256),
    password VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS t_micropost (
    micropost_id VARCHAR(10) PRIMARY KEY,
    content VARCHAR(1024),
    user_id VARCHAR(10),
    posted_datetime DATETIME
);

CREATE TABLE IF NOT EXISTS t_follow (
    follow_id VARCHAR(10) PRIMARY KEY,
    following_user_id VARCHAR(10),
    followed_user_id VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS m_sequence (
    id_name VARCHAR(256) PRIMARY KEY,
    prefix CHAR(2),
    current_number INT
);