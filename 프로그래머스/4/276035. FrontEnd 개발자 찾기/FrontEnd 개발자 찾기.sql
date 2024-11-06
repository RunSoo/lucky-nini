-- 코드를 작성해주세요
SELECT DISTINCT d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d
JOIN SKILLCODES s
ON d.SKILL_CODE & s.CODE = s.CODE
WHERE s.CATEGORY = 'Front End'
ORDER BY d.ID;