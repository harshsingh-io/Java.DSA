### Notes on Insertion Sort Algorithm

These notes are based on the video "Insertion Sort Algorithm - Theory + Code" by Kunal Kushwaha.

#### 1. Introduction to Insertion Sort
*   **Insertion Sort** is presented as the third sorting algorithm discussed in the series.
*   The video aims to cover its benefits, the number of passes it makes, time complexity, and space complexity.
*   **Space Complexity:** From the iteration perspective, Insertion Sort has **constant space complexity**.

#### 2. Intuition and Comparison with Other Sorting Algorithms
*   **Different Approach:** Insertion Sort's underlying idea is distinct from Bubble Sort and Selection Sort.
*   **Bubble Sort:** In Bubble Sort, with every pass, the largest element moves to its correct last position. For example, the first pass moves the biggest element to the last index, the second pass moves the second largest to the second last index, and so on.
*   **Selection Sort:** Similar to Bubble Sort, Selection Sort also places the first largest element at the last index, the second largest at the second last index, etc., by searching for the appropriate element.
*   **Insertion Sort's Core Idea:**
    *   It **sorts the array partially**.
    *   The process involves taking an element and **inserting it into its correct position within the already sorted part** of the array to its left.
    *   **For every index `i`, the element at that index `arr[i]` is inserted into the correct position within the already sorted left-hand side of the array**.

#### 3. How Insertion Sort Works Internally (Step-by-Step Example)
Let's consider an example array: `[5, 3, 4, 1, 2]`.

The algorithm effectively sorts the array incrementally, extending the sorted portion from the left:
*   **After Pass 1 (i=0):** The array till index 1 is sorted.
*   **After Pass 2 (i=1):** The array till index 2 is sorted.
*   **After Pass 3 (i=2):** The array till index 3 is sorted.
*   **After Pass 4 (i=3):** The array till index 4 is sorted.

Let's trace the example `[5, 3, 4, 1, 2]`:

*   **Initial Array:** `[5, 3, 4, 1, 2]`
*   **Outer loop `i` starts from 0:** This means we are trying to ensure the array is sorted up to `i+1`.

    *   **i = 0:**
        *   `j` starts from `i+1` (index 1). Element `arr` is `3`.
        *   Compare `arr` (3) with `arr` (5).
        *   Is `3 < 5`? Yes. **Swap** them.
        *   Array becomes: `[3, 5, 4, 1, 2]`.
        *   `j` decrements to 0. The inner loop condition `j > 0` (from code) is now false, so the inner loop breaks.
        *   Result after `i=0`: `[3, 5, 4, 1, 2]`. The sub-array `[3, 5]` (till index 1) is sorted.

    *   **i = 1:**
        *   `j` starts from `i+1` (index 2). Element `arr` is `4`.
        *   Compare `arr` (4) with `arr` (5).
        *   Is `4 < 5`? Yes. **Swap** them.
        *   Array becomes: `[3, 4, 5, 1, 2]`.
        *   `j` decrements to 1.
        *   Compare `arr` (4) with `arr` (3).
        *   Is `4 < 3`? No. **Break the inner loop**. This is crucial: if an element is not smaller than its left neighbor, it's in its correct position relative to the sorted left part, so no more comparisons are needed.
        *   Result after `i=1`: `[3, 4, 5, 1, 2]`. The sub-array `[3, 4, 5]` (till index 2) is sorted.

    *   **i = 2:**
        *   `j` starts from `i+1` (index 3). Element `arr` is `1`.
        *   Compare `arr` (1) with `arr` (5). Is `1 < 5`? Yes. Swap.
        *   Array: `[3, 4, 1, 5, 2]`.
        *   `j` decrements to 2.
        *   Compare `arr` (1) with `arr` (4). Is `1 < 4`? Yes. Swap.
        *   Array: `[3, 1, 4, 5, 2]`.
        *   `j` decrements to 1.
        *   Compare `arr` (1) with `arr` (3). Is `1 < 3`? Yes. Swap.
        *   Array: `[1, 3, 4, 5, 2]`.
        *   `j` decrements to 0. Inner loop breaks.
        *   Result after `i=2`: `[1, 3, 4, 5, 2]`. The sub-array `[1, 3, 4, 5]` (till index 3) is sorted.

    *   **i = 3:**
        *   `j` starts from `i+1` (index 4). Element `arr` is `2`.
        *   Compare `arr` (2) with `arr` (5). Is `2 < 5`? Yes. Swap.
        *   Array: `[1, 3, 4, 2, 5]`.
        *   `j` decrements to 3.
        *   Compare `arr` (2) with `arr` (4). Is `2 < 4`? Yes. Swap.
        *   Array: `[1, 3, 2, 4, 5]`.
        *   `j` decrements to 2.
        *   Compare `arr` (2) with `arr` (3). Is `2 < 3`? Yes. Swap.
        *   Array: `[1, 2, 3, 4, 5]`.
        *   `j` decrements to 1.
        *   Compare `arr` (2) with `arr` (1). Is `2 < 1`? No. Break the inner loop.
        *   Result after `i=3`: `[1, 2, 3, 4, 5]`. The sub-array `[1, 2, 3, 4, 5]` (till index 4) is sorted.

*   The outer `i` loop typically runs until `n-2` (where `n` is the array length). For an array of length 5, `i` runs from 0 to 3.

#### 4. Time Complexity Analysis
*   **Worst Case Time Complexity: O(N^2)**.
    *   This occurs when the array is **reverse sorted** (e.g., ``).
    *   In this scenario, for each element `arr[i]`, it has to be compared and swapped with all elements to its left.
    *   The number of comparisons in each pass `i` would be `i` (or `i+1` depending on how you count it).
    *   For `i=0` (pass 1): 1 comparison.
    *   For `i=1` (pass 2): 2 comparisons.
    *   ...
    *   For `i=n-2` (pass `n-1`): `n-1` comparisons.
    *   Total comparisons sum up to `1 + 2 + ... + (n-1)`, which is `(n-1) * n / 2`. This is approximately `N^2/2`, hence **Big O(N^2)**.

*   **Best Case Time Complexity: O(N)**.
    *   This occurs when the array is **already sorted** (e.g., `[1, 2, 3, 4, 5]`).
    *   For each element `arr[j]`, it is compared only once with its immediate left neighbor `arr[j-1]`.
    *   Since `arr[j]` will not be smaller than `arr[j-1]` (because it's already sorted), the inner loop will **break immediately** after the first comparison.
    *   Therefore, there are only `n-1` comparisons in total, resulting in **linear time complexity, Big O(N)**.

#### 5. Why Use Insertion Sort? (Advantages/Benefits)
Insertion Sort offers several advantages:
*   **Adaptive:** The algorithm performs fewer operations if the array is already partially or completely sorted. The inner loop breaks early if an element is not smaller than its left neighbor. This makes it more efficient than Bubble Sort in such scenarios.
*   **Stable:** It maintains the relative order of elements with equal values.
*   **Efficient for Smaller Arrays (Small N):** It is generally a good choice for sorting small datasets.
*   **Efficient for Partially Sorted Arrays:** Performs well when the input array is already mostly sorted.
*   **Used in Hybrid Sorting Algorithms:** Insertion Sort is a component of more complex, high-performance sorting algorithms.
    *   Examples include **Timsort** (used in Python and Java's `Arrays.sort()`) and **IntroSort** (which combines Quicksort, Heapsort, and Insertion Sort for smaller sub-arrays).
    *   It's used internally for tasks like merging or sorting small segments within these hybrid algorithms.

#### 6. Code Structure (Java Example)
The basic structure of an Insertion Sort implementation in Java, as described, involves nested loops:

```java
static void insertionSort(int[] arr) {
    // Outer loop: Iterates from the second element (index 1) up to the second-to-last element (n-2)
    // 'i' marks the division between the sorted and unsorted parts.
    // Elements from index 0 to 'i' are considered sorted.
    for (int i = 0; i < arr.length - 1; i++) {
        // Inner loop: Starts from the element to be inserted (at index i+1)
        // and moves it to its correct position in the sorted left sub-array.
        // 'j' goes backwards, comparing the current element with its predecessors.
        for (int j = i + 1; j > 0; j--) {
            // If the current element (arr[j]) is smaller than its left neighbor (arr[j-1])
            if (arr[j] < arr[j-1]) {
                // Swap the elements
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            } else {
                // If arr[j] is not smaller than arr[j-1], it's in its correct place
                // relative to the left sorted portion, so we can stop comparing.
                break;
            }
        }
    }
}
```
*   The outer loop (`i`) iterates from `0` to `n-2`.
*   The inner loop (`j`) starts from `i+1` and goes down to `1` (or `j > 0`).
*   The core logic involves comparing `arr[j]` with `arr[j-1]` and swapping if `arr[j]` is smaller.
*   A critical optimization is the `break` statement in the inner loop: if `arr[j]` is not smaller than `arr[j-1]`, it means the element is already in its correct sorted position relative to the left sub-array, and no further comparisons to the left are necessary.

### Recursive Approach:

```java
class Solution {
    /*
    [ 4, 1, 3, 9, 7 ]
    insertionSortRecursion(i, j, nums)
    i = 0, j = 0 [4, 1, 3, 9, 7] 
    i = 1, j = 1 [4, 1, 3, 9, 7] 
    i = 1, j = 0 [1, 4, 3, 9, 7] 
    i = 2, j = 2 [1, 4, 3, 9, 7] 
    i = 2, j = 1 [1, 3, 4, 9, 7] 
    i = 2, j = 0 [1, 3, 4, 9, 7]
    i = 3, j = 3 [1, 3, 4, 9, 7] 
    i = 3, j = 2 [1, 3, 4, 9, 7]
    i = 3, j = 1 [1, 3, 4, 9, 7]
    i = 3, j = 0 [1, 3, 4, 9, 7]
    i = 4, j = 4 [1, 3, 4, 9, 7]
    i = 4, j = 3 [1, 3, 4, 7, 9]
    */
    
    /**
     * This function acts as the "outer loop", picking one element at a time
     * from the unsorted part of the array.
     * @param arr The array to be sorted.
     * @param i The index of the current element to be inserted.
     */
    private void sortRecursively(int[] arr, int i) {
        // Base case: If we've processed all elements, the array is sorted.
        if (i >= arr.length) {
            return;
        }

        // Start the "inner loop" process to insert the element at arr[i]
        // into its correct place within the sorted subarray arr[0...i-1].
        insert(arr, i);

        // Recur for the next element.
        sortRecursively(arr, i + 1);
    }

    /**
     * This function acts as the "inner loop", using recursion to swap
     * the element at index j leftwards until it is in the correct sorted position.
     * @param arr The array being sorted.
     * @param j The index of the element currently being moved.
     */
    private void insert(int[] arr, int j) {
        // Base case: If we've reached the start of the array or the element
        // is now in its correct sorted position (it's >= the one before it).
        if (j <= 0 || arr[j] >= arr[j - 1]) {
            return;
        }

        // Swap the element with the one to its left.
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;

        // Continue the insertion process by moving to the left.
        insert(arr, j - 1);
    }
    // The main public method that starts the recursion.
    public void insertionSort(int[] arr) {
        // We start the sorting process from the second element (index 1),
        // as the first element is already a "sorted" subarray of one.
        sortRecursively(arr, 1);
    }

}
```

To implement Insertion Sort recursively, we can model the two nested loops of the iterative version with two separate recursive functions.

  * One function, `sortRecursively`, will act as the **outer loop**, responsible for picking an element from the unsorted part of the array.
  * A second function, `insert`, will act as the **inner loop**, responsible for inserting that chosen element into its correct position within the already sorted part.

#### Explanation of the Logic

1.  **`sortRecursively(arr, i)` (The "Outer Loop"):**

      * This function's job is to ensure that the subarray from `arr[0]` to `arr[i]` is sorted.
      * **Base Case:** If `i` reaches the end of the array (`i >= arr.length`), it means all elements have been processed, and the recursion stops.
      * **Recursive Step:** For a given `i`, it first calls `insert(arr, i)` to place the element at `arr[i]` into its correct sorted position within the `arr[0...i-1]` subarray. After that's done, it makes a recursive call for the next element: `sortRecursively(arr, i + 1)`.

2.  **`insert(arr, j)` (The "Inner Loop"):**

      * This function takes an element at index `j` and recursively shifts it to the left until it finds its correct sorted position.
      * **Base Case:** The recursion stops if `j` reaches the beginning of the array (`j <= 0`) or if the element `arr[j]` is no longer smaller than the element to its left (`arr[j] >= arr[j-1]`). This second condition is the same as the `break` statement in the iterative version, making the algorithm adaptive.
      * **Recursive Step:** If the element `arr[j]` is smaller than `arr[j-1]`, it swaps them. Then, it makes a recursive call to continue shifting the element leftward: `insert(arr, j - 1)`.
