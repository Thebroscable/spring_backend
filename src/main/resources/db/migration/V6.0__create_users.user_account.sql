DROP TABLE IF EXISTS users.user_account CASCADE;

CREATE TABLE users.user_account (
    id             bigserial NOT NULL,
    email          VARCHAR(255) NOT NULL,
    password       VARCHAR(255) NOT NULL
);
ALTER TABLE users.user_account ADD CONSTRAINT user_account_pk PRIMARY KEY ( id );