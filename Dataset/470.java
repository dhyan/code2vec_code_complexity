
// Java program to find maximum product of 
// a subset. 

class
GFG { 


static
int
maxProductSubset(
int
a[], 
int
n) { 

if
(n == 
1
) { 

return
a[
0
]; 

} 


// Find count of negative numbers, count 

// of zeros, maximum valued negative number 

// and product of non-zero numbers 

int
max_neg = Integer.MIN_VALUE; 

int
count_neg = 
0
, count_zero = 
0
; 

int
prod = 
1
; 

for
(
int
i = 
0
; i < n; i++) { 


// If number is 0, we don't 

// multiply it with product. 

if
(a[i] == 
0
) { 

count_zero++; 

continue
; 

} 


// Count negatives and keep 

// track of maximum valued negative. 

if
(a[i] < 
0
) { 

count_neg++; 

max_neg = Math.max(max_neg, a[i]); 

} 


prod = prod * a[i]; 

} 


// If there are all zeros 

if
(count_zero == n) { 

return
0
; 

} 


// If there are odd number of 

// negative numbers 

if
(count_neg % 
2
== 
1
) { 


// Exceptional case: There is only 

// negative and all other are zeros 

if
(count_neg == 
1

&& count_zero > 
0

&& count_zero + count_neg == n) { 

return
0
; 

} 


// Otherwise result is product of 

// all non-zeros divided by maximum 

// valued negative. 

prod = prod / max_neg; 

} 


return
prod; 

} 

// Driver code 

public
static
void
main(String[] args) { 

int
a[] = {-
1
, -
1
, -
2
, 
4
, 
3
}; 

int
n = a.length; 

System.out.println(maxProductSubset(a, n)); 


} 
} 
/* This JAVA code is contributed by Rajput-Ji*/