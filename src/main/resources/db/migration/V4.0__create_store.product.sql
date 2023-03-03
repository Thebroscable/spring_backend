DROP TABLE IF EXISTS store.product CASCADE;

CREATE TABLE store.product (
    id              bigserial NOT NULL,
    name            VARCHAR(100),
    "desc"          TEXT,
    category_id     bigserial NOT NULL,
    price           numeric,
    quantity        int,
    discount_id     bigserial
);

ALTER TABLE store.product
    ADD CONSTRAINT product_pk PRIMARY KEY ( id );

ALTER TABLE store.product
    ADD CONSTRAINT product_product_category_fk FOREIGN KEY ( category_id )
        REFERENCES store.product_category ( id );

ALTER TABLE store.product
    ADD CONSTRAINT product_discount_fk FOREIGN KEY ( discount_id )
        REFERENCES store.discount ( id );
