### Binary Search Tree (BST)

A **Binary Search Tree** is a special type of binary tree data structure where nodes are organized in a specific order. This structure makes searching, insertion, and deletion operations very efficient on average. 🌲

The key property of a BST is that for any given node:

1.  All keys in the **left subtree** are **less than** the node's key.
2.  All keys in the **right subtree** are **greater than** the node's key.
3.  Both the left and right subtrees must also be binary search trees.

-----

### Syntax (Java)

A BST is typically implemented using a `Node` class and a main tree class that holds a reference to the root node.

```java
// Node class representing each element in the tree
class Node {
    int key;
    Node left;
    Node right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Main BST class
class BinarySearchTree {
    // Root of the BST
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Methods for operations like insert, search, delete go here...
}
```

-----

### Operations with Syntax

The core operations rely on the BST property, usually implemented recursively.

1.  **Search:** To find a key, you compare it with the current node's key and decide whether to go left (if the key is smaller) or right (if the key is larger).
    ```java
    // Method signature for searching a key
    public boolean search(int key) { ... }
    ```
2.  **Insert:** Find the correct empty spot for the new key by traversing the tree, then insert the new node.
    ```java
    // Method signature for inserting a key
    public void insert(int key) { ... }
    ```
3.  **Delete:** This is the most complex operation with three cases for the node to be deleted:
      * **Case 1: No children (leaf node).** Simply remove the node.
      * **Case 2: One child.** Replace the node with its child.
      * **Case 3: Two children.** Replace the node with its **in-order successor** (the smallest key in its right subtree) or **in-order predecessor** (the largest key in its left subtree), and then delete that successor/predecessor.
    <!-- end list -->
    ```java
    // Method signature for deleting a key
    public void delete(int key) { ... }
    ```

-----

### Time Complexity

The efficiency of a BST depends heavily on its height ($h$).

| Operation | Average Case (Balanced Tree) | Worst Case (Skewed Tree) |
| :-------- | :--------------------------: | :----------------------: |
| **Search** |           $O(\\log n)$            |          $O(n)$          |
| **Insert** |           $O(\\log n)$            |          $O(n)$          |
| **Delete** |           $O(\\log n)$            |          $O(n)$          |
| **Space** |            $O(n)$              |          $O(n)$          |

  * **Average Case:** Occurs when the tree is reasonably balanced.
  * **Worst Case:** Occurs when the tree is unbalanced (skewed), resembling a linked list. This happens if you insert elements in sorted order.

-----

### Common Question

These problems specifically leverage the properties of a **Binary Search Tree** (e.g., left child < parent < right child) for an efficient solution.

* **Validate Binary Search Tree**: Uses **DFS** to check if the tree adheres to the BST property at every node within a valid `(min, max)` range.
* **Kth Smallest Element in a BST**: Solved efficiently by performing an in-order traversal (**DFS**), which visits nodes in sorted order.
* **Lowest Common Ancestor of a Binary Search Tree**: Uses a targeted search (not a full traversal) that exploits BST properties to find where the paths to the two nodes diverge.


-----

### Common Patterns

BSTs are fundamental to solving many problems efficiently.

  * **In-order Traversal:** Performing an in-order traversal (Left, Root, Right) on a BST visits the nodes in ascending sorted order.
  * **Validate a BST:** Check if a given binary tree adheres to the BST properties. This is a classic interview question.
  * **Find k-th Smallest/Largest Element:** Use in-order traversal to find the k-th element.
  * **Lowest Common Ancestor (LCA):** Find the first node from the root that has the two target nodes in different subtrees.
  * **Floor and Ceil:** Find the largest key smaller than or equal to a given number (floor) or the smallest key greater than or equal to a given number (ceil).

-----

### Advantages and Disadvantages

#### Advantages 👍

  * **Efficient Operations:** On average, search, insert, and delete operations are very fast ($O(\\log n)$).
  * **Sorted Order:** The tree keeps keys in sorted order, making it easy to perform range queries or print all items in order.
  * **Simple Structure:** The basic rules of a BST are relatively easy to understand and implement compared to more complex self-balancing trees.

#### Disadvantages 👎

  * **Worst-Case Performance:** In the worst-case scenario (e.g., inserting a sorted list of numbers), the tree becomes unbalanced (skewed), and performance degrades to that of a linked list ($O(n)$).
  * **No Self-Balancing:** A standard BST doesn't automatically balance itself. For guaranteed performance, you need to use self-balancing variants like **AVL Trees** or **Red-Black Trees**.