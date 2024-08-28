(Question)[https://leetcode.com/problems/combine-two-tables/description/]
<hr>
## Solution
``` SQL
select p.firstName, P.lastName, a.city, a.state
from Person p
Left join Address a
on p.personId = a.personId
```
(Question)[https://leetcode.com/problems/employee-bonus/description/]
<hr>
## Solution
``` SQL
SELECT e.name , b.bonus
FROM Employee e
LEFT JOIN Bonus b
ON e.empId  = b.empId 
WHERE b.bonus < 1000 OR b.bonus IS NULL
```