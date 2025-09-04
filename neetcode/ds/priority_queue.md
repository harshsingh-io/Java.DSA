# Heap/Priority Queue

A heap is a specialized tree-based data structure that satisfies the heap property. A **Priority Queue** is an abstract data type that operates like a regular queue but assigns a priority to each element. Heaps are a common and efficient way to implement Priority Queues.

  * **Min-Heap**: The value of each node is less than or equal to the value of its children. The smallest element is always at the root.
  * **Max-Heap**: The value of each node is greater than or equal to the value of its children. The largest element is always at the root.

By default, Java's `PriorityQueue` is a **min-heap**.

-----

## Syntax (Java)

You can use the `PriorityQueue` class from the `java.util` package.

```java
import java.util.PriorityQueue;
import java.util.Collections;

// Min-Heap (default behavior)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max-Heap (using a custom comparator or Collections.reverseOrder())
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

-----

## Operations with Syntax

The primary operations involve adding elements, removing the element with the highest priority (the root), and inspecting the root.

| Operation | Description | Java Syntax |
| :--- | :--- | :--- |
| **Insertion** | Adds an element to the heap, maintaining the heap property. | `pq.add(element);` or `pq.offer(element);` |
| **Deletion** | Removes and returns the root element (min or max). | `pq.poll();` |
| **Peek** | Returns the root element without removing it. | `pq.peek();` |
| **Check Empty** | Checks if the priority queue is empty. | `pq.isEmpty();` |
| **Get Size** | Returns the number of elements in the queue. | `pq.size();` |

```java
// Example Usage
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.add(10);
minHeap.add(5);
minHeap.add(20);

System.out.println(minHeap.peek()); // Outputs 5
System.out.println(minHeap.poll()); // Outputs 5
System.out.println(minHeap.peek()); // Outputs 10
```

-----

## Time Complexity of the Operations

Let $N$ be the number of elements in the heap.

| Operation | Time Complexity |
| :--- | :--- |
| Insertion (`add`, `offer`) | $O(\\log N)$ |
| Deletion (`poll`, `remove`) | $O(\\log N)$ |
| Peek (`peek`, `element`) | $O(1)$ |
| Search | $O(N)$ |

Building a heap from an array of $N$ elements can be done in $O(N)$ time (this process is called heapify).

-----

## Patterns

Heaps are excellent for problems that require efficiently finding the smallest or largest element among a changing set of data. ⚙️

  * **Top 'K' Elements**: Finding the 'K' largest or smallest elements in a collection (e.g., Kth largest element in an array).
  * **Median of a Data Stream**: Using two heaps (a max-heap and a min-heap) to keep track of the median as new numbers arrive.
  * **Merge 'K' Sorted Lists**: Merging multiple sorted lists into a single sorted list.
  * **Shortest Path Algorithms**: Used in Dijkstra's algorithm to efficiently select the vertex with the smallest distance.
  * **Event Scheduling**: Managing events in a simulation, where the next event to process is the one with the earliest timestamp.

-----

## Common Question

### Kth Largest Element in a Stream
This is a classic use case for a **min-heap** of size `k`. The heap stores the `k` largest elements seen so far, and its root always represents the kth largest element.

### Last Stone Weight
A **max-heap** is ideal here. You can add all stones to it and then efficiently extract the two heaviest stones in each step until one or zero remain.

### K Closest Points to Origin
This problem is solved by maintaining a **max-heap** of size `k`. The heap stores the `k` points with the smallest distances found so far. You iterate through the points, and if a point is closer than the "farthest" point in your heap, you replace it.

### Kth Largest Element in an Array
Similar to the stream version, this can be solved by pushing all elements into a **min-heap** of size `k`. After iterating through the array, the root of the heap is your answer.

### Task Scheduler
A **max-heap** is used to implement a greedy strategy. The heap stores the frequencies of available tasks, allowing the CPU to always pick the most frequent task that is not on cooldown.

### Design Twitter
To generate a user's news feed, you need to merge the sorted tweet lists from everyone they follow. A **max-heap** is the perfect tool to solve this "merge k sorted lists" sub-problem and efficiently find the 10 most recent tweets.

### Find Median from Data Stream
This is a famous problem solved with a clever **two-heap** structure. A **max-heap** stores the smaller half of the numbers, and a **min-heap** stores the larger half. By keeping the heaps balanced, the median can be calculated in O(1) from their top elements.

-----

## Advantages and Disadvantages

### Advantages ✅

  * **Efficient Retrieval**: Finding the min/max element is very fast ($O(1)$).
  * **Efficient Insertion/Deletion**: Both operations are logarithmic, making heaps faster than sorted arrays ($O(N)$ for insertion) or linked lists ($O(N)$ for insertion in a sorted list).
  * **Flexible Size**: The data structure can grow and shrink dynamically.
  * **Space Efficient**: Can be implemented using an array with no pointers, saving memory.

### Disadvantages ❌

  * **Slow Search**: Searching for an element other than the root is slow ($O(N)$) because the heap property doesn't guarantee any order among siblings or cousins.
  * **Partial Ordering**: The data is not fully sorted. To get a sorted list of elements, you need to repeatedly poll from the heap, which takes $O(N \\log N)$ time (this is the basis for the HeapSort algorithm).
  * **Memory Overhead**: While the array implementation is efficient, the `PriorityQueue` object in Java has some memory overhead.