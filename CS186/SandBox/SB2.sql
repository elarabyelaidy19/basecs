// the same result 
// inner/NATURAL join 

SELECT s.sid, s.sname, r.bid
FROM Sailors s, Reserves r
WHERE s.sid = r.sid
AND s.age > 20;


SELECT s.sid, s.sname, r.bid
FROM Sailors s INNER JOIN Reserves r
ON s.sid = r.sid
WHERE s.age > 20;


SELECT s.sid, s.sname, r.bid
FROM Sailors s NATURAL JOIN Reserves r
WHERE s.age > 20; 




SELECT actor.id, actor.fname, actor.lname
FROM actors
ORDER BY lname, fname


SELECT actor.id, actor.fname, actor.lname
FROM actors
WHERE lname = 'Williams' OR fname = 'Davis'


SELECT DISTINCT renatal.id 
FROM rentals
where time(rentals.rental_date) = '2005-07-05'

SELECT true 
where 'Alfy Jorge' LIKE '%Jorge'


SELECT first_name from person WHERE last_name similar to '%Stuck|Epp%';