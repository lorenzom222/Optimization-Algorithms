
## Question 2

### 2.1

Minimize: P = 45a + 50b
Subject to:
250a + 400b <= 70,000
a + b <= 250 
a, b ≥ 0


Augmented Matrix:
```
| a | b  | c |
| - | - | - |
| 1 | 1 | 250|
| 250 | 400 | 70,000 |
| - | - | - |
| 45 | 50 | 0 |
```



Tableu 1:
```
| a | b  | s1   | s2    || c       |
| - | -- | ---- | ----- || ------- |
| 1 | 1 | 1  | 0  || 250    |
| 250 | 400*  | 0 | 1   || 70,000    |
| - | -- | ---- | ----- || ------- |
| -45 | -50 | 0 | 0 || 0 |
```


Tableu 2:
```
| a | b  | s1   | s2    || c       |
| - | -- | ---- | ----- || ------- |
| 3/8* | 0 | 1  | -1/400  || 75 |
| 5/8 | 1  | 0 | 1/400   || 175 |
| - | -- | ---- | ----- || ------- |
| -55/4 | 0 | 0 | 5/40 || 8750 |
```

Tableu 3 (Final):
```
| a | b  | s1   | s2    || c       |
| - | -- | ---- | ----- || ------- |
| 1 | 0 | 8/3 | -1/150  || 200 |
| 0 | 1 | -5/3 | 1/150  || 50 |
| - | - | - | - || - |
| 0 | 0 | 110/3 | 13/60 || 11500 |
```

$x = 200, y = 50, Profit = 11500$



### 2.2

Minimize: Cost = 25x + 20y
Subject to:
2x + y ≥ 12
2x + 9y ≥ 36
2x + 3y ≥ 24
x, y ≥ 0

1.  Form Augented Matrix for Inequalities
```
x y | b
----|---
2 1 | 12
2 9 | 36
2 3 | 24
----|---
25 20 | 0
```

2. *Transpose it*

```
u v w | b
------|---
2 2 2 | 25
1 9 3 | 20
------|---
12 36 24 | 0
```
3. Dual Maximization Problem (*New Objective Function and Constraints*):

Maximize: $Z = 12u + 36v + 24w$

Subject to (*now non-negative*):
$2u + 2v + 2w \leq -25$
$1u + 9v + 3w \leq 20$
$u, v , w \geq 0$

4. Perform Simplex Method

Tableu 1:
```
| u   | v   | w   | s1  | s2  | b   |
| --- | --- | --- | --- | --- | --- |
| 2   | 2   | 2   | 1   | 0   | 25  |
| 1   | 9*  | 3   | 0   | 1   | 20  |
| -12 | -36 | -24 | 0   | 0   | 0   |

```

make this into a table in markdown and put in a code block:Tableu 1:
```
| u    | v    | w    | s1   | s2   || b    |
| ---- | ---- | ---- | ---- | ---- || ---- |
| 2    | 2    | 2    | 1    | 0    || 25   |
| 1    | 9*   | 3    | 0    | 1    || 20   |
| ---- | ---- | ---- | ---- | ---- || ---- |
| -12  | -36  | -24  | 0    | 0    || 0    |
```

add line to seperate entire last row and entire last colunm too



Tableu 2:
```
| u      | v | w      | s1 | s2     || b        |
| ------ | - | ------ | -- | ------ || -------- |
| 16/9   | 0 | 4/3    | 1  | 0      || 185/9    |
| 1/9    | 1 | 1/3*   | 0  | 1/9    || 20/9     |
| ------ | - | ------ | -- | ------ || -------- |
| -8     | 0 | -12    | 0  | 4      || 80       |

```

Tableu 3:
```
| u      | v  | w | s1 | s2      || b       |
| ------ | -- | - | -- | ------- || ------- |
| 4/3*   | -4 | 0 | 1  | -2/3    || 35/3    |
| 1/3    | 3  | 1 | 0  | 1/3     || 20/3    |
| ------ | -- | - | -- | ------- || ------- |
| -4     | 36 | 0 | 0  | 8       || 160     |

```


Tableu 4 (Final):
```
| u | v  | w | s1   | s2    || b       |
| - | -- | - | ---- | ----- || ------- |
| 1 | -3 | 0 | 3/4  | -1/2  || 35/3    |
| 0 | 2  | 1 | -1/4 | 1/6   || 15/4    |
| - | -- | - | ---- | ----- || ------- |
| 0 | 24 | 0 | 3    | 6     || 195     |
```

x = 3, y = 6, Profit = 195


### 2.3



Tableu 4 (Final):
```
| u | v  | w | s1   | s2    | s3 | b       |
| - | -- | - | ---- | ----- |    | ------- |
| -4/7 | 1 | 0 | 10/7  | 0 | -24/7 | 580 |
| 91/50 | 0  | 0 | -14/5 | 1 | 4 | 483 |
| 16/35 | 0  | 1 | -30/35 | 0 | 20/7 | 852 |
| - | -- | - | ---- | ----- |---| ------- |
| -75/7 | 0 | 0 | 170/7 | 0 | -100/7 | 75,860 |
```




https://college.cengage.com/mathematics/larson/elementary_linear/4e/shared/downloads/c09s4.pdf