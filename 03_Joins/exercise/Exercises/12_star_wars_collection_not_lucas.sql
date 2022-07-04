-- 12. The titles of the movies in the 
--"Star Wars Collection" that weren't directed by George Lucas (5 rows)

SELECT title, collection_name, person_name
FROM movie AS m
JOIN collection AS c ON
m.collection_id = c.collection_id
JOIN person AS p ON
p.person_id = m.director_id

WHERE person_name <> 'George Lucas' AND collection_name = 'Star Wars Collection'; 

