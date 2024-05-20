CREATE TABLE to_do_entity
(
    id       SERIAL PRIMARY KEY,
    title   VARCHAR(64)       NOT NULL,
    content  VARCHAR(256)      NOT NULL
);

