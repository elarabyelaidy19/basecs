Find the names of 5 songs that spent the least weeks in the top 40, ordered from least to most. 

```sql 
    select song_name 
    from songs 
    order by weeks_on_top_40 ASC, song_name ASC
    limit 5
```

Find the name and first year active of every artist whose name starts with the letter ‘B’. 

```sql 
    select artist_name, first_year_active 
    from Artists 
    where artist_name like 'B%' 
```

Find the total number of albums released per genre. 

```sql 
    select genre, count(album_id) as num_albums 
    from albums
    group by genre
```

Find the total number of albums released per genre.  Don’t include genres with a count less than 10.

``` sql 
    select genre, count(album_id) as num_albums 
    from albums 
    group by genre 
    having num_albums >= 10
```

Find the most popular album genre that is released in the year 2000. 

```sql 
    select genre 
    from albums 
    where year_released = 2000
    group by  
    order by count(*) DESC 
    LIMIT 1 
```


## Multiple Tables and Joins

Find the names of all artists who released a ‘country’ genre album in 2020.

```sql 
    select artist_name 
    from artists as a 
    inner join albums as b 
    on a.artist_id = b.artist_id 
    where  genre = 'country'
    and year_released = 2020
    group by a.artist_id, a.artist_name
```

Find the name of the album with the song that spend the most weeks in the top 40.  Assume there is only one such song.

```sql 
    select album_name 
    from albums as a
    inner join songs as b 
    on a.album_id = b.album_id
    order by weeks_on_top_40 DESC 
    limit 1
```

Find the the artist name and the most weeks one of their songs spent in the top 40 for each artist. Include artists that have not released an album.

```sql 
    select artist_name, max(weeks_on_top_40) as weeks_on_top_40 
    from artists left join  
    (songs inner join albums on songs.album_id = albums.album_id) 
    on artists.artist_id = albums.artist_id
    group by artist_name, artists.artist_id;
```