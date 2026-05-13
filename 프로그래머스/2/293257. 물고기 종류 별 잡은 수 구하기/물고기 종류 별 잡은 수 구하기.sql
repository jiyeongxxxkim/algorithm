# select count(*) as fish_count, n.fish_name
# from fish_info as i join fish_name_info as n on i.fish_type=n.fish_type
# group by n.fish_name
# order by fish_count desc



# select count(i.id) as fish_count, n.fish_name
# from fish_info as i join fish_name_info as n on i.fish_type=n.fish_type
# group by n.fish_name
# order by fish_count desc;




select count(*) as fish_count, n.fish_name
from fish_info as f join fish_name_info as n on f.fish_type=n.fish_type
group by n.fish_name
order by fish_count desc



















