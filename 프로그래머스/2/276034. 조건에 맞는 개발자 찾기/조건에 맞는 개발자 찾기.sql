SELECT DISTINCT d.id, d.email, d.first_name, d.last_name
FROM skillcodes s, developers d
WHERE (s.name = 'C#' OR s.name = 'Python')
    AND (d.skill_code & s.code) > 0
ORDER BY d.id;