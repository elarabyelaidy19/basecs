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




SELECT category FROM bugs GROUP BY category;



/* find how many bugs created_at or later*/

CREATE CTE bugs_created_at_later AS ( SELECT id, created_at FROM bugs WHERE created_at > '2019-03-01T00:00:00.000Z' );

SELECT COUNT(*) from bugs WHERE created_at >= STR_TO_DATE('01-03-2019 00:00:00','%d-%m-%Y %H:%i:%s');


/* find the title of the bug with token = "token660" and reported_at on "2020-08-30". */ 
SELECT title, id 
FROM bugs 
WHERE token = 'token660' 
AND reported_at = '2020-08-30' 
ORDER BY id, token;

