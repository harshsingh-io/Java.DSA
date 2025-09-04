### **HashSet: DSA Short Notes**

A HashSet is a collection that stores unique elements. It's an implementation of the `Set` interface, backed by a hash table (specifically, a `HashMap` instance). It makes no guarantees concerning the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. It permits the `null` element.

-----

## **Syntax (Java)**

To use `HashSet`, you need to import `java.util.HashSet`.

```java
import java.util.HashSet;
import java.util.Set;

// General Declaration and Initialization
Set<DataType> setName = new HashSet<>();

// Example with Strings
Set<String> fruits = new HashSet<>();
```

-----

## **Common Operations**

Here are the fundamental operations for a `HashSet`.

  * **Add an element:** Adds the specified element to the set if it's not already present.
    ```java
    fruits.add("Apple"); // returns true
    fruits.add("Apple"); // returns false, as "Apple" is already in the set
    ```
  * **Remove an element:** Removes the specified element from the set if it is present.
    ```java
    fruits.remove("Banana"); // returns true if "Banana" was in the set
    ```
  * **Check for an element:** Returns `true` if the set contains the specified element.
    ```java
    boolean hasApple = fruits.contains("Apple"); // returns true
    ```
  * **Get the size:** Returns the number of elements in the set.
    ```java
    int size = fruits.size();
    ```
  * **Iterate over the set:**
    ```java
    // Using an enhanced for-loop (preferred)
    for (String fruit : fruits) {
        System.out.println(fruit);
    }
    ```
  * **Clear the set:** Removes all elements from the set.
    ```java
    fruits.clear();
    ```

-----

## **Time Complexity**

The performance of a `HashSet` is heavily dependent on the hash function of its elements. Assuming a good hash function that distributes elements uniformly, the complexity is:

| Operation | Average Time | Worst Case |
|-----------|--------------|------------|
| Add       | O(1)         | O(n)       |
| Remove    | O(1)         | O(n)       |
| Contains  | O(1)         | O(n)       |
| Size      | O(1)         | O(1)       |
| isEmpty   | O(1)         | O(1)       |
| Iteration | O(n)         | O(n)       |

-----

## **Common Patterns**

`HashSet` is ideal for problems where uniqueness is key and order is not. 💡

  * **Finding Duplicates:** The most common pattern. You can iterate through a collection and use a `HashSet` to track which elements you've already seen.
    ```java
    // Example: Find if an array has duplicates
    int[] nums = {1, 2, 3, 1};
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
        if (!seen.add(num)) { // .add() returns false if element exists
            System.out.println("Duplicate found: " + num);
            break;
        }
    }
    ```
  * **Set Operations:** Performing mathematical set operations like **union**, **intersection**, and **difference**.
      * **Union:** `setA.addAll(setB);`
      * **Intersection:** `setA.retainAll(setB);`
      * **Difference:** `setA.removeAll(setB);`
  * **Data Uniqueness:** Use it to get all unique items from a list.
    ```java
    List<String> listWithDuplicates = Arrays.asList("A", "B", "A");
    Set<String> uniqueSet = new HashSet<>(listWithDuplicates); // uniqueSet contains {"A", "B"}
    ```

-----

## **Common Questions**

* **Contains Duplicate**: Use a hash set to track seen numbers in a single pass.
* **Valid Sudoku**: Use hash sets to track the numbers seen in each row, column, and 3x3 sub-grid.
* **Longest Consecutive Sequence**: Use a hash set to store all numbers, allowing for O(1) checks to find the start and length of sequences.

-----

## **Advantages and Disadvantages**

### **Advantages 👍**

  * **Fast Lookups:** Offers constant time complexity $O(1)$ on average for `add`, `remove`, and `contains` operations.
  * **Enforces Uniqueness:** Automatically prevents duplicate elements from being added.
  * **Memory Efficient for Uniqueness:** Uses less memory than other approaches for simply tracking seen items.

### **Disadvantages 👎**

  * **Unordered:** Provides no guarantee on the order of elements. If you need insertion order, use `LinkedHashSet`. If you need natural sorting order, use `TreeSet`.
  * **No Index-Based Access:** You cannot retrieve an element by its index (e.g., `get(i)`), as there is no defined order. You must iterate to access elements.
  * **Performance Degradation:** In the rare worst case of frequent hash collisions, performance can drop to $O(n)$.