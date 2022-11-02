# Freecodecamp tutorial 

## CLI 
- Creating database 
```SQL
CREATE DATABASE database_name
```
- connecting to database 
```shell
psql database 
psql -h localhost -p 5432 -U elaraby databsename 
``` 


## Regular Commands 
- `\l` : list all databases 
- `\c database_name` : connect to database
- `\dt` : list all tables in database
- `\d table_name` : list all columns in table
- `d` stands for describe 
- `\i file_name` : run sql file
## Notes 
- `bigserial` is a data type that is a combination of serial and bigint, it's an auto incrementing integer that can hold a very large number. 
- use mockaroo to generate fake data. export as .sql file and run it in psql. 
