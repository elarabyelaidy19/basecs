/* get the name of the most popular course (the one where the most students are enrolled) and if there is a tie, get the course that's lexicographically the smallest. */ 

/* MySql query: */ 


grades students courses  
// select the most enrolled course 

Final 

Q1 

SELECT S.name, Avg(G.grade) as average_grade  
FROM students S JOIN grades G ON S.id = G.student_id 
GROUP BY S.id
Order by average_grade DESC, name 
LIMIT 100

Q2 
find for each student, get all the courses that he/she is enrolled in along with the grade he/she scored for each course.
find student name, course name, grade 

SELECT students.name, courses.name as course, grades.grade as grade 
FROM (students Inner JOIN grades ON students.id = grades.student_id) JOIN courses ON courses.id = grades.course_id  
ORDER BY students.name, course, grades.grade  


SELECT CASE students.name = 
              when Length(students.name) = 8 then stuff(students.name, 7, 1, '000') 
               WHEN Length(students.name) = 9 then stuff(students.name, 7, 1, '00') 
               WHEN Length(students.name) = 10 then stuff(students.name, 7, 1, '0') 
               ELSE students.name end as name), courses.name as course, grades.grade as grade 
FROM (students Inner JOIN grades ON students.id = grades.student_id) JOIN courses ON courses.id = grades.course_id  
ORDER BY name, course, grades.grade



Q3 

SELECT courses.name 
FROM courses
JOIN grades ON courses.id = grades.course_id
GROUP BY courses.id
ORDER BY COUNT(grades.student_id) DESC, courses.name ASC
LIMIT 1;  



Q4

SELECT category FROM bugs GROUP BY category;


Q5
/* find how many bugs created_at or later*/

CREATE CTE bugs_created_at_later AS ( SELECT id, created_at FROM bugs WHERE created_at > '2019-03-01T00:00:00.000Z' );

SELECT COUNT(*) from bugs WHERE created_at >= STR_TO_DATE('01-03-2019 00:00:00','%d-%m-%Y %H:%i:%s');

Q6 
/* find the title of the bug with token = "token660" and reported_at on "2020-08-30". */ 
SELECT title, id 
FROM bugs 
WHERE token = 'token660' 
AND reported_at = '2020-08-30' 
ORDER BY id, token;




/* ////////////////////////////////////////////////////////////////////////////////////////

/* 1 
Table
students(id, name) , courses(id, name) , grades(id, course_id, student_id, grade) 
1- top 100 students based on average grades
2- if multible students have the same avg grade sort lexi 
*/ 
SELECT S.name, ( SELECT avg(grade) from grades) as average_grade  
FROM students S LEFT JOIN grades G ON S.id = G.student_id 
Order by grade DESC, name 
LIMIT 100 
/* 2 
1- get courses inrolled in and the grade for each course 
2- order by student name in asc order if tie order by course_name asc if still tie order by grade desc
3- return name course grade 
*/
SELECT S.name , C.name, G.grade  
FROM students S JOIN course C LEFT JOIN grades G 
on S.id =  G.student_id AND C.id = G.course_id
ORDER BY S.name, C.name, grade 

/* 3  
- find most popular course if tie return the one that lexi smaller
*/
SELECT courses.name
FROM courses JOIN students 
GROUP BY courses.name 
ORDER BY COUNT(courses.name), name ASC 
LIMIT 1

SELECT count(students.id) as num
from students JOIN courses 
GROUP BY courses.name   

SELECT MAX(counts) 
FROM ( 
SELECT COUNT(courses.name) AS counts
FROM Courses JOIN Students 
GROUP BY Courses.id, Students.id ) 



/* 4 

1- select distinct bugs 

*/ 

SELECT DISTINCT title from bugs group by category

/* 5 */


/* 6 */ 

