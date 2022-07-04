-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.

SELECT DISTINCT genre_name
FROM person AS p

JOIN movie_actor AS ma ON
p.person_id = ma.actor_id

JOIN movie AS m ON
ma.movie_id = m.movie_id

JOIN movie_genre AS mg ON
mg.movie_id = m.movie_id

JOIN genre AS g ON
mg.genre_id = g.genre_id

WHERE person_name = 'Christopher Lloyd'