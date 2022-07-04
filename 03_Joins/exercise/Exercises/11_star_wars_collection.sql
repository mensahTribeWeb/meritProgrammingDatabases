-- 11. The titles of the movies in the "Star Wars Collection" 
--ordered by release date, most recent to earliest (9 rows)

SELECT title
FROM movie AS m
JOIN collection AS c ON
c.collection_id = m.collection_id
Where collection_name LIKE 'Star Wars Collection'
ORDER By release_date DESC;
