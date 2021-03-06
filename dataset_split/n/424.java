
// Java program to check whether a given 
// Binary Tree is Perfect or not 
class
GfG { 

/* Tree node structure */
static
class
Node 
{ 

int
key; 

Node left, right; 
} 

// Returns depth of leftmost leaf. 
static
int
findADepth(Node node) 
{ 
int
d = 
0
; 
while
(node != 
null
) 
{ 

d++; 

node = node.left; 
} 
return
d; 
} 

/* This function tests if a binary tree is perfect 
or not. It basically checks for two things : 
1) All leaves are at same level 
2) All internal nodes have two children */
static
boolean
isPerfectRec(Node root, 
int
d, 
int
level) 
{ 

// An empty tree is perfect 

if
(root == 
null
) 

return
true
; 


// If leaf node, then its depth must be same as 

// depth of all other leaves. 

if
(root.left == 
null
&& root.right == 
null
) 

return
(d == level+
1
); 


// If internal node and one child is empty 

if
(root.left == 
null
|| root.right == 
null
) 

return
false
; 


// Left and right subtrees must be perfect. 

return
isPerfectRec(root.left, d, level+
1
) && isPerfectRec(root.right, d, level+
1
); 
} 

// Wrapper over isPerfectRec() 
static
boolean
isPerfect(Node root) 
{ 
int
d = findADepth(root); 
return
isPerfectRec(root, d, 
0
); 
} 

/* Helper function that allocates a new node with the 
given key and NULL left and right pointer. */
static
Node newNode(
int
k) 
{ 

Node node = 
new
Node(); 

node.key = k; 

node.right = 
null
; 

node.left = 
null
; 

return
node; 
} 

// Driver Program 
public
static
void
main(String args[]) 
{ 

Node root = 
null
; 

root = newNode(
10
); 

root.left = newNode(
20
); 

root.right = newNode(
30
); 


root.left.left = newNode(
40
); 

root.left.right = newNode(
50
); 

root.right.left = newNode(
60
); 

root.right.right = newNode(
70
); 


if
(isPerfect(root) == 
true
) 

System.out.println(
"Yes"
); 

else

System.out.println(
"No"
); 
} 
} 