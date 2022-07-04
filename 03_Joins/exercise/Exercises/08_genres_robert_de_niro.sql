-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
SELECT DISTINCT genre_name
FROM person AS p

JOIN movie_actor AS ma ON ma.actor_id = p.person_id

JOIN movie_genre AS mg  USING (movie_id)

JOIN movie AS m USING (movie_id)

JOIN genre AS g USING (genre_id )

WHERE release_date >= '2010-01-01' AND person_name = 'Robert De Niro';


