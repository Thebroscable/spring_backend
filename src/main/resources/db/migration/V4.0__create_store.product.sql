DROP TABLE IF EXISTS store.product CASCADE;

CREATE TABLE store.product (
    id              bigserial NOT NULL,
    name            VARCHAR(100) NOT NULL,
    description     TEXT,
    category_id     bigserial NOT NULL,
    price           numeric NOT NULL,
    quantity        int NOT NULL,
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
