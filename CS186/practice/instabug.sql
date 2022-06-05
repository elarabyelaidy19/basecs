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


get the name of the most popular course (the one where the most students are enrolled) and if there is a tie, get the course that's lexicographically the smallest. 
