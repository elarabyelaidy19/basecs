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
