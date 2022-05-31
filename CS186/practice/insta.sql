/* find the second max salary */ 
select 
    (select distinct salary 
        from Employee 
        order by salary desc 
        limit 1 offset 1 
    ) as SecondHighestSalary   



select max(salary) as SecondHighestSalary
from employee  
where salary < ( 
    select max(salary) from employee
) 


/*find the nth highest salary */ 

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT 
BEGIN 
    set N = N-1; 
    RETURN ( 
        SELECT salary 
        FROM Employee 
        GROUP BY salary 
        ORDER BY salary DESC 
        LIMIT 1 OFFSET N
    ); 

END


/* sql query to rank scores */ 
SELECT S.score, count(S2.score) AS 'Rank' 
FROM Scores S, 
(SELECT DISTINCT score FROM scores) S2 
WHERE S.score <= S2.score 
GROUP BY S.id
ORDER BY S.score 
/* */ 
/* */ 
/* */ 
/* */ 
/* */ 
/* */ 
/* */ 

