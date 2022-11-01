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

/* find dates id where temper of day greater than it's previous day*/
/* date if  return differnce in days between two dates */
select weather.id as id 
from weather join weather w on DATEDIFf(weather.recorddate, w.recorddate) = 1 
    and weather.Temperature > w.Temperature


/* sales person not have any order of company 'RED' */ 
select salesperson.name 
from salesperson 
where salesperson.sales_id not in
(select p.sales_id
from salesperson p join orders o on p.sales_id = o.sales_id join company c on o.com_id = c.com_id 
where c.name = 'RED') 



/* find daily active users */ 
select activity_date as day, count(distinct user_id) as active_users 
from activity 
where datediff('2019-7-27', activity_date) < 30  and  activity_date <= '2019-07-27'
group by activity_date


/* daily leads and partener */
select date_id, make_name, count(distinct lead_id) as unique_leads, count(distinct partner_id) as unique_partners 
from DailySales 
group by 1,2 

/* number of followers fro each user */ 
select user_id, count(distinct follower_id) as followers_count 
from followers 
group by user_id

/* customer with the max nums of orders */

select customer_number 
from orders 
group by customer_number 
order by count(*) desc
limit 1

/* find first customer login */ 
select player_id, min(event_date) as first_login 
from activity 
group by player_id


/* latetst login in 2020 */

select user_id, max(time_stamp) as last_stamp 
from Logins 
where year(time_stamp) = 2020 
group by user_id


/* find total time spent by each employee */

select event_day as day, emp_id, sum(out_time-in_time) As total_time  
from Employees
Group By emp_id, event_day 


/* Capital gain loss */

select stock_name, sum( 
    case
        when operation = 'Buy' then -price 
        else price 
    end 
) as capital_gain_loss
from stocks 
group by stock_name

/* sum of distance travlled */

select u.name, ifnull(sum(r.distance), 0) as travelled_distance 
from users u left join rides r on u.id = r.user_id 
group by r.user_id 
order by travelled_distance desc, name

/* the joining date */

SELECT u.user_id AS buyer_id, join_date, 
IFNULL(COUNT(order_date), 0) AS orders_in_2019 
FROM Users as u
LEFT JOIN
Orders as o
ON u.user_id = o.buyer_id
AND YEAR(order_date) = '2019'
GROUP BY u.user_id

/* report duplcates emails */

select email 
from person 
group by email 
having count(email) > 1

/* Actors and Directors Who Cooperated At Least Three Times */ 

SELECT actor_id, director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(1) >= 3


/* bank account summary */

SELECT u.name, SUM(amount) as balance
FROM Transactions
JOIN Users u
USING (account)
GROUP BY account
HAVING balance>10000 


/* sales analysis two */
SELECT product_id, product_name
FROM Sales 
JOIN Product 
Using(product_id)
GROUP BY product_id
HAVING MIN(sale_date) >= '2019-01-01' AND MAX(sale_date) <= '2019-03-31' 

/* */

SELECT dogs.name 
from dogs inner join users  ON dogs.owner_id = users.user_id
WHERE users.name = "josh hug" 

SELECT dogs.name 
from dogs, users 
WHERE users.user_id = dogs.owner_id AND users.name = "josh hug"


SELECT users.name, count(dogs.dog_id) 
from dogs inner join users on dogs.owner_id = users.user_id 
WHERE users.user_id = dogs.owner_id  
GROUP BY users.user_id, users.name
order by count(dogs.dog_id) desc 
LIMIT 1


SELECT users.name, count(*) 
from users inner join dogs on users.user_id = dogs.owner_id 
GROUP BY users.user_id, users.name 
HAVING count(*) > all ( 
    select count(*) 
    from dogs 
    group by owner_id
)



/*Write an SQL query that will, for each date_id and make_name, return the number of distinct lead_id's and distinct partner_id's. */ 
SELECT date_id, make_name, COUNT(DISTINCT lead_id) AS unique_leads, COUNT(DISTINCT partner_id) AS unique_partners
FROM DailySales
GROUP BY 1, 2


/* =========================================================================================== */

