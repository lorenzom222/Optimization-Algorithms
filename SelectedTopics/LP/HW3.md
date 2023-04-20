
## Question 1

Constraints
1. ∃i,j (died(pi) < born(pj))
2. ∃i,j (born(pi) ≤ died(pj) ∧ died(pi) ≥ born(pj)) ∨ (born(pj) ≤ died(pi) ∧ died(pj) ≥ born(pi))

1. The death date of person pi is earlier than the birth date of person pj.
2. The life spans of persons pi and pj overlap at least partially. This can happen in two ways: 
	- The birth date of person pi is earlier than or equal to the death date of person pj and the death date of person pi is later than or equal to the birth date of person pj; 
		* Add Directed Edge from pi to pj
	- or the birth date of person pj is earlier than or equal to the death date of person pi and the death date of person pj is later than or equal to the birth date of person pi.
		* Add Bidirected Edge from pi to pj and pj to pi



```
# Step 1: Build graph
def buildGraph(facts):
    G = defaultdict(list)
    # for each fact in facts
    for fact in facts:
        i, j, relation = fact
        # if fact is of the first form (Pi died before Pj was born)
        if relation == 'before':
            # add a directed edge from Pi to Pj in G
            G[i].append(j)
        # else if fact is of the second form (the life spans of Pi and Pj overlapped)
        elif relation == 'overlap':
            # add edges in both directions between Pi and Pj in G
            G[i].append(j)
            G[j].append(i)
    return G

# Step 2: Run Modified DFS
# check for cycles of length 3 or more using DFS
def dfs(v, visited, path):
    visited[v] = True
    path.append(v)
    for u in G[v]:
        if not visited[u]:
            if dfs(u, visited[:], path[:]):
                return True
        elif len(path) >= 3 and u == path[0]:
            return True
    return False

# Step 3: Check if Consistent
def checkConsistency(facts: List[Tuple[int, int, str]], n: int) -> str:
    G = buildGraph(facts)
    for i in range(n):
        visited = [False] * n
        if dfs(i, visited, []):
            return "The data is not internally consistent"

    return "The data is internally consistent"
```

The second step of the algorithm checks for cycles of length 3 or more using DFS. If such a cycle is found, it means that the data is not internally consistent because it implies that there is a contradiction in the facts. For example, if there is a cycle of length 3 from Pi to Pj to Pk and back to Pi, it means that Pi died before Pj was born, Pj died before Pk was born and Pk died before Pi was born which is not possible.

The buildGraph function takes O(m) time to build the graph from the given facts. The dfs function takes O(n + m) time to run a depth-first search on the graph to check for cycles. Since the dfs function is called once for each of the n vertices in the graph, the total time complexity of the checkConsistency function is O(n + m).


## Question 2

### 2.1

Minimize: P = 45a + 50b
Subject to:
250a + 400b <= 70,000
a + b <= 250 
a, b ≥ 0


Augmented Matrix:
```
| a   | b   | c       |
| --- | --- | ------- |
| 1   | 1   | 250     |
| 250 | 400 | 70,000  |
| --- | --- | ------- |
| 45  | 50  | 0       |

```


Tableau 1:
```
| a   | b    | s1  | s2  | c       |
| --- | ---- | --- | --- | ------- |
| 1   | 1    | 1   | 0   | 250     |
| 250 | 400* | 0   | 1   | 70,000  |
| --- | ---- | --  | --  | ------- |
| -45 | -50  | 0   | 0   | 0       |

```


Tableau 2:
```
| a   | b   | s1  | s2  |  | c |
| --- | --- | --- | --- || ---- |
| 3/8*  | 0 | 1  | -1/400|| 75   |
| 5/8 | 1   | 0   | 1/400 |  | 175 |
| --- | --- | --- | ----- || ---- |
| -55/4 | 0 | 0  | 5/40  || 8750 |
```

Tableau 3 (Final):
```
| a   | b   | s1  | s2  |  | c |
| --- | --- | --- | --- || ------- |
| 1 | 0 | 8/3 | -1/150  || 200 |
| 0   | 1   | -5/3 | 1/150 |  | 50 |
| --- | --- | ---- | ----- || - |
| 0 | 0 | 110/3 | 13/60 || 11500 |
```

x = 200, y = 50, Profit = 11500



### 2.2

Minimize: Cost = 25x + 20y
Subject to:
2x + y ≥ 12
2x + 9y ≥ 36
2x + 3y ≥ 24
x, y ≥ 0

1.  Form Augented Matrix for Inequalities
```
| x y   | b   |
| ----- | --- |
| 2 1   | 12  |
| 2 9   | 36  |
| 2 3   | 24  |
| ----  | --- |
| 25 20 | 0   |
```

2. *Transpose it*

```
| u v w    | b   |
| -------- | --- |
| 2 2 2    | 25  |
| 1 9 3    | 20  |
| ------   | --- |
| 12 36 24 | 0   |
```
3. Dual Maximization Problem (*New Objective Function and Constraints*):

Maximize: Z = 12u + 36v + 24w

Subject to (*now non-negative*):
2u + 2v + 2w \leq -25
1u + 9v + 3w \leq 20
u, v , w \geq 0

4. Perform Simplex Method

Tableau 1:
```
| u   | v   | w   | s1  | s2  |  | b |
| --- | --- | --- | --- | --- || ---- |
| 2    | 2    | 2    | 1    | 0    || 25   |
| 1   | 9*  | 3   | 0   | 1   |  | 20 |
| --- | --- | --- | --- | --- || ---- |
| -12  | -36  | -24  | 0    | 0    || 0    |
```

Tableau 2:
```
| u   | v   | w   | s1  | s2  |  | b |
| --- | --- | --- | --- | --- || -------- |
| 16/9   | 0 | 4/3    | 1  | 0      || 185/9    |
| 1/9 | 1   | 1/3* | 0   | 1/9 |  | 20/9 |
| --- | --- | ---- | --- | --- || -------- |
| -8     | 0 | -12    | 0  | 4      || 80       |

```

Tableau 3:
```
| u   | v   | w   | s1  | s2  |  | b |
| --- | --- | --- | --- | --- || ------- |
| 4/3*   | -4 | 0 | 1  | -2/3    || 35/3    |
| 1/3 | 3   | 1   | 0   | 1/3 |  | 20/3 |
| --- | --- | --- | --- | --- || ------- |
| -4     | 36 | 0 | 0  | 8       || 160     |

```


Tableau 4 (Final):
```
| u   | v   | w   | s1  | s2  |  | b |
| --- | --- | --- | --- | --- || ------- |
| 1 | -3 | 0 | 3/4  | -1/2  || 35/3    |
| 0   | 2   | 1   | -1/4 | 1/6 |  | 15/4 |
| --- | --- | --- | ---- | --- || ------- |
| 0 | 24 | 0 | 3    | 6     || 195     |
```

x = 3, y = 6, Profit = 195


### 2.3

Augmented Matrix
```
| x   | y   | z   | s1  | s2  | s3  |  | b |
| --- | --- | --- | --- | --- | --- || ---   |
| 2   | 2.5  | 3    | 1    | 0    | 0    || 4006  |
| 1.5 | 2    | 1    | 0    | 1    | 0    || 2495  |
| 1   | 0.75 | 1.25 | 0   | 0   | 1   |  | 1500 |
| --- | ---- | ---- | --- | --- | --- || ---   |
| 45  | 50   | 55   | 0    | 0    | 0    || 0     |


```

Tableau 1:
```
| x   | y   | z   | s1  | s2  | s3  |  | b |
| --- | --- | --- | --- | --- | --- || ----- |
| 2   | 2.5 |  3  |  1  |  0  |  0  ||  4006 |
| 1.5 |  2  |  1  |  0  |  1  |  0  ||  2495 |
| 1   | 0.75 | 1.25* | 0   | 0   | 1   |  | 1500 |
| --- | ---- | ----- | --- | --- | --- || ----- |
| -45 | -50 | -55 |  0  |  0  |  0  ||   0   |

```

Tableau 2:
```
| x   | y   | z   | s1  | s2  | s3  |  | b |
| --- | --- | --- | --- | --- | --- || ------ |
| -2/5  | 7/10* | 0 |  1 |  0 | -12/5  ||   406  |
|  7/10 |  7/5  | 0 |  0 |  1 |  -4/5  ||  1295  |
| 4/5 | 3/5 | 1   | 0   | 0   | 4/5 |  | 1200 |
| --- | --- | --- | --- | --- | --- || ------ |
|  -1   | -17   | 0 |  0 |  0 |   44   || 66000  |

```

Tableau 3:
```
| x   | y   | z   | s1  | s2  | s3  |  | b |
| --- | --- | --- | --- | --- | --- || ------- |
| -4/7   | 1 | 0 |  10/7  |  0 | -24/7  ||   580   |
|  3/2*  | 0 | 0 |   -2   |  1 |  4     ||   483   |
| 8/7 | 0   | 1   | -30/35 | 0   | 20/7 |  | 1500 |
| --- | --- | --- | ------ | --- | ---- || ------- |
| -75/7  | 0 | 0 | 170/7  |  0 | -100/7 ||  75860  |

```


Tableau 4:
```
| x   | y   | z   | s1  | s2  | s3  |  | b |
| --- | --- | --- | --- | --- | --- || ---- |
| 0   | 1   |  0  |  2/3   |  8/21   |  -40/21  ||  764 |
| 1   | 0   |  0  |  -4/3  |  2/3    |  8/3     ||  322 |
| 0   | 0   | 1   | -50/21 | -16/21 | -4/21 |  | 484 |
| --- | --- | --- | ------ | ------ | ----- || ---- |
| 0   |  0  |  0  | 170/7  |    0    |  -100/7  || 75860 |

```

x = 322, y = 764, z=484, Profit = 75860


### 2.4

With advising, optimal variables are: x=9, y = 4 with a Max of 147 million

But without, we can make max of 150 million just using x with x=10

## Question 3

### 3.1 Balanced Line

1. Find the Convex Hull of the points
2. Check if both classes (types of soldiers) exist on the hull
    1. If yes, draw line between those as n-1 Roman soldiers will equal n-1 Carthaginian soldiers
    2. else,
        1. Choose any vertex of the convex hull *p*, set that as origin and a line passing through it as x-axis
        2. init counter for number of Roman soldiers and number of Carthaginian soldiers (if *p* was Roman then +1 for them, else +1 for Carthaginian)
        3. Sweep across system clockwise about origin p
        4. When crossing Roman, increment counter for them
        5. When crossing Carthaginian, increment counter for them
        6. Check the differnce of the counter
            1. If counter for Roman - counter for Roman Carthaginian = 0, then draw line and return exist!
            2. else keep sweeping

When we start sweeping, we initialize how angle at $\theta_0 = 0$. Let $\theta_l=min{𝜃\theta ∈[0,\pi]: difference between counters = 0}$.  Since the intial difference is 1 > 0, and can change only in steps of +1, the x-axis at angle  $\theta_l$ must pass through p and an enemy point. Therefore, there exist a line passing through one Roman and one Carthaginian such that the number of Romans on one side of the line equals the number of Carthaginians on the same side.

### 3.2 Divide and Conquer

As we did before to find if there existed a "balanced line", line passing through one Roman and one Carthaginian such that the number of Romans on one side of the line equals the number of Carthaginians on the same side, we can apply that in a divide and conquer way. When we find that a pair of Roman and Carthaginian point R and C, we can match them, and then you recursively find the matchings for all the points on each side of the vector separately.

```
def noCrossing(points):
    if len(points) > 3:
        # init convex_hull_points = Convex Hull points
        convex_hull_points = ConvexHull(points)
    else:
        # if they are different classes (different soldiers)
        if points[0].class != points[1].class:
            # then match them (draw line)
            match(points[0], points[1])
        else:
            return -1

    # If convex_hull_points contains both classes
    if contains_both_classes(convex_hull_points):
        # find adjacent points that are different then match them
        R, C = find_adjacent_different(convex_hull_points)
        match(R, C)
        # recursively find matchings for all the points on each side of the vector RB separately
        noCrossing(points_left_of_RC)
        noCrossing(points_right_of_RC)

    # else if all classes are the same in convex_hull_points
    else:
        # p = any point in of convex_hull_points
        p = convex_hull_points[0]
        # set that as origin and a
        origin = p
        # set x-axis as line passing through it p
        x_axis = line_through(p)
        counter = [0, 0]
        # if p was Roman, then counter[0]++
        if p.class == "Roman":
            counter[0] += 1
        # else, counter[1]++
        else:
            counter[1] += 1

        # Sweep across system clockwise about origin p
        for point in sweep_clockwise(origin):
            # When crossing Roman, increment counter for them
            if point.class == "Roman":
                counter[0] += 1
            # When crossing Carthaginian, increment counter for them
            else:
                counter[1] += 1

            # Check the difference of the counter
            # If counter for Roman - counter for Roman Carthaginian = 0,
            if counter[0] - counter[1] == 0:
                # then draw match and recursively find matchings for all the points on each side of the vector RB separately.
                match(Roman_point, Carthaginian_point)
                noCrossing(points_left_of_RB)
                noCrossing(points_right_of_RB)
            # else keep sweeping
            else:
                continue

```




Sources:
https://math.stackexchange.com/questions/4041431/given-2n-points-in-the-plane-n-blue-points-and-n-red-points-no-3-are-c

https://artofproblemsolving.com/wiki/index.php/2005_USAMO_Problems/Problem_5

https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwibi4jz-Lb-AhVNF1kFHVm_AFMQFnoECCMQAQ&url=https%3A%2F%2Fwww.combinatorics.org%2Fojs%2Findex.php%2Feljc%2Farticle%2Fdownload%2Fv19i1p33%2Fpdf%2F&usg=AOvVaw3Wr23YSNuWc2XRq0EPwCmV



## Question 4
Objective function: z = x1 − x2 + x3 
Constraints:
	2x1 + x2 − 3x3 ≤ 40 
	x1       +	x3 ≤ 25 
		 2x2 + 3x3 ≤ 32 
	x1,x2,x3 ≥ 0

**Approach 1:**

x= 23, y =0 , z =2 


**Approach 2:**

x= 43/3, y =0 , z =32/2


**Max Profit** = 25

https://college.cengage.com/mathematics/larson/elementary_linear/4e/shared/downloads/c09s4.pdf
