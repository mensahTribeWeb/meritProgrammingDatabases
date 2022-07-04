-- 18. The average length of movies in the "Science Fiction" genre. 
--Name the column 'average_length'.
-- (1 row, expected result around 110-120)

SELECT AVG(length_minutes) AS average_length
FROM genre AS g

JOIN movie_genre AS mg ON
mg.genre_id = g.genre_id

JOIN movie AS m ON
mg.movie_id = m.movie_id 

WHERE genre_name = 'Science Fiction';

