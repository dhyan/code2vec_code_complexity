
// Java program for counting n digit numbers with 
// non decreasing digits 
import
java.io.*; 

class
GFG { 


// Function that returns count of non- decreasing numbers 

// with n digits 

static
int
nonDecNums(
int
n) 

{ 

// a[i][j] = count of all possible number 

// with i digits having leading digit as j 

int
[][] a = 
new
int
[n + 
1
][
10
]; 


// Initialization of all 0-digit number 

for
(
int
i = 
0
; i <= 
9
; i++) 

a[
0
][i] = 
1
; 


// Initialization of all i-digit 

// non-decreasing number leading with 9 

for
(
int
i = 
1
; i <= n; i++) 

a[i][
9
] = 
1
; 


// for all digits we should calculate 

// number of ways depending upon leading 

// digits 

for
(
int
i = 
1
; i <= n; i++) 

for
(
int
j = 
8
; j >= 
0
; j--) 

a[i][j] = a[i - 
1
][j] + a[i][j + 
1
]; 


return
a[n][
0
]; 

} 


// driver program 

public
static
void
main(String[] args) 

{ 

int
n = 
2
; 

System.out.println(
"Non-decreasing digits = "
+ nonDecNums(n)); 

} 
} 

// Contributed by Pramod Kumar 