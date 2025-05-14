TRUNCATE TABLE products;

INSERT INTO "products" ("prd_id", "prd_name", "prd_cat", "prd_dept", "is_active", "updated_at") VALUES
    (51, 'Athletic Shoes Trick', 4, '1', 'false', '2025-05-13 14:24:40.230301+00'),
    (52, 'Socks Cylias', 2, '3', 'true', '2025-05-13 14:24:40.230301+00'),
    (50, 'Costume Amin', 8, '3', 'true', '2025-05-13 14:24:40.230301+00'),
    (53, 'Button-Down Shirt Escudo', 2, '1', 'true', '2025-05-13 14:24:40.230301+00');

SELECT setval('products_cat_id_seq', (SELECT max(prd_id) FROM products));
