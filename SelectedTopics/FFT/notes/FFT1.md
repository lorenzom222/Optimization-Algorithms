# Fast Fourier Transform

Reference: https://www.youtube.com/watch?v=h7apO7q16V0&t=465s

## Polynomial Representation

### Coefficent Representation
If we wish to find the product of two polynomials, we can simply use the distubtive law for A(x) • B(x) = C(x). For a computer, we can represent them by just their coefficents such as:
```
def multPolynomial(A, B):

	A(x) = 2 + 3x + x^2 -> [2, 3, 1]
	B(x) = 1 + 0x + 2x^2 -> [1, 0, 2]

	C(x) = 2 + 3x + 5x^2 + 6x^3 + 2x^4 -> [2, 3, 5, 6, 2]

	return C


or more generally

def multPolynomial(A, B):

	A(x) = a0 + a1x + a2x^2 + ... + adx^d
	B(x) = b0 + b1x + b2x^2 + ... + bdx^d

	C(x) = c0 + c1x + c2x^2 + ... + c2dx^2d

	return C
```

The runtime of using the distributive property, multiplication is: O(d^2)

### Value Representation

Any polynomial of degree d, can be uniquely represented by (d + 1) points. For example:
- {(0,-1), (1,0)} : P(x) = x - 1 -> d = 1
- {(-3,1), (-1,1), (1, 3)} : P(x) = (3/4)x^2 + 2x + 1/4 -> d = 2
- {(-1,0), (0,1), (1, 0), (2,1)} : P(x) = (2/3)x^3 - x^2 - 2/3x + 1 -> d = 3

Proof:

Suppose we are given (d+1) unique points of a d degree polynomial, P(x):

- Points: {(x0, P(x0)), (x1, P(x1)), ... , (xd, P(xd))}
- Polynomial: P(x) = p0 + p1x + p2x^2 + ... + pdx^d

Goal: We want to show that for these set of points there is only ONE SET of coefficents. 

By evaluating our polynomial at each of these unique points that were given, we get a set of linear equations:
```
P(x0) = p0 + p1x0 + p2x0^2 + ... + pdx0^d
P(x1) = p0 + p1x1 + p2x1^2 + ... + pdx1^d
				:
P(xn) = p0 + p1xd + p2xd^2 + ... + pdxd^d
```
This can be represented as a matrix like so:
```
[1, x0, x0^2, ..., x0^d]   [p0]   [P(x0)]
[1, x1, x1^2, ..., x1^d] * [p1] = [P(x1)]
...                        ...     ...
[1, xd, xd^2, ..., xd^d]   [pd]   [P(xd)]

```
Property:
- If each point is truly unique, then the matrix will always be invertible
	- M is invertible for unique x_0 , x_1, ..., x_d
	- You can show this my checking if the determinant of M is non-zero: https://math.stackexchange.com/questions/426932/why-are-vandermonde-matrices-invertible
This means that:
1. For every set of points there exist a unique set of coefficents pk
2. Similarly, also exist a unique polymomial P(x)

Using value representation, multiplication is: O(d)!!!

### Overall

Two ways to represent polynomials:

$P(x) = p_0 + p_1x + p_2x^2 + ... + p_dx^d$

1. Coefficent Representation: $[p_0, p_1, p_2, ..., p_dx]$
2. Value Representation: ${(x_0, P(x_0)), (x_1, P(x_1)), ... , (x_d, P(x_d))}$

**Takeaway**: Value representation has many advantages over Coefficent, mainly the ease to multply polynomials together in O(n) time.



### Frame

1. We want to convert our polynomials $A$ and $B$ from Coefficent to Value.
2. Multiply them together to get $C$
3. Then convert C from Value to Coefficent representation


![Flowchart](/figs/flowchart.png)


But the issue is:
1. We dont have a way of converting Coefficent into Value
2. Nor the opposite

##





