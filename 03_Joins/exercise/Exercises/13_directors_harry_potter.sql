-- 13. The directors of the movies in 
--the "Harry Potter Collection" (4 rows)

SELECT DISTINCT person_name
FROM movie AS m
JOIN collection AS c ON
c.collection_id = m.collection_id
JOIN person AS p ON
p.person_id = m.director_id

WHERE collection_name = 'Harry Potter Collection';

