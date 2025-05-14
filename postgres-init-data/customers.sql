DROP SEQUENCE IF EXISTS customers_cat_id_seq;
CREATE SEQUENCE customers_cat_id_seq;

CREATE TABLE IF NOT EXISTS "customers" (
    "cust_id" BIGINT NOT NULL DEFAULT nextval('customers_cat_id_seq'),
    "display_name" VARCHAR(255) NOT NULL,
    "email_address" VARCHAR(255) NOT NULL,
    "user_name" VARCHAR(255) NOT NULL,
    "hashed_pwd" VARCHAR(255) NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL,
    PRIMARY KEY ("cust_id")
);
ALTER SEQUENCE customers_cat_id_seq
OWNED BY customers.cust_id;

DELETE FROM "customers";

INSERT INTO "customers" ("cust_id", "display_name", "email_address", "user_name", "hashed_pwd", "updated_at") VALUES
    (101000001, 'Maria White', 'mariawhite@example.com', 'mariawhite01', 'hoge', '2025-05-13 21:53:04+00'),
    (101000002, 'John Doe', 'johndoe@example.com', 'johndoe02', 'hoge', '2025-05-13 21:53:04+00'),
    (101000003, 'Lisa Nakam', 'lisanakam@example.com', 'lisanakam03', 'hoge', '2025-05-13 21:53:04+00');

SELECT setval('customers_cat_id_seq', (SELECT max(cust_id) FROM customers));
