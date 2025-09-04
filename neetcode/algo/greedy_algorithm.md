A greedy algorithm is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. It makes the **locally optimal choice** at each stage with the hope of finding a **global optimum**. greedy algorithms don't always produce the optimal solution, but they are very effective for certain problems.

-----

## Syntax (Java General Template)

Greedy algorithms are a design approach, not a specific data structure. The implementation varies by problem. Here's a general structure.

```java
// A generic structure for a greedy algorithm in Java

public class GreedySolution {

    // Represents an item or choice in the problem
    static class Item {
        // Attributes like weight, value, start time, end time, etc.
        // ...
        public Item(/*...*/) { /*...*/ }
    }

    // The core greedy logic
    public Result solve(List<Item> items) {
        // 1. Pre-processing: Often involves sorting the items based on a greedy criterion.
        //    For example, sort by value/weight ratio, end time, etc.
        Collections.sort(items, (a, b) -> {
            // Custom comparator logic based on the greedy choice
            return /* comparison result */;
        });

        Result solution = new Result();

        // 2. Iteration: Loop through the sorted items.
        for (Item currentItem : items) {
            // 3. Greedy Choice: Decide if the current item can be added to the solution.
            if (isFeasible(currentItem, solution)) {
                // 4. Update Solution: Add the item and update the state.
                addToSolution(currentItem, solution);
            }
        }

        return solution;
    }

    // Helper methods specific to the problem
    private boolean isFeasible(Item item, Result currentSolution) { /*...*/ return true; }
    private void addToSolution(Item item, Result currentSolution) { /*...*/ }
    
    // Placeholder for the result structure
    static class Result { /*...*/ }
}
```

-----

## Operations with Syntax

Let's use the **Activity Selection Problem** as an example. The goal is to select the maximum number of non-overlapping activities from a set of activities, each with a start and end time.

The greedy choice is to **always pick the next activity that finishes earliest**.

```java
import java.util.*;

class Activity {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection {

    public static List<Activity> selectActivities(List<Activity> activities) {
        // 1. Sort activities based on their finish times in ascending order.
        activities.sort(Comparator.comparingInt(a -> a.end));

        List<Activity> result = new ArrayList<>();
        if (activities.isEmpty()) {
            return result;
        }

        // 2. Select the first activity.
        Activity lastSelected = activities.get(0);
        result.add(lastSelected);

        // 3. Iterate through the remaining activities.
        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            
            // 4. If the current activity starts after or at the same time the last one finishes, select it.
            if (currentActivity.start >= lastSelected.end) {
                result.add(currentActivity);
                lastSelected = currentActivity;
            }
        }
        return result;
    }
}
```

-----

## Time Complexity of the Operations

The time complexity of a greedy algorithm is typically determined by two main parts: the sorting step and the iteration step.

  * **Sorting**: The dominant part is usually sorting the input items. Using a comparison-based sort like `Collections.sort()` in Java, this takes $O(N \\log N)$ time, where $N$ is the number of items.
  * **Iteration**: After sorting, the algorithm usually iterates through the items once. This takes $O(N)$ time.

Therefore, the overall time complexity is **$O(N \\log N)$**. If the input is already sorted, the complexity reduces to **$O(N)$**.

-----

## Patterns

Greedy algorithms are effective for problems that exhibit two key properties:

1.  **Greedy Choice Property**: A globally optimal solution can be arrived at by making a locally optimal choice.
2.  **Optimal Substructure**: An optimal solution to the problem contains within it optimal solutions to subproblems.

Common problems that can be solved using a greedy approach include:

  * **Activity Selection Problem**: Choose the maximum number of non-overlapping activities.
  * **Fractional Knapsack**: Maximize the value of items in a knapsack where you can take fractions of items.
  * **Huffman Coding**: Create a prefix-free binary code with minimum expected length.
  * **Dijkstra's Shortest Path Algorithm**: Find the shortest path from a source vertex to all other vertices in a weighted graph.
  * **Prim's and Kruskal's Algorithms**: Find the Minimum Spanning Tree (MST) of a graph.
  * **Job Sequencing with Deadlines**: Maximize profit by scheduling jobs, each with a deadline and a profit.


-----

## Common Questions

### **Maximum Subarray**
This is solved with Kadane's algorithm. The greedy choice at each step is to either extend the previous subarray by adding the current number or to start a new subarray beginning with the current number, whichever is larger.

### **Jump Game**
The greedy strategy is to always maximize your reach. As you iterate through the array, you keep track of the farthest index you can possibly get to. At each position, you make the jump that extends this maximum reach.

### **Jump Game II**
This is also greedy. For each jump, you explore all the positions you can currently reach and find the one that allows you to jump the farthest in the *next* move. This ensures you cover the maximum distance with each jump, minimizing the total number of jumps.

### **Gas Station**
The greedy approach involves a single pass. If your total gas in the tank becomes negative at any point, you know that no starting position up to that point could have worked. So, you greedily try the next station as a new potential starting point.

### **Hand of Straights**
A greedy solution works well here. First, count the card frequencies. Then, repeatedly find the smallest card number available and greedily form a consecutive group starting with that card. If you can't form a group at any point, it's impossible.

### **Merge Triplets to Form Target Triplet**
The greedy choice is to first discard any triplet that has a value larger than the target in any position. Then, you iterate through the remaining "good" triplets and greedily merge them by taking the maximum value at each position to build towards the target.

### **Partition Labels**
This uses a greedy strategy where you extend the current partition to include the last occurrence of every character within that partition. Once your pointer reaches the end of the current partition's boundary, you cut it off and start a new one.

### **Valid Parenthesis String**
A greedy approach tracks the possible range of open parentheses `[min, max]`. At each step, you make the choices for the wildcard `*` that are most likely to keep the string valid (i.e., using it as `(` for the max count and `)` for the min count).

-----

## Advantages and Disadvantages

### ✅ Advantages

  * **Simplicity**: Greedy algorithms are often easier to design and implement than other paradigms like dynamic programming or backtracking.
  * **Efficiency**: They are generally very fast, often having a time complexity of $O(N \\log N)$ due to sorting, and sometimes linear time $O(N)$.
  * **Low Space Complexity**: They typically require less memory as they don't need to store solutions to subproblems extensively.

### ❌ Disadvantages

  * **Not Always Optimal**: The main drawback is that they do not guarantee a globally optimal solution for all problems. A locally optimal choice might prevent reaching the global optimum. (e.g., 0/1 Knapsack problem cannot be solved greedily).
  * **Proof of Correctness**: It can be difficult to prove that a greedy choice will lead to the optimal solution. For any greedy algorithm, a proof of correctness is required.
  * **Short-sighted**: By focusing only on the immediate best choice, the algorithm may miss a better long-term solution.