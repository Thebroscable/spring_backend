DROP TABLE IF EXISTS users.account2role CASCADE;

CREATE TABLE users.account2role (
    id                  bigserial NOT NULL,
    user_account_id     bigserial NOT NULL,
    user_role_id        bigserial NOT NULL
);

ALTER TABLE users.account2role ADD CONSTRAINT login2role_pk PRIMARY KEY ( id );

ALTER TABLE users.account2role
    ADD CONSTRAINT account2role_account_fk FOREIGN KEY ( user_account_id )
        REFERENCES users.user_account ( id );

ALTER TABLE users.account2role
    ADD CONSTRAINT account2role_role_fk FOREIGN KEY ( user_role_id )
        REFERENCES users.user_role ( id );
