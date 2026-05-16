# select distinct d.id, d.email, d.first_name, d.last_name
# from skillcodes as s join DEVELOPERS as d on (s.code&d.skill_code)>0
# where s.category='Front End'
# order by d.id asc;



# select distinct d.id, d.email, d.first_name, d.last_name
# from developers as d join skillcodes as s on (d.skill_code&s.code)>0
# where s.category = 'Front End'
# order by d.id asc;

select id, email, first_name, last_name
from DEVELOPERS as d 
where (skill_code&(select sum(code) from skillcodes where category="Front End"))>0
order by id asc















