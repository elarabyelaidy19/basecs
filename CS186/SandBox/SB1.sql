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