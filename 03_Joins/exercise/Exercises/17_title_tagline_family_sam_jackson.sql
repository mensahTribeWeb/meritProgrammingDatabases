-- 17. The titles and taglines of movies that are in 
--the "Family" genre and Samuel L. Jackson has acted in (4 rows)

SELECT DISTINCT title, tagline
FROM genre AS g

JOIN movie_genre AS mg ON
mg.genre_id = g.genre_id

JOIN movie AS m ON
m.movie_id = mg.movie_id

JOIN movie_actor AS ma ON
ma.movie_id = m.movie_id

JOIN person AS p ON
p.person_id = ma.actor_id

WHERE genre_name = 'Family' AND person_name = 'Samuel L. Jackson';


