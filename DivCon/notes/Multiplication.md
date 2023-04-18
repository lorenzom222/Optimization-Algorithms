# Divide and Conquer: Numbers

## Multiplication

Given 2 $n$-bit integers, $x$ and $y$. How do we compute the product of these 2?

### Naive
- By straight computing the product of these bits, the runtime of this yields $O(n^2)$
- In an effort to reduce this, we attempt Divide and Conquer


### Divide and Conquer
1. *Split the integers into their left and right halves*:
- $x = [X_l][X_r] = 2^{n/2}x_l + x_r$ 
- $y = [Y_l][Y_r] = 2^{n/2}y_l + y_r$ 
- I'm not sure why we split or how this bit addition works, but alas

2. *Compute product*:
- $xy = (2^{n/2}x_l + x_r)(2^{n/2}y_l + y_r) = 2^{n}x_l y_l + 2^{n/2}(x_l y_r + x_r y_l) + x_r y_r$

3. *Analyze runtime*:
- Addition take linear time
- Product of bit times power of 2 is just left bit-shift, can look more into how bit multiplication works
- Here there is 4 multiplication of the n/2-bumbers:$x_l y_r, x_r y_l, x_r y_r , x_l y_l$. Because these are more bit product, they perform this again resulting in recursive calls. 
- Linear runtime for product by 2^k and addition: $O(n)$
- Bit product runtime = $T(n)$, for n-bit inputs
- Overall Runtime: $T(n) = 4T(n/2)+ O(n)$, *recurrence relation*

#### Gauss Trick

- $x_l y_r, x_r y_l$ = 

