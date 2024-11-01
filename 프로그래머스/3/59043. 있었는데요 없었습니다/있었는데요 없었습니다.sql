-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS i
JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE TIMESTAMPDIFF(SECOND, i.DATETIME, o.DATETIME) < 0
ORDER BY i.DATETIME;