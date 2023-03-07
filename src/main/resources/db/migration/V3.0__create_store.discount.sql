DROP TABLE IF EXISTS store.discount CASCADE;

CREATE TABLE store.discount (
    id                  bigserial NOT NULL,
    name                VARCHAR(100) NOT NULL,
    description         TEXT,
    discount_percent    numeric NOT NULL,
    active              BOOL NOT NULL
);

ALTER TABLE store.discount
    ADD CONSTRAINT discount_pk PRIMARY KEY ( id );