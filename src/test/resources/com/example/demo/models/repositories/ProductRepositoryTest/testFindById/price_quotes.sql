DELETE FROM "price_quotes";

INSERT INTO "price_quotes" ("pq_id", "prd_id", "price", "created_at") VALUES
    (4001, 50, '24.4', '2025-05-13 16:01:54.602071+00'),
    (4002, 51, '48.2', '2025-05-13 16:01:54.602071+00'),
    (4003, 52, '38.1', '2025-05-13 16:01:54.602071+00'),
    (4004, 53, '94.1', '2025-05-13 16:01:54.602071+00');

SELECT setval('price_quotes_id_seq', (SELECT max(pq_id) FROM price_quotes));
