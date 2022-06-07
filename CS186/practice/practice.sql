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



/* campitalize first letter and lower rest of the name */ 

SELECT user_id, concat(upper(substr(name, 1, 1)), lower(substr(name, 2))) as name 
FROM User
ORDER BY user_id

/*Write an SQL query to find for each date the number of different products sold and their names. */ 

SELECT sell_date, COUNT(DISTINCT product) as num_sold, GROUP_CONCAT(DISTINCT product ORDER BY product) as products 
FROM activities 
GROUP BY sell_date 
ORDER BY sell_date

/* complete a reports for patients that have DIAB1 in  there conditions */ 
select patient_id, patient_name, conditions 
from Patients 
where conditions REGEXP '\\bDIAB1' 


/* report with employees with missing data name and salaries*/ 

select employee_id  
from employees  
where employee_id not in (select employee_id from salaries)

union 

select employee_id 
from salaries 
where employee_id not in (select employee_id from employees)


order by employee_id  


/* report products */ 

select product_id, 'store1' as store, store1 as price from products where store1 is not null 
union 
select product_id, 'store2' as store, store2 as price from products where store2 is not null  
union 
select product_id, 'store3' as store, store3 as price from products where store3 is not null  

/* tree calssifid */ 

select id, 'Root' as type from tree where p_id is null 
union 
select id, 'Leaf' as type from tree where id not in (select distinct p_id from tree where p_id is not null) and p_id is not null  
union 
select id, 'Inner' as type from tree where id in (select distinct p_id from tree where p_id is not null) and p_id is not null 

/* Second Max Salary */ 

SELECT MAX(salary) as secondMaxSalary 
FROM employee 
WHERE salary < (SELECT max(salary) from employee)  

/* */




