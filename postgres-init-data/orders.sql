DROP SEQUENCE IF EXISTS orders_cat_id_seq;

CREATE SEQUENCE orders_cat_id_seq;
CREATE TABLE IF NOT EXISTS "orders" (
    "order_id" BIGINT NOT NULL DEFAULT nextval('orders_cat_id_seq'),
    "cust_id" BIGINT NOT NULL,
    "status" SMALLINT NOT NULL,
    "created_at" TIMESTAMPTZ NOT NULL,
    PRIMARY KEY ("order_id")
);
ALTER SEQUENCE orders_cat_id_seq
OWNED BY orders.order_id;

INSERT INTO "orders" ("order_id", "cust_id", "status", "created_at") VALUES
    (102000001, 101000001, 1, '2025-05-13 14:24:40+00'),
    (102000002, 101000001, 2, '2025-05-13 14:24:40+00'),
    (102000003, 101000001, 3, '2025-05-13 14:24:40+00'),
    (102000004, 101000001, 4, '2025-05-13 14:24:40+00'),
    (102000005, 101000001, 5, '2025-05-13 14:24:40+00'),
    (102000006, 101000002, 1, '2025-05-13 14:24:40+00'),
    (102000007, 101000003, 2, '2025-05-13 14:24:40+00'),
    (102000008, 101000004, 3, '2025-05-13 14:24:40+00'),
    (102000009, 101000005, 4, '2025-05-13 14:24:40+00');


SELECT setval('orders_cat_id_seq', (SELECT max(order_id) FROM orders));
