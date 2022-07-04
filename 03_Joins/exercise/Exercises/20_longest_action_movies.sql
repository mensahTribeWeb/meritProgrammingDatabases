-- 20. The titles, lengths, and release dates of the 5 longest movies in 
--the "Action" genre. Order the movies by length (highest first), 
--then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

SELECT title, length_minutes, release_date
FROM genre AS g
JOIN movie_genre AS mg ON
mg.genre_id = g.genre_id
JOIN movie AS m ON
m.movie_id = mg.movie_id
WHERE genre_name = 'Action'
ORDER BY length_minutes DESC, release_date ASC
LIMIT 5;
