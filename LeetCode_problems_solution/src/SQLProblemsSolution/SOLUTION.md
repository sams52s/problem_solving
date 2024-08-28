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
