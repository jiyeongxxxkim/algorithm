# select e2.id, e2.GENOTYPE, e1.GENOTYPE as PARENT_GENOTYPE
# from ECOLI_DATA as e1 join ECOLI_DATA  as e2 on e1.id=e2.parent_id
# where (e2.GENOTYPE&e1.GENOTYPE)=e1.GENOTYPE
# order by e2.id



# select e2.id, e2.GENOTYPE, e1.GENOTYPE as parent_GENOTYPE
# from ECOLI_DATA as e1 join ECOLI_DATA as e2 on e1.id=e2.parent_id
# where (e2.GENOTYPE&e1.GENOTYPE)=e1.GENOTYPE
# order by e2.id



# select e2.id, e2.genotype, e1.genotype as PARENT_GENOTYPE
# from ecoli_data as e1 join ecoli_data as e2 on e1.id=e2.parent_id
# where (e1.genotype&e2.genotype)=e1.genotype
# order by e2.id asc;


# select e2.id, e2.genotype, e1.genotype as PARENT_GENOTYPE
# from ECOLI_DATA as e1 join ECOLI_DATA as e2 on e1.id=e2.parent_id
# where (e1.genotype&e2.genotype)=e1.genotype
# order by e2.id asc;


select e2.id, e2.GENOTYPE, e1.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as e1 join ECOLI_DATA as e2 on e1.id=e2.parent_id
where (e1.GENOTYPE&e2.GENOTYPE)=e1.GENOTYPE
order by id asc













