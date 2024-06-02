-- 코드를 입력하세요
SELECT round(avg(daily_fee),0) as average_fee 
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'suv';