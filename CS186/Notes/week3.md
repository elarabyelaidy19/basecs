# Indexing and B+ Trees  


# Indexing
- looking up things by values.
> “If you don't find it in the index, look very carefully through the entire catalog. 
- Indexing Data Structure 
    - Search Trees(AVL, B+ Tree, Red Black Tree, 2-3 Tree) 
    - Hash Table 

## Index 
- index is a data structure that enables quick **lookup(equality)** and **modification(insert, delete)** of **data entries(items stored in index)** by search **key(subset of columns)**.   
- **Types** B+ trees, B- trees, Hash Tables, GIST, allow lookups without scanning all data.


## Indexing 
- index is a data structure that allows you speed up reads on a speicific key. it's make queries run faster especially those that are run frequently. 
- index on the user id is a good example of an index. 


## B+ Trees 
- B+ tree have very high **Fan-out**: number of pointers to child nodes in a node. 
- B+ tree is a **self-balancing** tree, grows at root not leaves.
- strores data entries in **leaf nodes** only, thus called B Plus Tree. 
- **Order** is the number of children nodes for internal nodes. it's measure capacity of a nodes.  
- the number of entries for each internal node must satisfy **d < entries < 2d**.  
- Max fan-out is **2d + 1** == num of pointers.  
- Only the leaf nodes contain records (or pointers to records).  Theinner nodes (which are the non-leaf nodes) do not contain the actual records.

![](./img/db13.png) 

## Scalling B+ Trees 
- B+ tree allow index Massive number of records.
![](./img/db14.png)


### Searching B+ Trees
- start at root, do a binary search on the key, find the record in the leafs.
 

## inseting B+ Trees 
- find the correct Leaf.
- put data entry int the leaf. 
    - if leaf have enough space, insert, done!. 
    - else split the leaf into two leafs. (L1, L2)  
        - redistribute the entries evenly, **copy up** middle key and ptr to L2. 
        -  insert index entry pointing to L2 into L.  
            - else recursively split and **push up** from parents.  

## Before Inserting B+ Trees
![](./img/db16.png) 


## After Inserting B+ Trees
![](./img/db17.png)

