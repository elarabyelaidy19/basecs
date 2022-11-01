CREATE TABLE Sailors ( 
    sid INTEGER NOT NULL, 
    sname VARCHAR9(20) NOT NULL, 
    rating INTEGER NOT NULL, 
    age FLOAT NOT NULL, 
    PRIMARY KEY(sid)
)

CREATE TABLE Boats ( 
    bid INTEGER NOT NULL, 
    bname TEXT NOT NULL, 
    color TEXT,
    PRIMARY KEY(bid)
)

CREATE TABLE Reserve( 
    sid INTEGER, 
    bid INTEGER, 
    day DATE,
    PRIMARY KEY(sid, bid, day), 
    FOREIGN KEY(sid) REFERENCES Sailors, 
    FOREIGN KEY(bid) REFERENCES Boats 
)


SELECT DISTINCT S.name, S.gpa 
    FROM Student S 
    WHERE S.dept = 'CS' 


SELECT S.name, S.gpa, S.age*2 AS a2 
    FROM Student S 
    WHERE S.dept = 'CS' 
    ORDER BY S.gpa, S.name. a2


SELECT S.name, S.gpa, S.age*2 AS a2 
    from Student S 
    WHERE S.dept = 'CS' 
    ORDER BY S.gpa ASC, S.name DESC, a2 


SELECT S.name, S.gpa, S.age*2 AS a2 
    FROM Student S 
    WHERE S.dept = 'CS' 
    ORDER BY S.gpa, S.name, a2 
    LIMIT 3





SELECT DISTINCT AVG(S.gpa) 
    FROM Student S 
    WHERE S.dept = 'CS'  


SELECT DISTINCT AVG(S.gpa), S.dept 
    FROM Student S 
    GROUP BY S.dept 


SELECT AVG(S.gpa), S.dept 
    FROM Student S 
    GROUP BY S.dept 
    HAVING COUNT(*) > 2


SELECT S.dept, AVG(S.gpa), COUNT(*) 
    FROM Student S 
    WHERE S.gender = 'F' 
    GROUP BY S.dept 
    HAVING COUNT(*) >= 2 
    ORDER BY S.dept; 



SELECT name 
from dogs 
WHERE owner_id = 3 

SELECT name, age 
from dogs 
ORDER BY age DESC, name 
LIMIT  

SELECT breed, COUNT(*) 
from dogs
GROUP BY breed
HAVING COUNT(*) > 1 



