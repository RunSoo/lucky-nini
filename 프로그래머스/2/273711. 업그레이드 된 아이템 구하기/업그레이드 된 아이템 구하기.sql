select i.item_id, i.item_name, i.rarity
from item_info i
join item_tree t
on t.item_id = i.item_id
where t.parent_item_id in (select item_id from item_info where rarity = 'RARE') 
order by item_id desc