SELECT TRUNC(PRICE, -4) AS PRICE_GROUP, COUNT(*) AS COUNT
FROM PRODUCT
GROUP BY TRUNC(PRICE, -4)
ORDER BY TRUNC(PRICE, -4) ASC;