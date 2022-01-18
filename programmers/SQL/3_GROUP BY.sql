##### GROUP BY #####
# 1 고양이와 개는 몇 마리 있을까
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) FROM ANIMAL_INS GROUP BY ANIMAL_TYPE HAVING ANIMAL_TYPE LIKE "Cat" OR ANIMAL_TYPE LIKE "Dog" ORDER BY ANIMAL_TYPE;

# 2 동명 동물 수 찾기
SELECT NAME, COUNT(NAME) AS COUNT FROM ANIMAL_INS GROUP BY NAME HAVING COUNT(NAME) >= 2 ORDER BY NAME;

# 3 입양 사각 구하기(1)
SELECT HOUR(DATETIME) AS HOUR, COUNT(HOUR(DATETIME)) AS COUNT 
FROM ANIMAL_OUTS 
WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) < 20
GROUP BY HOUR(DATETIME) 
ORDER BY HOUR(DATETIME);

# 4 입양 사각 구하기 (2)
WITH RECURSIVE TIME AS (SELECT 0 AS HOUR UNION ALL SELECT HOUR + 1 FROM TIME WHERE HOUR < 23)
SELECT HOUR, COUNT(ANIMAL_ID) AS COUNT
FROM TIME LEFT JOIN ANIMAL_OUTS ON (HOUR = HOUR(DATETIME))
GROUP BY HOUR;