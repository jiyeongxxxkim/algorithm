# -- 코드를 입력하세요
# select price as price_group, count(*) as products
# from(SELECT product_id, floor((price/10000))*10000 as price
# From product
# ) as product
# group by price
# order by price_group asc;


# with grp as(select *, floor(price/10000)*10000 as groupp
# from product)
# select g.groupp as PRICE_GROUP, count(p.product_id) as PRODUCTS
# from product as p join grp as g on p.product_id=g.product_id
# group by g.groupp
# order by PRICE_GROUP asc;



with regards as (select *, floor(price/10000) as rd
from product)
select rd*10000 as price_group, count(*) as products
from regards
group by rd
order by rd asc














