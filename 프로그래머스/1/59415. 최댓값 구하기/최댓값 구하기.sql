-- 코드를 입력하세요
SELECT datetime as 시간
from animal_ins
where datetime = (select max(datetime)
                 from animal_ins);
                 
                 