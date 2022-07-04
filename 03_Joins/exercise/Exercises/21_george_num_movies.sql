-- 21. For every person in the person table with the first name 
--of "George", list the number of movies they've been in--include all Georges,
--even those that have not appeared in any movies. 
--Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'

SELECT person_name, COUNT(title) AS num_of_movies
FROM  movie AS m 
JOIN movie_actor AS ma ON
m.movie_id = ma.movie_id
FULL JOIN person AS p ON
ma.actor_id = p.person_id
WHERE person_name LIKE 'George %'
GROUP BY person_id
ORDER BY person_name;
