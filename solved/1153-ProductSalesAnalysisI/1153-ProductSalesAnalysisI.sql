-- Last updated: 23/06/2026, 00:03:41
# Write your MySQL query statement below
select product_name, year,price
from sales s join product p
where s.product_id=p.product_id