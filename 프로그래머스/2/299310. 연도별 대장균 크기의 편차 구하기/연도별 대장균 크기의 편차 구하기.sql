-- 코드를 작성해주세요
# select year(DIFFERENTIATION_DATE) as YEAR, 
#         b.YEAR_MAX - a.SIZE_OF_COLONY as YEAR_DEV,
#         ID
# from ecoli_data a inner join
#     (select year(DIFFERENTIATION_DATE) as YEAR, max(SIZE_OF_COLONY) as YEAR_MAX
#      from ecoli_data
#      group by YEAR
#     ) b
# on year(a.DIFFERENTIATION_DATE) = b.YEAR
# order by year asc, year_dev asc;


SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
        (B.YEAR_MAX - A.SIZE_OF_COLONY) AS YEAR_DEV,
        ID
FROM ECOLI_DATA A INNER JOIN (
        SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
            MAX(SIZE_OF_COLONY) AS YEAR_MAX
        FROM ECOLI_DATA GROUP BY YEAR) B
    ON YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC;




