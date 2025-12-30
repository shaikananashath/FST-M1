-- Add the grade column
ALTER TABLE salesman ADD (grade int);

-- Update the values in the grade column for everyone to 100
UPDATE salesman SET grade=100;

-- Display data
SELECT * FROM salesman;