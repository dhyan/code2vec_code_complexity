
// Java implementation of worst 
// case linear time algorithm 
// to find k'th smallest element 
import
java.util.*; 

class
GFG 
{ 

// int partition(int arr[], int l, int r, int k); 

// A simple function to find median of arr[]. This is called 
// only for an array of size 5 in this program. 
static
int
findMedian(
int
arr[], 
int
i,
int
n) 
{ 

if
(i <= n) 

Arrays.sort(arr, i, n); 
// Sort the array 

else

Arrays.sort(arr, n, i); 

return
arr[n/
2
]; 
// Return middle element 
} 

// Returns k'th smallest element 
// in arr[l..r] in worst case 
// linear time. ASSUMPTION: ALL 
// ELEMENTS IN ARR[] ARE DISTINCT 
static
int
kthSmallest(
int
arr[], 
int
l, 
int
r, 
int
k) 
{ 

// If k is smaller than 

// number of elements in array 

if
(k > 
0
&& k <= r - l + 
1
) 

{ 

int
n = r - l + 
1
; 
// Number of elements in arr[l..r] 


// Divide arr[] in groups of size 5, 

// calculate median of every group 

// and store it in median[] array. 

int
i; 


// There will be floor((n+4)/5) groups; 

int
[]median = 
new
int
[(n + 
4
) / 
5
]; 

for
(i = 
0
; i < n/
5
; i++) 

median[i] = findMedian(arr,l + i * 
5
, 
5
); 


// For last group with less than 5 elements 

if
(i*
5
< n) 

{ 

median[i] = findMedian(arr,l + i * 
5
, n % 
5
); 

i++; 

} 


// Find median of all medians using recursive call. 

// If median[] has only one element, then no need 

// of recursive call 

int
medOfMed = (i == 
1
)? median[i - 
1
]: 

kthSmallest(median, 
0
, i - 
1
, i / 
2
); 


// Partition the array around a random element and 

// get position of pivot element in sorted array 

int
pos = partition(arr, l, r, medOfMed); 


// If position is same as k 

if
(pos-l == k - 
1
) 

return
arr[pos]; 

if
(pos-l > k - 
1
) 
// If position is more, recur for left 

return
kthSmallest(arr, l, pos - 
1
, k); 


// Else recur for right subarray 

return
kthSmallest(arr, pos + 
1
, r, k - pos + l - 
1
); 

} 


// If k is more than number of elements in array 

return
Integer.MAX_VALUE; 
} 

static
int
[] swap(
int
[]arr, 
int
i, 
int
j) 
{ 

int
temp = arr[i]; 

arr[i] = arr[j]; 

arr[j] = temp; 

return
arr; 
} 

// It searches for x in arr[l..r], and 
// partitions the array around x. 
static
int
partition(
int
arr[], 
int
l, 

int
r, 
int
x) 
{ 

// Search for x in arr[l..r] and move it to end 

int
i; 

for
(i = l; i < r; i++) 

if
(arr[i] == x) 

break
; 

swap(arr, i, r); 


// Standard partition algorithm 

i = l; 

for
(
int
j = l; j <= r - 
1
; j++) 

{ 

if
(arr[j] <= x) 

{ 

swap(arr, i, j); 

i++; 

} 

} 

swap(arr, i, r); 

return
i; 
} 

// Driver code 
public
static
void
main(String[] args) 
{ 

int
arr[] = {
12
, 
3
, 
5
, 
7
, 
4
, 
19
, 
26
}; 

int
n = arr.length, k = 
3
; 

System.out.println(
"K'th smallest element is "

+ kthSmallest(arr, 
0
, n - 
1
, k)); 
} 
} 

// This code has been contributed by 29AjayKumar 