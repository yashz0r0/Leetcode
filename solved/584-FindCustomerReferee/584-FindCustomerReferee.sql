-- Last updated: 22/06/2026, 23:52:53
# Write your MySQL query statement below
select name 
from customer c
where  c.referee_id!=2 or  c.referee_id is null;
