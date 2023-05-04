------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 1
Linear Programming Duality

Select all objectives and constraints for the dual.

LP #1

max $$2x+3y$$
$$4x+5y\leq 7$$
$$6x+7y\leq 8$$
$$9x+y=5$$
$$x\geq 0$$

[ ] min $$2z+3w$$
[ ] min $$7z+8w$$
[X] min $$7z+8u+5w$$
[ ] min $$2z+3u+5w$$
[ ] max $$2z+3w$$
[X] $$4z + 6u + 9w \geq 2$$
[ ] $$4z + 6u + 9w = 2$$
[ ] $$5z + 7u + w \geq 3$$
[X] $$5z + 7u + w = 3$$
[X] $$z\geq 0$$
[X] $$u\geq 0$$
[ ] $$w\geq 0$$

LP #2

max $$2x+3y$$
$$4x+5y\leq 7$$
$$6x+7y = 8$$
$$9x+y=5$$
$$y\geq 0$$

[ ] min $$2z+3w$$
[ ] min $$7z+8w$$
[X] min $$7z+8u+5w$$
[ ] min $$2z+3u+5w$$
[ ] max $$2z+3w$$
[ ] $$4z + 6u + 9w \geq 2$$
[X] $$4z + 6u + 9w = 2$$
[X] $$5z + 7u + w \geq 3$$
[ ] $$5z + 7u + w = 3$$
[X] $$z\geq 0$$
[ ] $$u\geq 0$$
[ ] $$w\geq 0$$
------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 2 
Water supply

We have $$n$$ water sources $$1,\dots,n$$. We have $$m$$ cities $$1,\dots,m$$. The $$i$$-th water source can produce $$P[i]>0$$ liters of water per second. The $$j$$-th city has a demand for $$D[j]>0$$ liters of water per second. The cost of transporting one liter of water from $$i$$-th water source to $$j$$-th city is $$T[i,j]>0$$. We want to figure out a supply plan for the cities that satisfies all the demands while minimizing the cost. We will do it using linear programming. Let $$X[i,j]\geq 0$$ be the amount of water (in liters per second) that will be transported from source $$i$$ to city $$j$$. Note that $$P[i]$$'s, $$D[j]$$'s, and $$T[i,j]$$'s are parameters of the problem and $$X[i,j]$$'s are variables. You are not allowed any other variables in your program.

Write a linear program for the problem.

minimize sum_{i,j} T[i,j]\*X[i,j]

for every j\in [m] \sum_{i} X[i,j] >= D[j]
for every i\in [n] \sum_{j} X[i,j] <= P[i]

X[i,j]>=0

The water produced at $$i$$-th water source contains $$A[i]$$ grams of arsenic per liter. EPA regulations allow $$L$$ grams of arsenic per liter. We want to add constraints to the linear program for the basic problem that will ensure that the water supplied to each city is compliant with the EPA regulations (while satisfying all the demands and minimizing the cost).

for every j\in [m] \sum_{i} X[i,j] * A[i] <= L * \sum_{i} X[i,j]

LHS = total amount of arsenic in the water delivered to city j
RHS = maximum total amount of arsenic allowed
------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 3
Integer Linear Programming

Select all objectives and constraints for the integer linear program for the specific problem.

Minimum vertex cover (input: undirected G=(V,E))

[ ] $$(\forall v\in V) \sum_{e;v\in e} x_e \geq 1$$
[ ] $$(\forall v\in V) \sum_{e;v\in e} x_e \leq 1$$
[X] $$(\forall \{u,v\}\in E)\ y_u + y_v\geq 1$$
[ ] $$(\forall \{u,v\}\in E)\ y_u + y_v\leq 1$$
[X] $$(\forall v\in V)\ 0\leq y_v\leq 1$$
[ ] $$(\forall e\in E)\ 0\leq x_e\leq 1$$
[ ] $$\max \sum_{e\in E} x_e$$
[ ] $$\min \sum_{e\in E} x_e$$
[ ] $$\max \sum_{v\in V} y_v$$
[X] $$\min \sum_{v\in V} y_v$$

Maximum matching (input: undirected G=(V,E))

[ ] $$(\forall v\in V) \sum_{e;v\in e} x_e \geq 1$$
[X] $$(\forall v\in V) \sum_{e;v\in e} x_e \leq 1$$
[ ] $$(\forall \{u,v\}\in E)\ y_u + y_v\geq 1$$
[ ] $$(\forall \{u,v\}\in E)\ y_u + y_v\leq 1$$
[ ] $$(\forall v\in V)\ 0\leq y_v\leq 1$$
[X] $$(\forall e\in E)\ 0\leq x_e\leq 1$$
[X] $$\max \sum_{e\in E} x_e$$
[ ] $$\min \sum_{e\in E} x_e$$
[ ] $$\max \sum_{v\in V} y_v$$
[ ] $$\min \sum_{v\in V} y_v$$
------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 4
Knapsack variants

We have $$n$$ items numbered $$1,\dots,n$$. The $$i$$-th item has weight $$W[i]$$ and volume $$V[i]$$. We have two thieves. The first thief can sell $$i$$-th item for $$A[i]$$ dollars. The second thief can sell $$i$$-th item for $$B[i]$$ dollars.  The thieves want to maximize the total amount of money made after the items they take are sold. In the recurrences below if some index is negative we let the value of $$T$$ negative infinity (negative infinity means there is no valid solution of the subproblem).

#1 Suppose that the first thief has a weight limit and the second thief has a volume limit. Let $$T[k,C,D]$$ be the value of the subproblem restricted to first $$k$$ items, weight limit $$C$$ for the first thief and volume limit $$D$$ for the second thief. Choose the recurrence for $$T[k,C,D]$$.

[ ] $$T[k,C,D]$$:=max$$( T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D-V[k]] + A[k], T[k-1,C-W[k],D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k,C-W[k],D] + A[k], T[k,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[X] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$

#2 Suppose that the first thief has a weight limit and the second thief has a weight limit. Let $$T[k,C,D]$$ be the value of the subproblem restricted to first $$k$$ items, weight limit $$C$$ for the first thief and weight limit $$D$$ for the second thief. Choose the recurrence for $$T[k,C,D]$$.

[ ] $$T[k,C,D]$$:=max$$( T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D-V[k]] + A[k], T[k-1,C-W[k],D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k,C-W[k],D] + A[k], T[k,C,D-V[k]] + B[k] )$$
[X] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$

#3 Suppose that the first thief has a weight limit and the second thief has a volume limit. The thieves have to take all the items (each item has to be assigned to the first thief or the second thief). Let $$T[k,C,D]$$ be the value of the subproblem restricted to first $$k$$ items, weight limit $$C$$ for the first thief and volume limit $$D$$ for the second thief. Choose the recurrence for $$T[k,C,D]$$.

[X] $$T[k,C,D]$$:=max$$( T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D-V[k]] + A[k], T[k-1,C-W[k],D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k,C-W[k],D] + A[k], T[k,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$

#4 The second thief has a broken back. Suppose that the first thief has two knapsacks each with a different weight limit. Let $$T[k,C,D]$$ be the value of the subproblem restricted to first $$k$$ items, weight limit $$C$$ for the first knapsack and weight limit $$D$$ for the second knapsack. Choose the recurrence for $$T[k,C,D]$$.

[ ] $$T[k,C,D]$$:=max$$( T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D-V[k]] + A[k], T[k-1,C-W[k],D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k,C-W[k],D] + A[k], T[k,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
[X] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$

#5 The second thief has a broken back. Suppose that the first thief has one knapsack with a weight limit and a volume limit. Let $$T[k,C,D]$$ be the value of the subproblem restricted to first $$k$$ items, weight limit $$C$$ for the knapsack and volume limit $$D$$ for the knapsack. Choose the recurrence for $$T[k,C,D]$$.

[ ] $$T[k,C,D]$$:=max$$( T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D-V[k]] + A[k], T[k-1,C-W[k],D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k,C-W[k],D] + A[k], T[k,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k,C-W[k],D-V[k]] + A[k] )$$
[X] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$

#6 In versions #1-#5 there was one copy of each item. Now the thieves are in a warehouse and for each item there is an unlimited supply. Suppose that the first thief has a weight limit and the second thief has a volume limit. Let $$T[k,C,D]$$ be the value of the subproblem restricted to first $$k$$ types of items, weight limit $$C$$ for the first thief and volume limit $$D$$ for the second thief. Choose the recurrence for $$T[k,C,D]$$.

[ ] $$T[k,C,D]$$:=max$$( T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D-V[k]] + A[k], T[k-1,C-W[k],D-V[k]] + B[k] )$$
[X] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k,C-W[k],D] + A[k], T[k,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$

#7 In versions #1-#5 there was one copy of each item. Now the thieves are in a warehouse and for each item there is an unlimited supply.  The second thief has a broken back. Suppose that the first thief has one knapsack with a weight limit and a volume limit. Let $$T[k,C,D]$$ be the value of the subproblem restricted to first $$k$$ items, weight limit $$C$$ for the knapsack and volume limit $$D$$ for the knapsack. Choose the recurrence for $$T[k,C,D]$$.

[ ] $$T[k,C,D]$$:=max$$( T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D-V[k]] + A[k], T[k-1,C-W[k],D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k,C-W[k],D] + A[k], T[k,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + B[k] )$$
[X] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D] , T[k-1,C-W[k],D] + A[k], T[k-1,C,D-W[k]] + A[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k-1,C,D], T[k-1,C-W[k],D] + A[k], T[k-1,C,D-V[k]] + B[k] )$$
[ ] $$T[k,C,D]$$:=max$$( T[k,C,D] , T[k-1,C-W[k],D-V[k]] + A[k] )$$
------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 5
Intervals

We have a collection of intervals $$[a_1,b_1],\dots,[a_m,b_m]$$ where $$0\leq a_i < b_i\leq n$$ and $$a_i$$ and $$b_i$$ are integer (for all $$i\in\{1,\dots,m\}$$). Assume that the intervals are sorted by their length.  We have values $$c_1,\dots,c_m$$ for the intervals. We say that interval $$[a_i,b_i]$$ is contained in an interval $$[A,B]$$ if $$A\leq a_i<b_i\leq B$$. We say that two intervals $$[a_i,b_i]$$ and $$[a_j,b_j]$$ cross if $$a_i<a_j<b_i<b_j$$ or $$a_j<a_i<b_j<b_i$$. We want to find a subset $$S$$ of the intervals such that 1) no two intervals in $$S$$ cross and 2) the total value of intervals in $$S$$ is maximized. Let $$T[k,A,B]$$ be the optimal value of the solution where 1) we only consider the first $$K$$ intervals and 2) all the intervals in the solution have to be contained in the interval $$[A,B]$$. Give an expression (or a piece of code) to compute $$T[k,A,B]$$ from smaller subproblems. Argue why your recurrence is correct.

If A$\leq$ a_k < b_k $\leq$ B
  T[k,A,B] = max { T[k-1,A,B], T[k-1,A,a_k]+T[k-1,a_k,b_k]+T[k-1,b_k,B] + c_k }
Otherwise
  T[k,A,B] = T[k-1,A,B]

If the condition in the if statement does not hold then we cannot take the k-th interval. 
If the condition in the if statement holds then we have 2 options: don't take k-th interval or take k-th interval. If we take k-th interval then the remaining intervals have to either be in subintervals [A,a_k], [a_k,b_k], [b_k,B]. 
Note that the earlier intervals cannot contain the interval [a_k,b_k] (since we sorted the intervals by length).
------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 6
Chocolate (CSC 482 only; no bonus for CSC 282; not graded for CSC 282)

We have an $$m\times n$$ chocolate bar. Each square is colored red, green, or blue (the input is given by a $$m\times n$$ matrix $$B$$ where $$B[i,j]$$ is zero, one, or two, depending on the color of the $$(i,j)$$-th square. We want to break the bar into monochromatic rectangles (that is rectangles where each square has the same color). Each step we can take a rectangle and we can break it along a vertical or a horizontal line. We want to minimize the total number of breaks used. Describe a dynamic programming solution for the problem. Clearly describe 1) the recurrence and 2) how you initialize the dynamic programming array.
 
  Recurrence:
 
      T[x1,y1,x2,y2] = minimum number of cuts for the sub-rectangle in rows y1...y2 and columns x1...x2

      If the rectangle is monochromatic then T[x1,y1,x2,y2]=0

      Else T[x1,y1,x2,y2] = min{ min_{x in {x1,...,x2-1}} T[x1,y1,x,y2] + T[x+1,y1,x2,y2], min_{y in {y1,...,y2-1}} T[x1,y1,x2,y] + T[x1,y+1,x2,y2] }


------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 7
DFS/explore

The $${\rm count}[v]$$ be the number of vertices that will get visited if we call $${\rm explore}(v)$$ with the $${\rm visited}$$ array initialized to false. Consider a graph $$G=(V,E)$$ where $$V=\{1,2,3,4,5\}$$ and $${\rm count}[1]=2$$, $${\rm count}[2]=2$$, $${\rm count}[3]=3$$, $${\rm count}[4]=3$$, $${\rm count}[5]=5$$. Select all edges that are in $$E$$ (only the edges that are given as options below can be present in $$G$$).

[X] $$(1,2)$$
[X] $$(2,1)$$
[ ] $$(1,3)$$
[X] $$(3,1)$$
[ ] $$(2,4)$$
[X] $$(4,2)$$
[ ] $$(3,4)$$
[ ] $$(4,3)$$
[ ] $$(3,5)$$
[X] $$(5,3)$$
[ ] $$(4,5)$$
[X] $$(5,4)$$

------------------------------------------------------------------------------------------------------------------------------------------------------------------
Question 8
Superheroes again

You have a map of the US given by a directed graph (vertices are cities, edges are roads) with distances on the edges. Superheroes Superwoman, Batman, and Spiderwoman are currently in vertices x, y, z, respectively. Assume that their cars have the same speed. The supervillain Cheetah wants to appear in a city and cause mischief for as long as possible. Cheetah can be defeated only when at least two of the superheroes are in the city (naturally each superhero will travel along the shortest path). Which city should Cheetah choose?

  The city that maximizes min( max(dist(x, v), dist(y, v)),  max(dist(x, v), dist(z, v)),  max(dist(y, v), dist(z, v)) )

Design an algorithm whose input is a directed graph with edge-weights and the three vertices x, y, z; and the output is the vertex in which Cheetah should appear. Clearly state the running time of your algorithm (your pay (in points) depends on the speed of your algorithm). Write pseudocode for your algorithm. You can use any algorithm we covered in the class as a procedure (without writing pseudocode for it), but make it clear what arguments you call the algorithm with.

  Compute single source shortest paths from x,y,z (run Dijkstra 3 times). Compute min( max(dist(x, v), dist(y, v)),  max(dist(x, v), dist(z, v)),  max(dist(y, v), dist(z, v)) ) for every v. Loop through all v to find the city that achieves the maximum.
  Run-time = O(m + n log n). 

------------------------------------------------------------------------------------------------------------------------------------------------------------------

Question 9
Mobile delivery (CSC 482 only; no bonus for CSC 282; not graded for CSC 282)

You have a map of the US given by a directed graph (vertices are cities, edges are roads) with distances on the edges. There are $$m$$ packages to be delivered. The destination of the $$i$$-th package is city $$a_i$$. The packages have to be delivered from the warehouse in the city $$1$$.  You have a delivery robot that can carry $$2$$ packages at a time. The objective is to deliver all the packages and to minimize the total distance travelled by the robot. Design an algorithm whose input is a directed graph with edge-weights and $$m$$ vertices $$a_1,\dots,a_m$$. Clearly describe your algorithm (pseudocode is not needed). You can use any algorithm we covered in the class as a procedure (without writing pseudocode for it).

  
 We will use max-weight matching to solve the problem.

  1) Compute all-pairs shortest paths.

  2) Create a complete graph on m vertices where edge-weight w(i,j) of {i,j} are "how much we save by delivering to cities a[i],a[j] in a combined trip"?

     w(i,j) = min (dist(1,a[i])+dist(a[i],a[j])+dist(a[j],1), dist(1,a[j])+dist(a[j],a[i])+dist(a[i],1)) - ( dist(1,a[i]) + dist(a[i],1) + dist(1,a[j]) + dist(a[j],1) )

  3) Find max-weight matching in the graph---the paired cities will be served in one trip.
------------------------------------------------------------------------------------------------------------------------------------------------------------------







