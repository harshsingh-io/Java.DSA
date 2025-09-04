# Stack

A stack is a linear data structure that follows the **Last-In, First-Out (LIFO)** principle. Think of it like a stack of plates; you can only add a new plate to the top or remove the topmost plate.

-----

### 1\. About the Stack Data Structure 📚

A stack is an abstract data type that serves as a collection of elements, with two primary operations:

  * **Push**: Adds an element to the collection.
  * **Pop**: Removes the most recently added element.

This behavior is known as LIFO (Last-In, First-Out). The element placed last will be the first one to be removed.

-----

### 2\. Syntax (Java)

In Java, you can use the `Stack` class from the `java.util` package.

```java
import java.util.Stack;

// To create a stack of Integers
Stack<Integer> numberStack = new Stack<>();

// To create a stack of Strings
Stack<String> stringStack = new Stack<>();
```

-----

### 3\. Operations with Syntax

Here are the fundamental operations for a stack in Java.

| Operation | Description | Java Syntax |
| :--- | :--- | :--- |
| **Push** | Adds an element to the top of the stack. | `stack.push(element);` |
| **Pop** | Removes and returns the element at the top. | `stack.pop();` |
| **Peek** | Returns the top element without removing it. | `stack.peek();` |
| **isEmpty**| Checks if the stack is empty. | `stack.isEmpty();` |
| **size** | Returns the number of elements in the stack. | `stack.size();` |

-----

### 4\. Time Complexity of Operations ⏱️

All standard stack operations are highly efficient.

| Operation | Time Complexity |
| :--- | :--- |
| Push | $O(1)$ |
| Pop | $O(1)$ |
| Peek | $O(1)$ |
| isEmpty | $O(1)$ |
| size | $O(1)$ |
| Search | $O(n)$ |

The primary operations only involve manipulating the top element, hence the constant time complexity.

-----

### 5\. Common Patterns & Problems 🧩

Stacks are useful for solving problems that involve reversing order or managing nested structures.

  * **Expression Evaluation**: Converting expressions from infix to postfix or prefix notation.
  * **Balanced Parentheses**: Checking if an expression has balanced brackets `( )`, `[ ]`, `{ }`.
  * **Backtracking**: Used in algorithms like maze solving, Sudoku solvers, and the N-Queens problem.
  * **Function Call Management**: The "call stack" in programming languages manages active function calls.
  * **Undo/Redo Functionality**: Stacks can store previous states to implement undo/redo features in software.
  * **Next Greater/Smaller Element**: Finding the next greater or smaller element in an array for each element.

-----

### 6\. Common Questions


* **Valid Parentheses**
This is the most fundamental stack problem. You push opening brackets `(`, `{`, `[` onto the stack. When you encounter a closing bracket, you check if the top of the stack is the matching opening bracket and pop it.

* **Min Stack**
This problem requires you to implement a stack. The challenge is solved by using an auxiliary stack (or storing pairs in one stack) to keep track of the current minimum value at every level of the main stack.

* **Evaluate Reverse Polish Notation**
When you encounter a number, you push it onto the stack. When you see an operator (`+`, `-`, `*`, `/`), you pop two numbers, perform the operation, and push the result back onto the stack.

* **Generate Parentheses**
This is typically solved with recursion/backtracking. The function call stack itself acts as the "stack" that manages the state of the parentheses string being built.

* **Daily Temperatures**
A **monotonic decreasing stack** is used here. You store indices of days in the stack. When you find a day with a warmer temperature, you can pop all the previous days from the stack that are cooler than the current day and calculate the waiting period.

* **Car Fleet**
After calculating the arrival times for each car, you can use a stack. By processing cars from closest to the destination to farthest, you push their arrival times onto a stack. A car forms a new fleet only if its arrival time is later than the fleet in front of it (the time at the top of the stack).

* **Largest Rectangle In Histogram**
This is a famous **monotonic increasing stack** problem. The stack stores the indices of histogram bars. By maintaining an increasing height order in the stack, you can calculate the maximum area for each bar when it's popped.

-----

### 7\. Advantages and Disadvantages

#### Advantages 👍

  * **LIFO Method**: Helps manage data in a specific Last-In, First-Out order which is required in many applications.
  * **Fast Operations**: All primary operations (push, pop, peek) have a time complexity of $O(1)$.
  * **Simple Implementation**: Easy to understand and implement using either arrays or linked lists.
  * **Automatic Memory Management**: Variables are automatically created and destroyed as functions are called and returned.

#### Disadvantages 👎

  * **Limited Access**: You can only access the top element of the stack, not elements in the middle.
  * **Potential Overflow**: If the stack is implemented with a fixed-size array, it can overflow if you push too many elements.
  * **Inflexibility**: Not as flexible as other data structures like arrays or linked lists for operations like searching or sorting.