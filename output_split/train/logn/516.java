
// Java program for Binary Search 
import
java.util.*; 

class
Binary 
{ 

public
static
int
f(
int
x) 

{ 
return
(x*x - 
10
*x - 
20
); } 


// Returns the value x where above 

// function f() becomes positive 

// first time. 

public
static
int
findFirstPositive() 

{ 

// When first value itself is positive 

if
(f(
0
) > 
0
) 

return
0
; 


// Find 'high' for binary search 

// by repeated doubling 

int
i = 
1
; 

while
(f(i) <= 
0
) 

i = i * 
2
; 


// Call binary search 

return
binarySearch(i / 
2
, i); 

} 


// Searches first positive value of 

// f(i) where low <= i <= high 

public
static
int
binarySearch(
int
low, 
int
high) 

{ 

if
(high >= low) 

{ 

/* mid = (low + high)/2 */

int
mid = low + (high - low)/
2
; 


// If f(mid) is greater than 0 and 

// one of the following two 

// conditions is true: 

// a) mid is equal to low 

// b) f(mid-1) is negative 

if
(f(mid) > 
0
&& (mid == low || f(mid-
1
) <= 
0
)) 

return
mid; 


// If f(mid) is smaller than or equal to 0 

if
(f(mid) <= 
0
) 

return
binarySearch((mid + 
1
), high); 

else
// f(mid) > 0 

return
binarySearch(low, (mid -
1
)); 

} 


/* Return -1 if there is no positive 

value in given range */

return
-
1
; 

} 


// driver code 

public
static
void
main(String[] args) 

{ 

System.out.print (
"The value n where f() "
+ 

"becomes positive first is "
+ 

findFirstPositive()); 

} 
} 

// This code is contributed by rishabh_jain 