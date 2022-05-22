# Data Base Design 
## Design steps 
- Requirement Analysis 

what is the need for the data base, user needs 
- Conceptual Design  

ERD, high level design
- Logical Design 

translate the high level design into data model
- Physical Design

 indexes, disl layouts
- Security Design: 

authentication, security  


## Level of abstractiosn Data Model 
- ### User View 
what the user see when querying the data base
- ### Conceptual Schema
defines the logical structure of the data base
- ### Physical Schema
describes the files and indexes of the data base 
s
## Data Independence
isilate apps from the structure of the data base. 
### Logical Data Independence: 
Maintains the same views when the logical structure of the data base changes.
### Physical Data Independence:
Maintains the Logical Structure when the physical structure of the data base changes. 

we need to make sure that the data base is independent from the application. because the environment that incupates the database is changing.


<b> 
Integrity constraints can be referd to business rules.
</b>

# ER Model 

- **Entity**: real world object described by set of attributes. 
- **Entity set**: collection of entities that share the same attributes.