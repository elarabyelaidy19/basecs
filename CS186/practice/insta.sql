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


/* return bonus of emp if his odd and not start with M */  

SELECT employee_id, if(employee_id % 2 = 1 and name not like 'M%', salary, 0 ) as bonus 
from Employees 


SELECT employee_id, 
CASE 
    WHEN employee_id % 2 = 1 and name not like 'M%' THEN salary 
    ELSE 0 
END AS bonus
from  Employee 
ORDER BY employee_id 


/* updat gender from f to m and vise versa */ 
UPDATE Salary
SET sex = if(sex = 'm', 'f', 'm'); 


UPDATE Salary 
SET sex  =  
        CASE 
            WHEN sex = 'm' THEN 'f' 
            else  'm' 
        end;  

 


/* delete all duplicates emails keeping only ones with smallest Id */  
DELETE p1 FROM person, Person p2 
WHERE p1.email = p2.email and p1.id > p2.id 




/* */ 
/* */ 
/* */ 
/* */ 

