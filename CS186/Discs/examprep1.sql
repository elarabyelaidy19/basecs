/* Return the bid and genre of each book that has ever been checked out. Remove any duplicate rows with the same bid and genre.
*/ 

SELECT DISTINCT bid, genre 
FROM Books B, Checkout C 
WHERE B.bid = C.Book 

/* Find all of the fantasy book titles that have been checked out and the date when they were checked out. 
Even if a book hasn’t been checked out, we still want to output the title (i.e. the row should look like (title, NULL)). */ 

SELECT title, day 
FROM Books B 
LEFT OUTER JOIN Checkouts C ON C.Book = B.bid 
WHERE B.genre = 'fantazy'

/* Select the name of the book that has been checked out the most times and the corresponding checked out count. 
You can assume that each book was checked out a unique number of times, and that the titles of the books are all unique
*/ 
SELECT title, COUNT(*) as cnt 
FROM Books B, Checks C 
WHERE B.bid = C.Book 
GROUP BY B.title 
ORDER BY cnt DESC 
LIMIT 1