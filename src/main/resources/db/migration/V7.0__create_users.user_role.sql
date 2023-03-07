DROP TABLE IF EXISTS users.user_role CASCADE;

CREATE TABLE users.user_role (
    id             bigserial NOT NULL,
    name           VARCHAR(100) NOT NULL,
    description    TEXT
);

ALTER TABLE users.user_role ADD CONSTRAINT user_role_pk PRIMARY KEY ( id );