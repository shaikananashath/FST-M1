-- Query 1: Show data from the salesman_id and salesman_city columns
SELECT salesman_id, salesman_city
FROM salesman;

-- Query 2: Show data of salesmen from Paris
SELECT *
FROM salesman
WHERE salesman_city = 'Paris';

-- Query 3: Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission
FROM salesman
WHERE salesman_name = 'Paul Adam';