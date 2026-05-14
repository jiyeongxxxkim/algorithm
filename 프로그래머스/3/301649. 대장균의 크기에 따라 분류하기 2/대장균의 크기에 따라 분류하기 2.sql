# with rankt as (select *, percent_rank() over (order by SIZE_OF_COLONY desc) as sizerank
# from ECOLI_DATA)
# select r.id, 
# case when r.sizerank<=0.25 then 'CRITICAL'
#     when r.sizerank<=0.5 then 'HIGH'
#     when r.sizerank<=0.75 then 'MEDIUM'
#     else 'LOW' 
#     end as COLONY_NAME
# from rankt as r join ECOLI_DATA as e on r.id=e.id
# order by r.id asc;

# select id, case when percent_rank() over (order by SIZE_OF_COLONY desc) <= 0.25 then 'CRITICAL'
# when percent_rank() over (order by SIZE_OF_COLONY desc) <= 0.5 then 'HIGH'
# when percent_rank() over (order by SIZE_OF_COLONY desc) <= 0.75 then 'MEDIUM' else 'LOW'end as colony_name
# from ecoli_data
# order by id asc

with getsize as(select *, percent_rank() over (order by size_of_colony desc)*100 as sizerank
from ECOLI_DATA)
select id, (case when sizerank<=25 then 'CRITICAL'
           when sizerank<=50 then 'HIGH'
           when sizerank<=75 then 'MEDIUM'
           else 'LOW' end) as COLONY_NAME
from getsize
order by id asc















