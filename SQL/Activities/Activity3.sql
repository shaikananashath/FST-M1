-- Show data from the salesman_id and city columns
select salesman_id, salesman_city from salesman;

-- Show data of salesman from Paris
select * from salesman where salesman_city='Paris';

-- Show salesman_id and commission of Paul Adam
select salesman_id, commission from salesman where salesman_name='Paul Adam';