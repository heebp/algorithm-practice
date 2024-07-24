SELECT CAR_ID, round(avg(to_days(end_date) - to_days(start_date) + 1), 1) AVERAGE_DURATION from car_rental_company_rental_history
group by car_id
having avg(to_days(end_date) - to_days(start_date)) > 6
order by 2 desc, 1 desc