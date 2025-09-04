# Tree

A tree is a non-linear, hierarchical data structure consisting of a root node and potentially many levels of additional nodes that form a parent-child relationship. 🌳

-----

## 1\. About the Data Structure

A **tree** is a collection of entities called **nodes** linked together to simulate a hierarchy. It's a non-linear structure because, unlike arrays or linked lists, data is not stored sequentially. The top-most node is called the **root**. Each node can have zero or more child nodes. A node with no children is called a **leaf**. Trees are fundamental for representing data with a natural hierarchical relationship, like file systems or family trees. A common type is the **Binary Tree**, where each node has at most two children.

-----

## 2\. Syntax (Java)

In Java, a tree is typically represented by creating a `Node` class that holds the data and references (pointers) to its children. Here is the syntax for a basic **Binary Tree Node**.

```java
class TreeNode {
    int data;         // The data value of the node
    TreeNode left;    // Reference to the left child
    TreeNode right;   // Reference to the right child

    // Constructor to create a new node
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
```

-----

## 3\. Operations with Syntax

Operations are usually performed starting from the root of the tree. The most common operations are traversals, searching, insertion, and deletion, especially in a **Binary Search Tree (BST)**, a special type of binary tree where the left child's value is less than the parent's, and the right child's value is greater.

| Operation | Description | Java Method Signature |
| :--- | :--- | :--- |
| **Search** | Finds a node with a specific value. | `public boolean search(TreeNode root, int value)` |
| **Insert** | Adds a new node to the tree while maintaining its properties (e.g., BST property). | `public TreeNode insert(TreeNode root, int value)` |
| **Delete** | Removes a node from the tree. | `public TreeNode delete(TreeNode root, int value)` |
| **In-order Traversal** | Visits nodes in the order: Left, Root, Right. | `public void inorderTraversal(TreeNode root)` |
| **Pre-order Traversal**| Visits nodes in the order: Root, Left, Right. | `public void preorderTraversal(TreeNode root)` |
| **Post-order Traversal**| Visits nodes in the order: Left, Right, Root. | `public void postorderTraversal(TreeNode root)` |
| **Level-order Traversal**| Visits nodes level by level, from left to right. | `public void levelorderTraversal(TreeNode root)` |

-----

## 4\. Time Complexity of Operations

The efficiency of tree operations heavily depends on the **height ($h$)** of the tree. For a balanced tree, $h \\approx \\log\_2 n$. For a skewed (unbalanced) tree, $h \\approx n$.

| Operation | Average Case (Balanced Tree) | Worst Case (Skewed Tree) |
| :--- | :---: | :---: |
| **Search** | $O(\\log n)$ | $O(n)$ |
| **Insertion** | $O(\\log n)$ | $O(n)$ |
| **Deletion** | $O(\\log n)$ | $O(n)$ |
| **Traversal (All types)** | $O(n)$ | $O(n)$ |

*(Here, 'n' is the number of nodes in the tree.)*

-----

## 5\. Patterns

Certain algorithmic patterns are frequently used to solve tree-based problems:

  * **Depth-First Search (DFS) 🌲**: This pattern explores as far as possible along each branch before backtracking. It's naturally implemented using **recursion** and corresponds to pre-order, in-order, and post-order traversals.
  * **Breadth-First Search (BFS) 🌊**: This pattern explores all nodes at the present depth level before moving on to the nodes at the next depth level. It's implemented using a **Queue** and corresponds to a level-order traversal.
  * **Divide and Conquer**: Problems like finding the height, diameter, or checking if a tree is balanced can be solved by recursively solving the problem for left and right subtrees and combining the results.
  * **Lowest Common Ancestor (LCA)**: Finding the first shared ancestor of two nodes in a tree.

-----

## 6\. Common Question

### General Tree Problems (solved with DFS/BFS)

These problems concern generic binary trees and are typically solved using a **Depth-First Search (DFS)** or **Breadth-First Search (BFS)** traversal. DFS is often more concise for these.

* **Invert Binary Tree**: A classic recursive (**DFS**) problem to swap left and right children.
* **Maximum Depth of Binary Tree**: Solved with **DFS** by finding `1 + max(depth(left), depth(right))`.
* **Diameter of Binary Tree**: A modified **DFS** where you track the maximum path (`left_depth + right_depth`) at each node.
* **Balanced Binary Tree**: A **DFS** approach that checks the height difference at every node.
* **Same Tree**: A simple **DFS** to recursively check if two trees are identical.
* **Subtree of Another Tree**: Uses **DFS** to traverse the main tree and check for subtree equality at each node.
* **Count Good Nodes in Binary Tree**: A **DFS** problem where you pass the maximum value seen so far down the path.
* **Construct Binary Tree From Preorder And Inorder Traversal**: A recursive (**DFS**) construction algorithm based on traversal properties.
* **Binary Tree Maximum Path Sum**: A hard problem requiring a clever **DFS** to track both "straight" paths and "bending" paths.
* **Serialize and Deserialize Binary Tree**: Can be done with either **DFS** (pre-order traversal) or **BFS** to convert the tree to/from a string.
* **Binary Tree Level Order Traversal**: The definition of a **BFS** traversal.
* **Binary Tree Right Side View**: Can be solved easily with **BFS** by taking the last element at each level of the level-order traversal.

-----

## 7\. Advantages and Disadvantages

### Advantages ✅

  * **Hierarchical Data**: Ideal for representing data that has a natural hierarchy, such as file systems, organizational structures, or XML/JSON data.
  * **Efficient Searching**: In a balanced tree (like an AVL or Red-Black tree), searching for an element is very fast, with $O(\\log n)$ time complexity.
  * **Dynamic Size**: Trees can grow and shrink as needed.
  * **Sorted Order Traversal**: An in-order traversal of a Binary Search Tree retrieves the data in sorted order.

### Disadvantages ❌

  * **Unbalanced Trees**: If a tree becomes unbalanced (skewed), the performance of search, insert, and delete operations degrades to $O(n)$, which is equivalent to a linked list.
  * **Memory Overhead**: Each node requires extra memory to store pointers to its child nodes.
  * **Complexity**: Implementing and managing trees can be more complex than linear data structures. For example, deletion in a BST has several cases to handle.