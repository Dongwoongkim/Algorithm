-- 코드를 입력하세요
select a.TITLE, 
    a.BOARD_ID,
    b.REPLY_ID, 
    b.WRITER_ID,  
    b.CONTENTS, 
    date_format(b.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
from used_goods_board as a
inner join used_goods_reply as b
    on a.BOARD_ID = b.BOARD_ID
where year(a.created_date) = 2022 AND month(a.created_date) = 10
order by b.created_Date asc, a.TITLE asc;