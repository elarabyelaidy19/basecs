# iterators and joins 

## Relational operators and Query plans  
- relational algebra expressions is a query plan in form of a tree, edges represents flow of tuples from one node to another, nodes are relational ops. 
- every input to a relational op is a relation, and every output is a relation, called **data flow graph**. 
- query optimizer selects operators to run, query exuter runs this operators by creating instances of operators. 
- each operator instance implements iterator interface to excute operator logic and forwording tiples to the next operator.


## Iterators interface 
- setup -> configuring the input args 
- init -> setup the operator state 
- next -> iterate over the input tuples and return output tuple 
- close -> clean up the operator state. 
- init and next can result in streaming(on-the-fly), or blocking(batch) alogrithm for iterator. 
- **streaming** constant amount of work for every call 
- **blocking** does not return until all the work is done consume its entire input.  
- iterator maintain a private state. 

### Select operator iterator
```ruby 
def init(predicate) 
    child.init() 
    pred = predicate 
    curr = null 
end 
def  next() 
    while (curr != EOF && !pred(curr)) 
        curr = child.next()
    end   
    return curr 
end 

def close() 
    child.close() 
end 
```

### Heap scan operator iterator 
```ruby  
    def init(relation) 
        heap = relation.get_heap() 
        curr_page = heap.get_first_page()
        curr_slot = curr_page.get_first_slot()
    end 

    def next() 
        return EOF if curr_page == null  
        curr = [curr_page, curr_slot] 
        curr_slot = curr_page.get_next_slot() 
        if(curr_slot == null) 
            curr_page = curr_page.get_next_page() 
            if(curr_page == null) return EOF 
            curr_slot = curr_page.get_first_slot() 
        end 
        return curr
    end 

    def close() 
        heap.close() 
    end
``` 

### Sort Iterator 
```ruby 
    def init(keys) 
        child.init()
        run = [] 
        for child in childs 
            ren << child.sort(keys)
        end
        load into buffer
    end 

    def next() 
        output = run.min 
        if runn of min is empty?
            fetch next page from disk to buffer 
        end 
        return output
    end

    def close()  
        deallocate runs files
        child.close() 
    end
```

### Group by Iterator 
```ruby 
def init(keys, aggs) 
    child.init() 
    curr_group = null 
end

def next() 
    until result    
        result = null 
        tup = child.next()
        if(group(tup) != curr_group) 
            if(curr_group != null) 
                result = [curr_group, final().all]  
            end
            curr_group = group(tup)
            init()
        end 
        merge(tup)
    end 
    return result
end 

def close() 
    child.close() 
end     
```



## Join Algorithms
# R, S
### Nested loop join 
- for each record r in R 
    - for each record s in S 
        - if join condition(r, s) 
            - add(r, s) to buffer 

- **cost**: number of records in R + [number of records in R * number of records in S] 
- scan R once + scan S once per R tuples
- joins order matters. 


### page nested loop join
- for each rpage in R  
    - for each spage in S 
        - for each rrecord in R 
            - for each srecord in S 
                - if join condition(rrecord, srecord) 
                    - add(rrecord, srecord) to buffer 

- scan R once and and scan S per page of R
- better than nested loop join, but still not optimal. 

### Block nested loop join
 - scan R once + scan S as many times as there are blocks in R


### Index nested loop join 
- optimizer selects index join if it is found an index on both relations.
- when we have index on S that is on the appropriate key, we can use index nested loop join. 
- for each record r in R 
    - for each record s in S 
        - if join condition(ri, si) 
            - add(r, s) to buffer   

### Sort merge join
- requires equality predicate on both relations. 
**Algorithm**: 
- sort R and S by join conidtion, all equals key are consecutive. 
**Cost**: 
- sort then join -> sort R + sort S + [R]+[S] 
- we can do refinement of sort merge join by combining last pass of merge-sort and join pass.
```ruby 
do  
    if(!mark) 
        while(s > r) { advance r} 
        while(r > s) { advance s} 
        mark = s 
    end  

    if(s == r) 
        result = [r, s] 
        advance s
        return result
    else 
        reset to mark 
        advance r
        mark = null
    end
end 
```

![sort merge join](./img/db36.png)

## Hash join
- ### Two passes  
    - ### Partitioning 
        - partition tuples fromm R and S by join key and store them in scratch disk. 
    
    - ### Build & Probe 
        - build hash table on R and probe hash table on S. 

![hash join](./img/db37.png)

### Cost
Partitioning phase: read+write both relations
⇒ 2([R]+[S]) I/Os
• Matching phase: read both relations, forward output
⇒ [R]+[S]
• Total cost of 2-pass hash join = 3([R]+[S])
• 3 * (1000 + 500) = 4500