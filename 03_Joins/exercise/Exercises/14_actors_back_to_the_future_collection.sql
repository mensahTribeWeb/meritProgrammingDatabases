-- 14. The names of actors who've appeared 
--in the movies in the "Back to the Future Collection" (28 rows)

-- SELECT DISTINCT person_name
-- FROM movie AS m
-- JOIN collection AS c ON
-- m.collection_id = m.collection_id
-- JOIN movie_actor AS ma ON
-- ma.movie_id = m.movie_id
-- JOIN person AS p ON
-- p.person_id = ma.actor_id
-- WHERE collection_name LIKE '%Back to the Future Collection%';

SELECT DISTINCT person_name
FROM movie AS m
JOIN movie_actor AS ma USING(movie_id)
JOIN person AS p ON 
p.person_id = ma.actor_id
JOIN collection AS c USING(collection_id)
WHERE collection_name LIKE '%Back to the Future Collection%';


