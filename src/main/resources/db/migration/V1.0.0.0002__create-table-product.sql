CREATE TABLE public.product
(
--    id VARCHAR(200) NOT NULL DEFAULT generate_ulid(),
    id                  VARCHAR(200) NOT NULL,
    name                VARCHAR(500) NOT NULL,
    modify_datetime     TIMESTAMP    NOT NULL,
    price_json          JSONB        NOT NULL,
    attribute_list_json JSONB        NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

CREATE UNIQUE INDEX PRODUCT_NAME_IDX ON product (name);