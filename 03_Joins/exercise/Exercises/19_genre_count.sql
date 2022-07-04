-- 19. The genre name and the number of movies in each genre. 
--Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).

SELECT  genre_name, COUNT(title) AS num_of_movies
FROM genre AS g
JOIN movie_genre AS mg ON
mg.genre_id = g.genre_id
JOIN movie AS m ON
m.movie_id = mg.movie_id
GROUP BY genre_name;

