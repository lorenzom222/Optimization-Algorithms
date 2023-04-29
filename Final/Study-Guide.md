# Study Guide for CSC 282

## DP vs Greedy

- When do choose greedy or dp

### DP

1. Define the subproblems: 
	- Break down the original problem into smaller, overlapping subproblems. 
	- These subproblems should be smaller instances of the original problem and should be easier to solve. 
	- The solutions to these subproblems can then be combined to solve the original problem.

$P = \{p_1, p_2, ..., p_n\}$ where $P$ is the set of subproblems and $p_i$ is a subproblem.

2. Give a recursive definition of the solution to the subproblems: 
	- Express the solution to the original problem in terms of the solutions to smaller instances of the same problem (i.e., the subproblems). This is known as a recurrence relation. It defines the value of the solution in terms of the values of smaller subproblems.

$S(p_i) = f(S(p_j), S(p_k), ...)$ where $S(p_i)$ is the solution to subproblem $p_i$ and $f$ is a function that combines the solutions to smaller subproblems to solve $p_i$.


3. Give an efficient algorithm to solve the problem: 
	- Use dynamic programming techniques such as memoization or tabulation to store and reuse solutions to subproblems. This can help avoid redundant calculations and improve the efficiency of the algorithm.

$DP = \{S(p_1), S(p_2), ..., S(p_n)\}$ where $DP$ is the dynamic programming table that stores the solutions to subproblems.


**Ex. LCS**:
*Problem*: Finding the longest common subsequence (LCS) of two strings $X$ and $Y$.

1. Define the subproblems: 
  	- Break down the original problem of finding the longest common subsequence (LCS) of two strings $X$ and $Y$ into smaller, overlapping subproblems.
	-  We can define the subproblems as finding the LCS of prefixes of $X$ and $Y$. 
	- Let $LCS[i,j]$ denote the length of the LCS of the first $i$ characters of $X$ and the first $j$ characters of $Y$

2. Give a recursive definition of the solution to the subproblems: 
    - Express the solution to the original problem in terms of the solutions to these subproblems using the following recurrence relation:
    $$LCS[i,j] = \begin{cases} 0 & \text{if } i = 0 \text{ or } j = 0 \\ LCS[i-1,j-1] + 1 & \text{if } X_i = Y_j \\ \max(LCS[i-1,j], LCS[i,j-1]) & \text{otherwise}\end{cases}$$

    $$\left( \sum_{k=1}^n a_k b_k \right)^2 \leq \left( \sum_{k=1}^n a_k^2 \right) \left( \sum_{k=1}^n b_k^2 \right)$$

```math
LCS[i,j] =
\begin{cases}
0 & \text{if } i = 0 \text{ or } j = 0 \\
LCS[i-1,j-1] + 1 & \text{if } X_i = Y_j \\
\max(LCS[i-1,j], LCS[i,j-1]) & \text{otherwise}
\end{cases}
```

**Here is some math!**

```math
\sqrt{3}
+ 2
```

3. Give an efficient algorithm to solve the problem:
    - Use dynamic programming techniques such as tabulation to fill in a table of size $(m+1) \times (n+1)$ with the solutions to these subproblems.
    - The entry in the bottom-right corner of the table, $LCS[m,n]$, gives us the length of the LCS of $X$ and $Y$. We can also use this table to reconstruct the actual LCS by tracing back through the table from the bottom-right corner


**Ex. Computing the nth Fibonacci number**:

1. Define the subproblems: 
	- Let F(n) denote the nth Fibonacci number. F(n) can be broken down into smaller subproblems F(n-1) and F(n-2).

2. Give a recursive definition of the solution to the subproblems: 
	- The recurrence relation for F(n) is F(n) = F(n-1) + F(n-2).

3. Give an efficient algorithm to solve the problem:
	- Use dynamic programming techniques such as memoization or tabulation to store and reuse solutions to subproblems F(n).


* Rod
* Coin Problem
* Knapsack
* Activity

- Greedy vs DP
	- Greedy Coins: Given a domain of coins, will greedy always yield correct answer?
	- 

## Graph
* Basic Search
* Max Flow
* MST

* Single Shortest Path
* All-Pairs

## Linear Programming
* Simplex
* Primal and Dual

## Etc.
* Divide and Conquer
* Convex Hull (Computational Geometry)
* NP-Hardness



https://tildesites.bowdoin.edu/~ltoma/teaching/cs231/fall05/Problems/dynprogr.pdf

http://www.cs.otago.ac.nz/cosc242/pdf/L22.pdf

