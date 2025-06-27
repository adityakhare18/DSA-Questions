-- niche wale case me answer shi milega pr null wala case nhi chalega
-- SELECT DISTINCT salary AS SecondHighestSalary
-- FROM Employee
-- ORDER BY salary DESC
-- LIMIT 1 OFFSET 1;  


SELECT MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);
