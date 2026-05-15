# select distinct d.id, d.email, d.first_name, d.last_name
# from skillcodes as s join developers as d on (s.code&d.skill_code)>0
# where s.name='C#' or s.name='Python'
# order by d.id asc


# select distinct d.id, d.email, d.first_name, d.last_name
# from developers as d join skillcodes as s on (d.skill_code&s.code)>0
# where s.name = 'C#' or s.name='Python'
# order by d.id asc;


# select id, email, first_name, last_name
# from developers as d
# where (d.skill_code&(select sum(code) from skillcodes where name="C#" or name="Python"))>0
# order by id asc;

select id, email, first_name, last_name
from developers 
where skill_code&(select sum(code) from skillcodes where name in ('C#', 'Python'))>0
order by id asc;














