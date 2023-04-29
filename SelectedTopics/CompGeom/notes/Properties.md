# Computational geometry
https://math.stackexchange.com/questions/1607358/match-off-points-into-n-red-blue-pairs-with-straight-lines-connecting-pairs-s
https://community.wvu.edu/~krsubramani/courses/sp06/cg/qen/hw3sol.pdf
https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwibi4jz-Lb-AhVNF1kFHVm_AFMQFnoECCMQAQ&url=https%3A%2F%2Fwww.combinatorics.org%2Fojs%2Findex.php%2Feljc%2Farticle%2Fdownload%2Fv19i1p33%2Fpdf%2F&usg=AOvVaw3Wr23YSNuWc2XRq0EPwCmV

- Algorithms for solving geometric problems.
- Applications: Graphics, robotics, modeling, etc

We will be looking at some algorithms for solving problems in 2D plane.

## Properties

* Input: 
	- Set of points ${p_1, p2,...}$, 
	- Each point is $p_i = (x_i, y_i)$
	- Ex: Polygon $P$ with n-vertices is represented by a sequence of vertices in the order they appear on the boundary (line or curve that forms shape). $[p_0, p_1, p_2, ... , p_{n-1}]$. 


### Line-segment properties

#### Convex combination
* Weighted average of two points. 

- Weights are non-negative and sum to 1. 
- Resulting point p3 lies on the line segment connecting p1 and p2. 
- Closer the weight is to 1, the closer p3 is to p1. 
- Conversely, the closer the weight is to 0, the closer p3 is to p2. 
- EX: $p_1 = (1,0)$ with $w_1 = 0.3$, $p_2 = (2,1)$ with $w_2 = 0.7$. Resulting point: $p_3 = (0.3 * 1 + 0.7 * 2, 0.3 * 0 + 0.7 * 1) = (1.7, 0.7)$.


* $p_3 = (x_3, y_3)$
- $x_3 = \alpha(x_1) + (1-\alpha)(x_2)$
- $y_3 = \alpha(y_1) + (1-\alpha)(y_2)$

* $p_3 = \alpha(p_1) + (1-\alpha)(p_2)$
- $0\leq \alpha \leq1$

- p3 is any point that lies on the line between p1 and p2, and is not outside of the line segment defined by p1 and p2. 

#### Line segment
* Given two points, the **line segment** between them is the set of convex combinations of p1 and p2.
- **Endpoint** are p1 and p2.
- **Directed segment** is when we care about the direction from p1 and p2. p1 can be the start and p2 the end.
- If p1 is at **origin**, then we can treat as vector

#### Questions

1. If we have 2 *directed segments* (p0 to p1 \& p0 to p2), is p0 to p1 clockwise from p0 to p2 wrt to their common endpoint p0?

2. If we have 2 *line segments* ((p0, p1) \& (p0, p2)), does going down (p0, p1) and then (p1, p2) make us do a left turn at p1?

3. Do (p1, p2) \& (p3, p4) intersect?

#### Cross Product

This is used to determine the orientation of a pair of vectors p1 and p2.

*NOTE: This is basically the “z” coordinate of the usual cross product if we add the third dimension to our space, and is called cross product for short.*

Typically:
- Cross product of 2 vectors produce a new vector that's perpendicular to both if we had another dimension
- Maginitude of that vector is equal to the signed area of the parallelogram that spans from the 2 vectors

However we are in 2D. So, representing the cross-product as a determinant,

$p_1 &times; p_2 = det(x_1 x_2, y_1 y_2)= x_1 y_2 - x_2 y_1  = -p_2 &times; p_1$

it reveals that:

- if $p_1 &times; p_2$ is positive, then $p_1$ is **clockwise** from $p_2$ w.r.t to the *origin*. 
- if negative, then then $p_1$ is **counter-clockwise** from $p_2$ w.r.t to the *origin*. 

*Conclusion:*

$det(A) = x_1 * y_2 - x_2 * y_1$

1. If the determinant is positive, then this means that x1 * y2 is greater than x2 * y1, which implies that the vector p1 lies in the **clockwise** direction with respect to the vector p2. 
2. If the determinant is negative, then the opposite is true, and p1 lies in the **counterclockwise** direction with respect to p2. 
3. If the determinant is **zero**, then the vectors are *colinear*, and lie either in the same or opposite direction.


#### Determining Clockwise Direction

Next we wish to determine whether the direction of a line segment is in the **clockwise** or **counter-clockwise** direction. In other words, given $p_0$ to $p_1$ and $p_0$ to $p_2$, which direction is $p_2$ in from $p_1$ wrt $p_0$. 

To do this we:
1. Translate the origin to $p_0$, by shift all points by $-p_0$

$p_1' = (x_1', y_1')$ where $x_1' = x_1 - x_0$. Similar for $p_2$.


2. Cross-product: $p_1 &times; p_2 = (x_1-x_0) (y_2-y_0) - (x_2-x_0) (y_1-y_0)$

3. Check sign: Postive? $p_0$ to $p_2$ **clockwise** from $p_0$ to $p_1$. Negative? $p_0$ to $p_2$ **counter-clockwise** from $p_0$ to $p_1$.

#### Determining Left or Right Turn

From determining the direction of the line segements about the origin (**clockwise** or **counterclockwise**), we can use this to see where we turn from the directed segment when reach $p_1$.

1. if $p_0$ to $p_2$ is **clockwise** relative to $p_0$ to $p_1$, then when we reach $p_1$ we would left to $p_2$


2. if $p_0$ to $p_2$ is **counter-clockwise** relative to $p_0$ to $p_1$, then when we reach $p_1$ we would right to $p_2$

3. else, all vectors are colinear

#### Determining whether 2 line segments intersect










