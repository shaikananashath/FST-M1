-- Step 1: Add a new integer column named 'grade'
ALTER TABLE salesman
ADD grade INT;

-- Step 2: Set the value of 'grade' to 100 for all rows
UPDATE salesman
SET grade = 100;

-- Step 3: Show the final table data
SELECT * FROM salesman;