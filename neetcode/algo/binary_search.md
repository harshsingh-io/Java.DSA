# Binary Search

Binary Search is a highly efficient searching algorithm that works on **sorted** arrays. It follows a divide-and-conquer approach by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, it narrows the interval to the lower half; otherwise, it narrows it to the upper half. This process continues until the value is found or the interval is empty.

-----

## Syntax (Java)

Here are the standard iterative and recursive implementations for binary search in Java.

### Iterative Implementation

```java
int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        // To prevent overflow for large left/right values
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Target found, return its index
        }

        if (arr[mid] < target) {
            left = mid + 1; // Search in the right half
        } else {
            right = mid - 1; // Search in the left half
        }
    }
    return -1; // Target not found
}
```

### Recursive Implementation

```java
int recursiveBinarySearch(int[] arr, int left, int right, int target) {
    if (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Target found
        }

        if (arr[mid] < target) {
            // Recur on the right half
            return recursiveBinarySearch(arr, mid + 1, right, target);
        } else {
            // Recur on the left half
            return recursiveBinarySearch(arr, left, mid - 1, target);
        }
    }
    return -1; // Target not found
}
```

-----

## Time & Space Complexity

The efficiency of binary search is one of its key advantages.

  * **Time Complexity**:
      * **Best Case**: $O(1)$ - The target element is found at the middle index in the first comparison.
      * **Average Case**: $O(\\log n)$ - The search space is halved in each step.
      * **Worst Case**: $O(\\log n)$ - The target element is not in the array or is found at the last step.
  * **Space Complexity**:
      * **Iterative Approach**: $O(1)$ - Constant space is used.
      * **Recursive Approach**: $O(\\log n)$ - Space is used by the recursion call stack.

-----

## Common Patterns 🧩

Binary search is not just for finding an element. It's a powerful technique for a variety of problems on sorted or partially sorted data.

  * **Find First/Last Occurrence**: Modify the standard algorithm to continue searching in the left half even after finding the target (for the first occurrence) or in the right half (for the last occurrence).
  * **Find Floor/Ceiling of an Element**: Find the greatest element less than or equal to the target (Floor) or the smallest element greater than or equal to the target (Ceiling).
  * **Search in a Rotated Sorted Array**: First, find the pivot point (the point of rotation), which divides the array into two sorted subarrays. Then, perform a binary search on the appropriate subarray.
  * **Find a Peak Element**: An element is a peak if it's greater than or equal to its neighbors. The search space can be halved by comparing the middle element with its neighbors.
  * **Binary Search on the Answer**: This powerful pattern is used for optimization problems (e.g., "minimize the maximum value" or "maximize the minimum value"). You binary search on the range of possible answers rather than on the array indices. For each `mid` value (potential answer), you check if it's a feasible solution.

-----

## Common Question

The key insight for these problems is to find a **monotonic property** (something that is sorted or consistently increasing/decreasing) that allows you to repeatedly cut the search space in half.

***

### Direct Binary Search

These problems apply binary search directly to a sorted data structure.

* **Binary Search**: The fundamental algorithm itself.
* **Search a 2D Matrix**: The matrix is structured like a single, large sorted array, allowing for a direct binary search.
* **Time Based Key-Value Store**: This uses a hash map where each value is a list of timestamps. Since the timestamps are naturally sorted, you use binary search to find the correct value for a given time.

***

### Binary Search on a Modified Sorted Array

These problems involve arrays that are "almost sorted," requiring a modified binary search to navigate the rotation or pivot point.

* **Find Minimum in Rotated Sorted Array**: You use binary search to find the "pivot point" where the rotation occurs, which corresponds to the minimum element.
* **Search in Rotated Sorted Array**: A modified binary search where you first determine which half of the array is sorted, then decide whether to search within that sorted half or the other rotated half.

***

### Binary Search on the "Answer"

For these problems, you aren't searching through the input array itself, but rather searching for the correct answer within a possible range of answers.

* **Koko Eating Bananas**: You perform a binary search on the possible eating speeds (`k`). For any given `k`, you can check if it's a valid solution. This allows you to efficiently find the *minimum* possible `k`.
* **Median of Two Sorted Arrays**: This is a very advanced application. You perform a binary search on one of the arrays to find the correct "partition" point that would divide the combined elements into two equal halves, thus revealing the median.

-----

## Advantages and Disadvantages

### ✅ Advantages

  * **Efficiency**: It has a logarithmic time complexity $O(\\log n)$, which is significantly faster than linear search $O(n)$ for large datasets.
  * **Simplicity**: The core logic is relatively easy to understand and implement.
  * **Versatility**: It can be adapted to solve a wide range of problems beyond simple searching.

### ❌ Disadvantages

  * **Requires a Sorted Array**: The primary requirement is that the data structure must be sorted. Sorting an unsorted array first can add an $O(n \\log n)$ overhead.
  * **Inefficient for Small Datasets**: For small arrays, the overhead of binary search might make it slower than a simple linear search.
  * **Data Structure Limitation**: It's primarily designed for arrays or data structures that allow efficient random access (accessing an element by its index in $O(1)$ time). It's not suitable for linked lists.