-- Last updated: 22/06/2026, 23:52:50
SELECT name, population, area
FROM world
WHERE area >= 3000000
   OR population >= 25000000;
