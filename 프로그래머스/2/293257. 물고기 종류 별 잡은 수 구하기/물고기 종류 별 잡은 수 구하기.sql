select COUNT(*) as FISH_COUNT, FISH_NAME 
from fish_info as a
left join fish_name_info b
on a.fish_type = b.fish_type
group by fish_name
order by 1 desc;