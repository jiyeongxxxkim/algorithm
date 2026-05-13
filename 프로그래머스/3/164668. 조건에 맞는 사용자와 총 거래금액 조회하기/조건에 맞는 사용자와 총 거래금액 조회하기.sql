

select u.user_id as user_id, u.nickname as nickname, sum(b.price) as total_sales
from used_goods_board as b join used_goods_user as u on b.writer_id=u.user_id
where b.status = 'DONE'
group by u.user_id
having sum(b.price)>=700000
order by total_sales asc












