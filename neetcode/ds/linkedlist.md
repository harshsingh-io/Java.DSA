# LinkedList

A LinkedList is a linear data structure where elements are stored in nodes, and each node points to the next node in the sequence. Unlike arrays, nodes are not stored in contiguous memory locations.

-----

## 1\. About the Data Structure ⛓️

A **LinkedList** is a collection of nodes ordered in a linear sequence. Each node contains two parts:

1.  **Data**: The actual value stored in the node.
2.  **Next Pointer**: A reference (or pointer) to the next node in the list. The last node's pointer is typically null, indicating the end of the list.

There are three main types:

  * **Singly LinkedList**: Each node points only to the next node.
  * **Doubly LinkedList**: Each node points to both the next and the previous node.
  * **Circular LinkedList**: The last node's pointer points back to the first node, forming a circle.

-----

## 2\. Syntax (Java)

In Java, you can use the `LinkedList` class from the `java.util` package. It is implemented as a Doubly LinkedList.

```java
import java.util.LinkedList;

// Create a new LinkedList of Strings
LinkedList<String> linkedList = new LinkedList<>();
```

-----

## 3\. Operations with Syntax

### Adding Elements

- **`add(element)`**: Appends to the end
    ```java
    linkedList.add("Apple");
    ```

- **`add(index, element)`**: Inserts at a specific position
    ```java
    linkedList.add(1, "Banana");
    ```

- **`addFirst(element)`**: Adds to the beginning
    ```java
    linkedList.addFirst("Mango");
    ```

- **`addLast(element)`**: Adds to the end
    ```java
    linkedList.addLast("Orange");
    ```

### Accessing Elements

- **`get(index)`**: Retrieves an element by index
    ```java
    String fruit = linkedList.get(0);
    ```

- **`getFirst()`**: Retrieves the first element
    ```java
    String firstFruit = linkedList.getFirst();
    ```

- **`getLast()`**: Retrieves the last element
    ```java
    String lastFruit = linkedList.getLast();
    ```

### Removing Elements

- **`remove(index)`**: Removes by index
    ```java
    linkedList.remove(1);
    ```

- **`remove(object)`**: Removes the first occurrence of an element
    ```java
    linkedList.remove("Apple");
    ```

- **`removeFirst()`**: Removes the first element
    ```java
    linkedList.removeFirst();
    ```

- **`removeLast()`**: Removes the last element
    ```java
    linkedList.removeLast();
    ```

### Other Operations

- **`size()`**: Returns the number of elements
    ```java
    int size = linkedList.size();
    ```

- **`contains(object)`**: Checks if the list contains an element
    ```java
    boolean hasApple = linkedList.contains("Apple");
    ```

-----

## 4\. Time Complexity of Operations

The performance depends on the operation. Here, '$n$' is the number of elements in the list.

| Operation | Average Case | Worst Case |
| :--- | :---: | :---: |
| **Access (get)** | $O(n)$ | $O(n)$ |
| **Search (contains)** | $O(n)$ | $O(n)$ |
| **Insertion (add)** | $O(1)$ | $O(1)$ |
| **Deletion (remove)** | $O(n)$ | $O(n)$ |
| **Add/Remove (First/Last)** | $O(1)$ | $O(1)$ |

  * **Insertion/Deletion at the beginning or end** is $O(1)$ because `LinkedList` in Java is doubly-linked, keeping track of both head and tail.
  * **Insertion/Deletion in the middle** requires traversing to the specified index, making it an $O(n)$ operation.

-----

## 5\. Common Patterns

LinkedLists are fundamental for solving specific types of problems:

  * **Two Pointers**: Using two pointers (e.g., a slow and a fast pointer) that iterate through the list at different speeds.
      * *Use Cases*: Detecting a cycle, finding the middle element, finding the n-th element from the end.
  * **Dummy Head Node**: Creating a placeholder node at the beginning of the list to simplify edge cases, such as inserting or deleting from the head.
  * **Reversing a LinkedList**: A classic problem often solved iteratively (by changing pointers) or recursively.
  * **Implementation Base**: Used to implement other data structures like Stacks and Queues efficiently.

-----

## 6\. Common Questions


### Direct LinkedList Manipulations

These problems primarily involve iterating through lists and re-wiring `next` pointers.

* **Reverse Linked List**: The most fundamental pointer manipulation task.
* **Merge Two Sorted Lists**: A classic problem of weaving two lists together.
* **Linked List Cycle**: Solved using the two-pointer (fast and slow) technique specific to lists.
* **Remove Nth Node From End of List**: Another common two-pointer list problem.
* **Reorder List**: A multi-step problem involving finding the middle, reversing, and merging—all list operations.
* **Add Two Numbers**: Involves creating a new list by iterating through two existing ones.
* **Reverse Nodes in k-Group**: An advanced list reversal and reconnection challenge.

***

### LinkedLists Combined with Other Structures

These problems require a linked list as a core component but combine it with another data structure for an optimal solution.

* **Copy List With Random Pointer**: An advanced problem where a hash map is often used to map old nodes to new nodes, simplifying the process of setting the `random` pointers.
* **LRU Cache**: The most efficient solution uses a **hash map** for O(1) lookups and a **doubly linked list** to maintain the order of recently used items.
* **Merge k Sorted Lists**: While it's a list problem, the best solution uses a **min-heap** to efficiently determine the next smallest node among all `k` lists.

***

### Conceptual LinkedList Application

This problem is unique because it uses the *concept* of a linked list to solve a problem on a different data structure.

* **Find the Duplicate Number**: The most clever solution treats the input **array** as a linked list (where `array[i]` points to index `i`), transforming the problem into finding the start of a cycle in a linked list.

-----

## 7\. Advantages and Disadvantages

### Advantages ✅

  * **Dynamic Size**: LinkedLists can grow and shrink during runtime.
  * **Efficient Insertions/Deletions**: Adding or removing elements from the beginning or end is very fast ($O(1)$). Insertion or deletion in the middle is also efficient compared to arrays once the position is located, as it only requires updating pointers without shifting elements.

### Disadvantages ❌

  * **No Random Access**: To access an element at index '$i$', you must traverse the list from the head, which takes $O(n)$ time.
  * **Extra Memory Usage**: Each node requires extra memory to store the pointer(s) to the next (and previous) node.
  * **Poor Cache Locality**: Elements are not stored in contiguous memory, which can lead to more cache misses and slower traversal compared to arrays.