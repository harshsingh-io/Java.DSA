# TreeMap

A `TreeMap` in Java is a sorted map implementation that stores key-value pairs. It's based on a **Red-Black Tree**, which is a self-balancing binary search tree. This structure ensures that the keys are always kept in a sorted order, either natural ordering or a custom order defined by a `Comparator`.

-----

## 1\. About the Data Structure

A `TreeMap` is a part of the Java Collections Framework and implements the `SortedMap` interface. Unlike a `HashMap`, which is unordered, a `TreeMap` maintains its entries in ascending key order. It does not allow `null` keys (though `null` values are permitted). Because it's based on a tree structure, it provides efficient retrieval of elements in a sorted manner.

-----

## 2\. Syntax (Java)

You can declare and initialize a `TreeMap` in a couple of ways:

  * **Using natural ordering of keys:**

    ```java
    import java.util.TreeMap;
    import java.util.Map;

    // The keys must implement the Comparable interface (e.g., Integer, String).
    Map<KeyType, ValueType> treeMap = new TreeMap<>();
    ```

  * **Using a custom `Comparator`:**

    ```java
    import java.util.TreeMap;
    import java.util.Map;
    import java.util.Comparator;

    // Provide a Comparator to define a custom sorting logic for the keys.
    Map<KeyType, ValueType> treeMapWithComparator = new TreeMap<>(Comparator.reverseOrder());
    ```

-----

## 3\. Operations with Syntax

Here are the most common operations performed on a `TreeMap`:

| Operation           | Syntax                                          | Description                                                 |
| ------------------- | ----------------------------------------------- | ----------------------------------------------------------- |
| **Add/Update Entry** | `treeMap.put(key, value);`                      | Inserts a new key-value pair or updates the value if the key exists. |
| **Get Value** | `treeMap.get(key);`                             | Retrieves the value associated with the specified key.      |
| **Remove Entry** | `treeMap.remove(key);`                          | Removes the entry for the specified key.                    |
| **Check for Key** | `treeMap.containsKey(key);`                     | Returns `true` if the map contains the specified key.       |
| **Check for Value** | `treeMap.containsValue(value);`                | Returns `true` if the map contains the specified value.     |
| **Get Size** | `treeMap.size();`                               | Returns the number of key-value pairs in the map.           |
| **Get First Key** | `treeMap.firstKey();`                           | Returns the first (lowest) key in the sorted map.           |
| **Get Last Key** | `treeMap.lastKey();`                            | Returns the last (highest) key in the sorted map.           |
| **Get Sub-Map** | `treeMap.subMap(fromKey, toKey);`                | Returns a view of the portion of this map whose keys range from `fromKey`, inclusive, to `toKey`, exclusive. |

-----

## 4\. Time Complexity

The performance of `TreeMap` operations is directly related to the height of the underlying Red-Black Tree.

  * **Add, Remove, Get, Contains Key (`put`, `remove`, `get`, `containsKey`)**: $O(\\log n)$

      * These operations require traversing the tree from the root to the target node, which takes logarithmic time because the tree is balanced.

  * **Get First/Last Key (`firstKey`, `lastKey`)**: $O(\\log n)$

      * Finding the minimum or maximum element also involves traversing down one side of the tree.

  * **Contains Value (`containsValue`)**: $O(n)$

      * There's no efficient way to search by value, so the entire map must be traversed.

  * **Space Complexity**: $O(n)$

      * The space required is proportional to the number of key-value pairs stored.

Here, '$n$' is the number of key-value pairs in the `TreeMap`.

-----

## 5\. Patterns

`TreeMap` is particularly useful in scenarios where you need to maintain sorted keys or perform operations based on the order. 🗺️

  * **Sorted Dictionaries**: Implementing a dictionary or a phone book where you need to list entries alphabetically.
  * **Range Queries**: Finding all entries within a specific range of keys (e.g., all employees with IDs between 100 and 200) using `subMap()`.
  * **Leaderboards/Rankings**: Storing scores and participants, where you can easily find the highest or lowest score using `firstKey()` or `lastKey()`.
  * **Scheduling Systems**: Managing events or appointments sorted by time, allowing for easy retrieval of the next or previous event.
  * **Finding Ceilings/Floors**: Locating the smallest key greater than or equal to a given key (`ceilingKey()`) or the largest key less than or equal to a given key (`floorKey()`).

-----

## 6\. Advantages and Disadvantages

### Advantages ✅

  * **Sorted Order**: Automatically keeps keys sorted, which is its primary advantage.
  * **Efficient Search for Sorted Data**: Provides efficient retrieval ($O(\\log n)$) of keys, values, and entries.
  * **Navigable Operations**: Offers powerful methods for navigation like `subMap()`, `headMap()`, `tailMap()`, `ceilingKey()`, and `floorKey()`.
  * **Reliable Performance**: The balanced tree structure guarantees consistent $O(\\log n)$ performance, avoiding the worst-case scenarios of unbalanced trees.

### Disadvantages ❌

  * **Slower than HashMap**: For basic operations like insertion, deletion, and lookup, `TreeMap` is slower than `HashMap`, which provides average $O(1)$ time complexity.
  * **Higher Memory Usage**: A `TreeMap` node stores keys, values, and pointers to its parent and child nodes, consuming more memory than a `HashMap` entry.
  * **No Null Keys**: It does not permit `null` keys, as it cannot compare them for sorting, which can be restrictive in some use cases.