# with recursive time as(select 0 as hour 
# union all
# select hour+1
# from time
# where hour<23)
# select t.hour, count(case when o.animal_id is not null then 1 else null end) as count
# from time as t left join ANIMAL_OUTS as o on t.hour= hour(o.datetime)
# group by t.hour
# order by t.hour

with recursive time as (select 0 as hour
                       union all
                       select hour+1
                       from time
                       where hour<23)
select f.hour as HOUR, count(case when o.animal_id is not null then 1 else null end) as COUNT
from time as f left join ANIMAL_OUTS as o on f.hour=hour(o.datetime)
group by f.hour
order by f.hour asc















