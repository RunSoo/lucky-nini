-- 코드를 작성해주세요
select a.year, (a.max_size - b.size_of_colony) as year_dev, b.id
from (
    select year(differentiation_date) as year, max(size_of_colony) as max_size
    from ecoli_data
    group by year(differentiation_date)
) as a
join ecoli_data b
on a.year = year(b.differentiation_date)
order by a.year, year_dev 