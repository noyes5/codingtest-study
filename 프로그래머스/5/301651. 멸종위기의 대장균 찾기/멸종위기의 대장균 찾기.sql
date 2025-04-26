WITH RECURSIVE hierarchy AS (
    SELECT id, parent_id, 1 AS depth
    FROM ECOLI_DATA
    WHERE parent_id IS NULL

    UNION ALL

    SELECT c.id, c.parent_id, h.depth + 1
    FROM ECOLI_DATA c
    JOIN hierarchy h ON c.parent_id = h.id
),
leaf_nodes AS (
    SELECT h.*
    FROM hierarchy h
    LEFT JOIN ECOLI_DATA child ON h.id = child.parent_id
    WHERE child.id IS NULL
)
SELECT COUNT(*) AS COUNT, depth AS GENERATION
FROM leaf_nodes
GROUP BY depth
ORDER BY generation;