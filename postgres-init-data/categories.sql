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
    (1, 'Accessories', '2025-05-13 14:09:44+00'),
    (2, 'Apparel', '2025-05-13 14:09:44+00'),
    (3, 'Cosmetics', '2025-05-13 14:09:44+00'),
    (4, 'Footwear', '2025-05-13 14:09:44+00'),
    (5, 'Formal Wear', '2025-05-13 14:09:44+00'),
    (6, 'Luggage', '2025-05-13 14:09:44+00'),
    (7, 'Sportswear', '2025-05-13 14:09:44+00'),
    (8, 'Traditional', '2025-05-13 14:09:44+00'),
    (9, 'Watches & Jewelry', '2025-05-13 14:09:44+00');
