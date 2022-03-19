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



