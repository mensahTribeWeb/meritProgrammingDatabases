-- 6. The genres of "The Wizard of Oz" (3 rows)

SELECT genre_name
FROM movie AS m

JOIN movie_genre AS mg ON
m.movie_id = mg.movie_id

JOIN genre AS g ON
mg.genre_id = g.genre_id
WHERE title = 'The Wizard of Oz';
