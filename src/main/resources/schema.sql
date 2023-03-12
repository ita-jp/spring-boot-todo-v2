CREATE TABLE tasks
(
    id           BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title        VARCHAR(256) NOT NULL,
    is_completed BOOLEAN      NOT NULL DEFAULT FALSE
);