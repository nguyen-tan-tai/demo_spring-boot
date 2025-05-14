DROP SEQUENCE IF EXISTS order_items_cat_id_seq;
CREATE SEQUENCE order_items_cat_id_seq;

CREATE TABLE IF NOT EXISTS "order_items" (
    "order_item_id" BIGINT NOT NULL DEFAULT nextval('order_items_cat_id_seq'),
    "order_id" BIGINT NOT NULL,
    "prd_id" BIGINT NOT NULL,
    "prd_name" VARCHAR(255) NOT NULL,
    "quantity" INTEGER NOT NULL,
    "price" VARCHAR(255) NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL,
    PRIMARY KEY ("order_item_id")
);
ALTER SEQUENCE order_items_cat_id_seq
OWNED BY order_items.order_item_id;

DELETE FROM "order_items";

INSERT INTO "order_items" ("order_item_id", "order_id", "prd_id", "prd_name", "quantity", "price", "updated_at") VALUES
    (103000001, 102000001, 104000050, 'Costume Amin', 1, '20.2', '2025-05-13 14:24:40+00'),
    (103000002, 102000001, 104000051, 'Athletic Shoes Trick', 2, '10.0', '2025-05-13 14:24:40+00'),
    (103000003, 102000001, 104000052, 'Socks Cylias', 5, '15.1', '2025-05-13 14:24:40+00'),
    (103000004, 102000002, 104000053, 'Button-Down Shirt Escudo', 6, '15.1', '2025-05-13 14:24:40+00'),
    (103000005, 102000002, 104000054, 'Espadrilles Lumo', 5, '15.1', '2025-05-13 14:24:40+00'),
    (103000006, 102000003, 104000055, 'Bra Chrisie', 5, '15.1', '2025-05-13 14:24:40+00'),
    (103000007, 102000004, 104000056, 'Dress Shirt Pepper', 100, '99.99', '2025-05-13 14:24:40+00'),
    (103000008, 102000005, 104000057, 'Necklace Kiff', 7, '2', '2025-05-13 14:24:40+00'),
    (103000009, 102000006, 104000050, 'Costume Amin', 40, '0.1', '2025-05-13 14:24:40+00'),
    (103000010, 102000007, 104000051, 'Athletic Shoes Trick', 50, '4', '2025-05-13 14:24:40+00'),
    (103000011, 102000008, 104000052, 'Socks Cylias', 60, '10', '2025-05-13 14:24:40+00');


SELECT setval('order_items_cat_id_seq', (SELECT max(order_item_id) FROM order_items));
