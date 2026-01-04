-- 코드를 작성해주세요
select b.id, a.fish_name, a.length
from (select n.fish_type, n.fish_name, max(i.length) as length
    from fish_info i
    join fish_name_info n
    on i.fish_type = n.fish_type
    group by i.fish_type, n.fish_name
     ) a
join fish_info b
on a.fish_type = b.fish_type
where a.length = b.length
order by b.id;