# select date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, user_id, sales_amount
# from online_sale
# where date_format(sales_date, '%Y-%m-%d') like '2022-03-%'
# union all
# select date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, null as user_id, sales_amount
# from offline_sale
# where date_format(sales_date, '%Y-%m-%d') like '2022-03-%'
# order by sales_date asc, product_id asc, user_id asc;



# select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, product_id, user_id, sales_amount
# from online_sale
# where date_format(sales_date, '%Y-%m-%d') like '2022-03-%'
# union all
# select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, product_id, null, sales_amount
# from offline_sale
# where date_format(sales_date, '%Y-%m-%d') like '2022-03-%'
# order by SALES_DATE asc, product_id asc, user_id asc;



select n.sales_date as SALES_DATE, n.product_id as PRODUCT_ID, n.user_id, n.sales_amount
from online_sale as n
where n.sales_date like '2022-03%'
union all 
select f.sales_date  as SALES_DATE, f.product_id as PRODUCT_ID, null,  f.sales_amount
from offline_sale as f
where f.sales_date like '2022-03%'
order by SALES_DATE asc, PRODUCT_ID asc, user_id asc;














