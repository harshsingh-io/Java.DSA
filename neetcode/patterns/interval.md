## Merge Intervals Pattern

### 1\. About the Algorithm 🧠

The **Merge Intervals** pattern is a popular algorithmic technique used to solve problems involving intervals. An interval is typically represented by a start and end point, like `[start, end]`. This pattern is used to deal with overlapping intervals in an efficient way. The core idea is almost always to **sort the intervals by their start times** and then iterate through the sorted list, merging or processing them based on whether they overlap.

### 2\. Syntax (Java) ☕

In Java, you can represent intervals using a 2D array (`int[][]`) or a custom `Interval` class for better readability.

```java
// Using a 2D array
int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

// Using a custom class (recommended)
class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
```

### 3\. Operations with Syntax 🛠️

The fundamental operation is merging. After sorting the intervals by their start time, you iterate through them and merge any that overlap.

**Example: Merging Overlapping Intervals**

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // 2. Iterate and merge
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) { // Overlap detected
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // No overlap
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
```

### 4\. Time Complexity of the Operations ⏱️

  * **Sorting:** The most crucial step is sorting the intervals. The time complexity for this is $O(N \\log N)$, where $N$ is the number of intervals.
  * **Merging/Iteration:** After sorting, we iterate through the intervals once. The time complexity for this is $O(N)$.
  * **Overall Time Complexity:** The sorting step dominates, so the total time complexity is **$O(N \\log N)$**.
  * **Space Complexity:** If you are creating a new list for the merged intervals (as in the example), the space complexity is **$O(N)$** in the worst case (when no intervals are merged).

### 5\. Patterns ⭐

This approach is the foundation for solving many related problems, including:

  * **Merge Intervals:** Merge all overlapping intervals.
  * **Insert Interval:** Insert a new interval into a list of non-overlapping intervals and merge if necessary.
  * **Non-overlapping Intervals:** Find the minimum number of intervals to remove to make the rest non-overlapping.
  * **Meeting Rooms:** Determine if a person could attend all meetings (i.e., if any meetings overlap).
  * **Meeting Rooms II:** Find the minimum number of conference rooms required for all meetings. This often involves a min-heap to track meeting end times.

### 6\. Advantages and Disadvantages ✅❌

#### Advantages

  * **Efficient:** The $O(N \\log N)$ complexity is very efficient for most use cases.
  * **Systematic:** It provides a structured and reliable approach to a whole class of problems, simplifying complex overlap logic.
  * **Versatile:** The core logic can be adapted to solve various problems, from merging to scheduling and conflict detection.

#### Disadvantages

  * **Sorting Cost:** The main bottleneck is the initial sort. If the input is already sorted or nearly sorted, this might be unnecessary overhead.
  * **Space Usage:** It often requires extra space ($O(N)$) to store the result, which might be a concern for very large datasets.
  * **In-place Modification:** Sorting the intervals modifies their original order. If the original order is important, you must work with a copy, which uses more memory.