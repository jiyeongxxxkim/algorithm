


select i.animal_id, i.name
from ANIMAL_INS as i join ANIMAL_OUTS as o on i.animal_id=o.animal_id
where i.datetime>o.datetime
order by i.datetime asc












