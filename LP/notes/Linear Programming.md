Linear Programming

maximize $c^Tx$:
Subject to:
	$Ax <= b$
- A: Matrix of Coefficents
- b: Vector of constants


Minimize: Cost = 25x + 20y
Subject to:
2x + y ≥ 12
2x + 9y ≥ 36
2x + 3y ≥ 24
x, y ≥ 0

## Slack: 
A slack variable is a variable that is introduced into a linear programming problem to convert an inequality constraint into an equation. It represents the difference between the two sides of the inequality and measures how much “slack” or “wiggle room” there is in satisfying the constraint.

__Key__:

- Difference between the LHS and RHS of inequality
- Represents the "wiggle room" that exist to satisfy the constraint

$s  = b - Ax$

*Sign of Slack*:

- ax + by ≤ c: ax + by + s = c (non-negative)
- ax + by ≥ c: ax + by - s = c (non-positive)

*Example:*

If 2x + y is less than 12:
- it means that the distance between the two points is less than the length of the rope. 
- In this case, when you tie the rope between the two points, there will be some slack in the rope. 

The slack variable s represents the amount of slack in the rope.



In constraint *2x + y ≤ 12*, this inequality can be converted into an equation by adding a slack variable s to the left-hand side: $2x + y + s = 12$. 

The value of s represents the difference between 12 and 2x + y. If 2x + y is less than 12, then s will be positive and will represent the amount of slack in satisfying the constraint. If 2x + y is equal to 12, then s will be zero and the constraint will be satisfied exactly.

In summary, a slack variable is a tool used in linear programming to convert inequality constraints into equations. It measures the amount of slack in satisfying a constraint and helps us find an optimal solution to the problem 


Ex:

```
2x + y = s1 + 12
2x + 9y = s2 + 36
2x + 3y = s3 + 24

|
v

s1 = 12 - (2x + y)
s2 = 36 - (2x + 9y)
s3 = 24 - (2x + 3y)
```

This allows us to covert inequalities (eg. ≥) to equalities. Needed to solve problems with Simplex Algorithm.


## Simplex:
1. Convert *linear program* into slack form
	 - Useful for algebraic manipulations and concept

*Tight*: 


Continue Example:

```
minimize: z  = 25x + 20y
Subject to:
	2x + y - s1 = 12
	2x + 9y -s2 = 36
	2x + 3y -s3 = 24
```

*tableau*: 

```
x y s1 s2 s3 z | b
---------------|---
2 1 -1 0  0  0 | 12
2 9  0 -1 0  0 | 36
2 3  0 0 -1  0 | 24
---------------|---
-25 -20 0 0 0 1| 0
```

### Pivot

__Selecting a Pivot Column__:

Choose pivot column (column of the variables) that contains the largest negative coefficent in the object function. *The purpose of this is to focus on the term that influences that objective the most*.

Ex. The $x$ column has -25, therefore we choose that one


__Selecting a Pivot Row__:

Choose pivot row that contains the smallest *test ratio*, ration of each constraint to it's respective coefficent in the pivot column

Ex.
- Row1 test ratio = 12/2 = 6 !!
- Row2 test ratio = 36/2 = 18
- Row3 test ratio = 24/2 = 12
- Row1 is the pivot row

__Gaussian elimination__:
Max out the contribution of the pivot (pivot row by colunm entry we selected in the previous steps). We do this by zeroing out all non-pivot values.

First Iteration:

```

x y s1 s2 s3 z | b
---------------|---
2 1 -1 0  0  0 | 12
0 8  1 -1 0  0 | 24
0 2  1 0 -1  0 | 12
---------------|---
0 -15/2 -25/2 0 0 1| 150
```
- Zero out Row 2 and 3 in $x$ column by subtracting Pivot row
- Zero out Row Objective in $x$ column by subtracting -25 * Pivot row

Second Iteration:
1. Select row $y$, only consider objective variable (not slacks) when selecting pivot
2. Row2 min with test ratio of 24/8 = 3
3.
```
x y s1 s2 s3 z | b
---------------|---
2 1 -1 0  0  0 | 12
0 8  1 -1 0  0 | 24
0 2  1 0 -1  0 | 12
---------------|---
0 -15/2 -25/2 0 0 1| 150
```
- Zero out Row 2 and 3 in $x$ column by subtracting Pivot row
- Zero out Row Objective in $x$ column by subtracting -25 * Pivot row


### Simplex Method: Minimization


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

| u | v  | w | s1   | s2    || b       |
| - | -- | - | ---- | ----- || ------- |
| 1 | -3 | 0 | 3/4  | -1/2  || 35/3    |
| 0 | 2  | 1 | -1/4 | 1/6   || 15/4    |
| 0 | 24 | 0 | 3    | 6     || 195     |
| - | -- | - | ---- | ----- || ------- |






