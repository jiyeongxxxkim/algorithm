# select count(distinct id) as count
# from ECOLI_DATA 
# where (genotype&2)=0 and (((genotype&1)>0)or((genotype&4)>0))





# select count(distinct id) as count
# from ECOLI_DATA
# where (GENOTYPE&2)=0 && ((GENOTYPE&1)>0 or (GENOTYPE&4)>0)




# select count(*) as count
# from ecoli_data
# where (genotype&2=0) && ((genotype&1>0)or(genotype&4)>0)


select count(distinct id) as count
from ECOLI_DATA 
where ((GENOTYPE&1)>0||(GENOTYPE&4)>0)&&((GENOTYPE&2)=0)













