# Computational geometry
- Algorithms for solving geometric problems.
- Applications: Graphics, robotics, modeling, etc

We will be looking at some algorithms for solving problems in 2D plane.

## Properties

* Input: 
	- Set of points ${p_1, p2,...}$, 
	- Each point is $p_i = (x_i, y_i)$
	- Ex: Polygon $P$ with n-vertices is represented by a sequence of vertices in the order they appear on the boundary (line or curve that forms shape). $[p_0, p_1, p_2, ... , p_{n-1}]$. 


### Line-segment properties

* Convex combination: 
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
	- $0\leq \alpha \geq1$

- p3 is any point that lies on the line between p1 and p2, and is not outside of the line segment defined by p1 and p2. 

* Line segment: 
	* Given two points, the **line segment** between them is the set of convex combinations of p1 and p2.
	- **Endpoint** are p1 and p2.
	- **Directed segment** is when we care about the direction from p1 and p2. p1 can be the start and p2 the end.
	- If p1 is at **origin**, then we can treat as vector

**Questions**

1. If we have 2 *directed segments* (p0 to p1 \& p0 to p2), is p0 to p1 clockwise from p0 to p2 wrt to their common endpoint p0?

2. If we have 2 *line segments* ((p0, p1) \& (p0, p2)), does going down (p0, p1) and then (p1, p2) make us do a left turn at p1?

3. Do (p1, p2) \& (p3, p4) intersect?


* Cross Product
	- Cross product of 2 vectors produce a new vector that's perpendicular to both
	- Maginitude of that vector is equal to the signed area of the parallelogram that spans from the 2 vectors

Representing the cross-product as a determinant,

$p_1 &times; p_2 = det(x_1 x_2, y_1 y_2)= x_1 y_2 - x_2 y_1  = -p_2 &times; p_1$

it reveals that:

- if $p_1 &times; p_2$ is positive, then $p_1$ is **clockwise** from $p_2$ w.r.t to the *origin*. 
- if negative, then then $p_1$ is **counter-clockwise** from $p_2$ w.r.t to the *origin*. 









