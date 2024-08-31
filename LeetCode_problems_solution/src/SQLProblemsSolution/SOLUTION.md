# Problem 1
[Question](https://leetcode.com/problems/combine-two-tables/description/)

## Solution

``` SQL
SELECT p.firstName, P.lastName, a.city, a.state
FROM Person p
LEFT JOIN Address a
ON p.personId = a.personId
```
<hr>

# Problem 2

[Question](https://leetcode.com/problems/employee-bonus/description/)

## Solution

``` SQL
SELECT e.name , b.bonus
FROM Employee e
LEFT JOIN Bonus b
ON e.empId  = b.empId 
WHERE b.bonus < 1000 OR b.bonus IS NULL
```

# Problem 3

[Question](https://leetcode.com/problems/managers-with-at-least-5-direct-reports/)

## Solution

``` SQL
SELECT e.name
FROM Employee AS e 
INNER JOIN Employee AS m ON e.id=m.managerId 
GROUP BY m.managerId 
HAVING COUNT(m.managerId) >= 5
```
# Problem 4

[Question](https://leetcode.com/problems/rank-scores/description/)

## Solution

``` SQL
SELECT 
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS "rank"
FROM 
    Scores
ORDER BY 
    score DESC;
```

# Problem 5

[Question](https://leetcode.com/problems/second-highest-salary/description/)

## Solution

``` SQL
SELECT 
    (SELECT DISTINCT salary
     FROM Employee
     ORDER BY salary DESC
     LIMIT 1 OFFSET 1)
AS SecondHighestSalary;
```

# Problem 5

[Question](https://leetcode.com/problems/nth-highest-salary/description/)

## Solution

``` SQL
CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
   SELECT sub.salary
    FROM (
      SELECT 
        e.salary, 
        DENSE_RANK() OVER (ORDER BY e.salary DESC) AS rank
      FROM 
        Employee e
    ) sub
    WHERE sub.rank = N
    LIMIT 1
  );
END;
$$ LANGUAGE plpgsql;
```
