-- 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력
SELECT YEAR(o.SALES_DATE) AS YEAR, MONTH(o.SALES_DATE) AS MONTH, COUNT(DISTINCT o.USER_ID) AS PURCHASED_USERS, ROUND(COUNT(DISTINCT o.USER_ID)/(SELECT COUNT(USER_ID) FROM USER_INFO WHERE YEAR(JOINED) = 2021), 1) AS PUCHASED_RATIO
FROM (SELECT o.SALES_DATE, o.USER_ID FROM ONLINE_SALE o JOIN USER_INFO u ON o.USER_ID = u.USER_ID WHERE YEAR(u.JOINED) = 2021) as o
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE)
