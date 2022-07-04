-- 3. For all actors with the last name of "Jones", display the
--actor's name and movie titles they appeared in. Order the results 
--by the actor names (A-Z). (48 rows)

SELECT title, person_name
FROM person AS p

JOIN movie_actor
ON movie_actor.actor_id = p.person_id
JOIN movie AS m
ON m.movie_id = movie_actor.movie_id
WHERE person_name LIKE '% Jones'

ORDER BY person_name ASC;





