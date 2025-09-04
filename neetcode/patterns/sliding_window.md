# Sliding Window

### 1\. About the Algorithm 🧑‍💻

The **Sliding Window** is an algorithmic technique used for solving problems that involve finding a subarray or substring in an array or string that satisfies a certain condition. The core idea is to maintain a "window" (a contiguous sub-part of the data) and "slide" it over the data structure, one element at a time. This avoids re-computation by extending the window at one end and shrinking it from the other, making it highly efficient.

-----

### 2\. Syntax (Java)

Here is a general template for a variable-sized sliding window in Java.

```java
// Generic template for a variable-sized sliding window
public int slidingWindowTemplate(int[] arr, int target) {
    int windowStart = 0;
    int currentSum = 0; // Or other metric like character count
    int minLength = Integer.MAX_VALUE;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        // Add the next element to the window
        currentSum += arr[windowEnd];

        // Shrink the window from the left as long as the condition is met
        while (currentSum >= target) {
            // Update the result (e.g., find minimum length)
            minLength = Math.min(minLength, windowEnd - windowStart + 1);

            // Remove the element from the left of the window
            currentSum -= arr[windowStart];
            windowStart++; // Slide the window forward
        }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

-----

### 3\. Operations with Syntax

The primary operations involve manipulating the window's boundaries.

  * **Expand Window**: The window is expanded by moving its right boundary (`windowEnd`). This is typically done inside a `for` loop.

    ```java
    // windowEnd is incremented by the for loop
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        // ...
    }
    ```

  * **Process Window**: Calculations are performed on the current window to check if it meets the problem's criteria.

    ```java
    // Example: Update a running sum
    currentSum += arr[windowEnd];
    ```

  * **Shrink Window**: The window is contracted by moving its left boundary (`windowStart`) forward. This is usually done in a `while` loop when a certain condition is met.

    ```java
    // When a condition is met, shrink the window
    while (condition) {
        // Remove the leftmost element's contribution
        currentSum -= arr[windowStart];
        // Move the left pointer to the right
        windowStart++;
    }
    ```

-----

### 4\. Time Complexity of the Operations

The key benefit of the sliding window pattern is its efficiency.

  * **Time Complexity**: $O(N)$
    Each element in the array is visited at most twice: once by the `windowEnd` pointer (when expanding) and once by the `windowStart` pointer (when shrinking). This results in a linear time complexity.

  * **Space Complexity**: $O(1)$ or $O(K)$
    The space complexity is typically constant, $O(1)$, if no auxiliary data structures are used. If a hash map or frequency array is used to store the contents of the window, the space complexity becomes $O(K)$, where $K$ is the number of distinct elements in the window.

-----

### 5\. Patterns

The sliding window pattern is ideal for problems involving contiguous subarrays or substrings. Common variations include:

  * **Fixed Size Window**: Finding the max/min sum, average, or other value of all subarrays of a fixed size `k`.
  * **Variable Size Window**: Finding the smallest or largest subarray that satisfies a condition (e.g., "smallest subarray with sum $\\ge$ S").
  * **Using Auxiliary Data Structures**: Problems that require tracking character frequencies or distinct elements, often using a **HashMap** or an array as a frequency map (e.g., "longest substring with `k` distinct characters").

-----

### 6\. Common Questions

* **Best Time to Buy and Sell Stock**
This is a simple application where the "window" is the time between a potential buy day and a sell day. The left pointer tracks the lowest price found so far, and the right pointer explores future days to find the maximum profit.

* **Longest Substring Without Repeating Characters**
A dynamic-sized window is used. The right pointer expands the window, and a hash set tracks characters inside it. If a duplicate character is found, the left pointer shrinks the window until the substring is valid again.

* **Longest Repeating Character Replacement**
The window expands as long as the number of characters that need to be replaced (`k`) is sufficient. The condition to check is `window length - count of most frequent character <= k`. If the condition is violated, the window shrinks from the left.

* **Permutation in String**
This uses a **fixed-size** sliding window (the size of the string `s1`). The window slides across `s2`, and for each position, you check if the character frequencies within the window match the frequencies in `s1`.

* **Minimum Window Substring**
This is a classic and more complex sliding window problem. The window expands until it contains all the required characters from string `t`. Then, it shrinks from the left as much as possible while still being a valid window, aiming to find the smallest one.

* **Sliding Window Maximum**
As the name suggests, this is a sliding window problem. The most efficient solution uses a **deque** (a double-ended queue) to maintain the indices of potential maximums within the fixed-size window, allowing you to find the max of any window in O(1) time.

-----

### 7\. Advantages and Disadvantages

#### Advantages

  * **Efficiency**: Provides an optimal time complexity of $O(N)$, significantly better than brute-force approaches which are often $O(N^2)$ or $O(N^3)$.
  * **Intuitive**: Conceptually simple for problems dealing with contiguous sequences.
  * **Reduces Redundancy**: Avoids re-calculating values for overlapping subarrays by simply adding the new element and removing the old one.

#### Disadvantages

  * **Limited Applicability**: Only works for problems involving contiguous subarrays or substrings. It cannot be used if the elements are non-contiguous.
  * **Tricky Implementation**: The logic for shrinking the window (the `while` loop condition) can be complex and error-prone.
  * **Not for all Array Problems**: Does not apply to problems where sorting is required or where subarray elements don't need to be contiguous.