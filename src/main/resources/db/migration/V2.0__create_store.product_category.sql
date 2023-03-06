DROP TABLE IF EXISTS store.product_category CASCADE;

CREATE TABLE store.product_category (
    id              bigserial NOT NULL,
    name            VARCHAR(100),
    description     TEXT
);

ALTER TABLE store.product_category
    ADD CONSTRAINT product_category_pk PRIMARY KEY ( id );