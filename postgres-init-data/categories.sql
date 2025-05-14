DROP SEQUENCE IF EXISTS categories_cat_id_seq;
CREATE SEQUENCE categories_cat_id_seq;

CREATE TABLE IF NOT EXISTS "categories" (
    "cat_id" BIGINT NOT NULL DEFAULT nextval('categories_cat_id_seq'),
    "cat_name" VARCHAR(255) NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL,
    PRIMARY KEY ("cat_id")
);
ALTER SEQUENCE categories_cat_id_seq
OWNED BY categories.cat_id;

DELETE FROM "categories";

INSERT INTO "categories" ("cat_id", "cat_name", "updated_at") VALUES
    (101, 'Accessories', '2025-05-13 14:09:44+00'),
    (102, 'Apparel', '2025-05-13 14:09:44+00'),
    (103, 'Cosmetics', '2025-05-13 14:09:44+00'),
    (104, 'Footwear', '2025-05-13 14:09:44+00'),
    (105, 'Formal Wear', '2025-05-13 14:09:44+00'),
    (106, 'Luggage', '2025-05-13 14:09:44+00'),
    (107, 'Sportswear', '2025-05-13 14:09:44+00'),
    (108, 'Traditional', '2025-05-13 14:09:44+00'),
    (109, 'Watches & Jewelry', '2025-05-13 14:09:44+00');


SELECT setval('categories_cat_id_seq', (SELECT max(cat_id) FROM categories));
