
// Java program to delete a node from 
// Doubly Linked List 

// Class for Doubly Linked List 
public
class
DLL { 

Node head; 
// head of list 


/* Doubly Linked list Node*/

class
Node { 

int
data; 

Node prev; 

Node next; 


// Constructor to create a new node 

// next and prev is by default initialized 

// as null 

Node(
int
d) { data = d; } 

} 


// Adding a node at the front of the list 

public
void
push(
int
new_data) 

{ 

// 1. allocate node 

// 2. put in the data 

Node new_Node = 
new
Node(new_data); 


// 3. Make next of new node as head 

// and previous as NULL 

new_Node.next = head; 

new_Node.prev = 
null
; 


// 4. change prev of head node to new node 

if
(head != 
null
) 

head.prev = new_Node; 


// 5. move the head to point to the new node 

head = new_Node; 

} 


// This function prints contents of linked list 

// starting from the given node 

public
void
printlist(Node node) 

{ 

Node last = 
null
; 


while
(node != 
null
) { 

System.out.print(node.data + 
" "
); 

last = node; 

node = node.next; 

} 


System.out.println(); 

} 


// Function to delete a node in a Doubly Linked List. 

// head_ref --> pointer to head node pointer. 

// del --> data of node to be deleted. 

void
deleteNode(Node head_ref, Node del) 

{ 


// Base case 

if
(head == 
null
|| del == 
null
) { 

return
; 

} 


// If node to be deleted is head node 

if
(head == del) { 

head = del.next; 

} 


// Change next only if node to be deleted 

// is NOT the last node 

if
(del.next != 
null
) { 

del.next.prev = del.prev; 

} 


// Change prev only if node to be deleted 

// is NOT the first node 

if
(del.prev != 
null
) { 

del.prev.next = del.next; 

} 


// Finally, free the memory occupied by del 

return
; 

} 


// Driver Code 

public
static
void
main(String[] args) 

{ 

// Start with the empty list 

DLL dll = 
new
DLL(); 


// Insert 2. So linked list becomes 2->NULL 

dll.push(
2
); 


// Insert 4. So linked list becomes 4->2->NULL 

dll.push(
4
); 


// Insert 8. So linked list becomes 8->4->2->NULL 

dll.push(
8
); 


// Insert 10. So linked list becomes 10->8->4->2->NULL 

dll.push(
10
); 


System.out.print(
"Created DLL is: "
); 

dll.printlist(dll.head); 


// Deleting first node 

dll.deleteNode(dll.head, dll.head); 


// List after deleting first node 

// 8->4->2 

System.out.print(
"\nList after deleting first node: "
); 

dll.printlist(dll.head); 


// Deleting middle node from 8->4->2 

dll.deleteNode(dll.head, dll.head.next); 


System.out.print(
"\nList after Deleting middle node: "
); 

dll.printlist(dll.head); 

} 
} 