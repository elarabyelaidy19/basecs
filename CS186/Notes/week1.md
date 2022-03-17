# Week 1  

# DataBase 
- relations is tables, rows are records/tuples, columns are attributes/fields, cardinality is the number of rows.
- SQL is a language for querying databases 
- sechema is the description of the data "metadata" 
- instance is a set of data satisfying the schema
- tables is physical data independence.The logical definition of the data remains
unchanged, even when we make changes to the
actual implementation 


## SQL 
 - SQL is Declarative, say what you want to do, not how to do it. 
 - two types of SQL: 
    - DDL: Data Definition Language, create tables, alter tables, drop tables, etc. 
    - DML: Data Manipulation Language, insert, update, delete, etc. 
- RDMS: is responsible for choose the algorthim to implement the SQL. 

## DDL SQL 
- **Primary key:** unique identifier for each record.
    - provide a unique lookup key for each record. 
    - can not have any duplicates. 
    - can be mad of multiple columns.
- **Foreign Key:** reference to another table.  
    - it point to a primary key of the referenced table. 
    - does not need to have the same name as the revernced key.

## Querying language 
  - ## Querying table 
    - From tells what table to query, where tells what the condition to query on and which specific rows to return, select what columns to return. 
    - the order of returned rows is nondeterministic. unless you specify an order by clause. 
 - ## Null Values 
    - Null represents a value that is unknown or missing. 
    - any operation with null is null  
    - x = null , x > 3, x = 1, x + 4 all evaluate to null. 
    - null is falsy, so where is null just Like where is false. 
    - null is short circuited with boolean operators. 
![Nulls](img/db1.png) 

## Grouping and Aggregation  
- ## Aggregation
    - the input to aggegate fuction is the name of the column, and the output is a single value that is the result of the aggregation. 
    - every aggregate func ignores nulls, except for count(*) which return the overall count of rows. 
 - ## Grpuping  
    - the Group By clause is used to group the rows of a query into groups. and then summenrize each group separately. 
    - the group by  must specified usin Having clause. 
    - the having is similiar to where clause, but it's occur after grouping.  
    - the query bellow excuted as follow 
        - 1- specify the from table person  
        - 2- remove the rows with age < 18 
        - 3- group by age, categorize with groups of the same values. 
        - 4- apply the having clause to remove the groups that don't meet the condition. 
        - 5- every group is collapsed to a single row, returning the specified columns in the select clause, two clouumns one age of the group and average num_dog of the group.  
        - ```sql 
            select age, AVG(num_dogs) 
            from person 
            where age >= 18 
            group by age 
            having count(*) > 1 

    - **if you are going to use grouping or aggregate you must select the only grouped/aggergeated columns**. this is will not work one entire cloumn and one row.  
    - ``` sql 
        select age, avg(num) 
        from person 

        select age, num 
        form person 
        group by age
  
## Order By and Limit 
- by default the order by default is ascending, if you want to sort in descending order you must specify the order by desc.
- the limit clause is used to limit the number of rows returned. 
```sql 
    select name, age
    from person 
    order by age desc, age 
    limit 2
```

## SQL Flavors 
- **Distinct**: remove duplicate rows before output. 
- **AS**: Alias name. 



