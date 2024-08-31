# Problem 1
## 175. Combine Two Tables
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
## 577. Employee Bonus
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
## 570. Managers with at Least 5 Direct Reports
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
## 178. Rank Scores
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
## 176. Second Highest Salary
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

# Problem 6
## 177. Nth Highest Salary
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

# Problem 7
## 180. Consecutive Numbers
[Question](https://leetcode.com/problems/consecutive-numbers/description/)

## Solution

``` SQL
-- Write your PostgreSQL query statement below
SELECT DISTINCT num AS ConsecutiveNums
FROM (
    SELECT
    LAG(id) OVER(ORDER BY id) as prev_id,id,
    LEAD(id) OVER (ORDER BY id) as next_id,
    LAG(num) OVER (ORDER BY id) AS prev_num,num,
    LEAD(num) OVER (ORDER BY id) AS next_num
    FROM logs
) s_q
WHERE prev_num = num 
AND num = next_num
AND next_id - id = 1 
AND id - prev_id = 1;
```
