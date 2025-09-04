A HashMap is a data structure that stores data as **key-value pairs**. It uses a technique called **hashing** to compute an index where an element is stored, allowing for very fast retrieval, insertion, and deletion of data. Keys in a HashMap must be unique. It's a part of the Java Collections Framework and does not maintain the order of insertion.

-----

## Syntax (Java)

To use a HashMap, you first need to import it from the `java.util` package.

```java
import java.util.HashMap;

// Declaration and Initialization
HashMap<KeyType, ValueType> mapName = new HashMap<>();

// Example with String keys and Integer values
HashMap<String, Integer> studentScores = new HashMap<>();
```

-----

## Operations with Syntax

Here are the most common operations performed on a HashMap:

  * **Add/Update an element:** Associates the specified value with the specified key. If the key already exists, the old value is replaced.

    ```java
    studentScores.put("Alice", 95); // Adds a new entry
    studentScores.put("Alice", 98); // Updates the value for "Alice"
    ```

  * **Access an element:** Retrieves the value to which the specified key is mapped. Returns `null` if the key is not found.

    ```java
    Integer score = studentScores.get("Alice"); // returns 98
    ```

  * **Remove an element:** Removes the mapping for a key.

    ```java
    studentScores.remove("Bob");
    ```

  * **Check for a key:** Returns `true` if the map contains a mapping for the specified key.

    ```java
    boolean hasAlice = studentScores.containsKey("Alice"); // returns true
    ```

  * **Get the size:** Returns the number of key-value mappings.

    ```java
    int size = studentScores.size();
    ```

  * **Iterate over the map:**

    ```java
    // Iterate over keys
    for (String name : studentScores.keySet()) {
        System.out.println("Key: " + name);
    }

    // Iterate over values
    for (Integer value : studentScores.values()) {
        System.out.println("Value: " + value);
    }

    // Iterate over key-value pairs (entries)
    for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }
    ```

-----

## Time Complexity of the Operations

The performance of a HashMap is heavily dependent on its hash function, which should distribute elements uniformly across buckets.

| Operation | Average Case | Worst Case |
|-----------|--------------|------------|
| `put` | $O(1)$ | $O(n)$ |
| `get` | $O(1)$ | $O(n)$ |
| `remove` | $O(1)$ | $O(n)$ |
| `containsKey` | $O(1)$ | $O(n)$ |

> **Note:** The worst case occurs when all keys hash to the same bucket (a hash collision), and the elements in that bucket are stored in a list.


> 📝 **Note:** Since Java 8, the worst-case time complexity has been improved from $O(n)$ to $O(\\log n)$ for buckets that grow too large by replacing the linked list with a balanced binary search tree.

-----

## Patterns

HashMaps are incredibly versatile and are a go-to solution for many common coding problems. 🗺️

  * **Frequency Counting:** Used to count the occurrences of items in a collection. For example, counting character frequencies in a string or numbers in an array.
  * **Two-Sum Problem:** Storing array elements and their indices in a map to quickly check if `target - current_element` exists.
  * **Caching/Memoization:** Storing the results of expensive computations to avoid recalculating them for the same inputs.
  * **Checking for Duplicates:** Efficiently determining if an element has been seen before while iterating through a list or array.
  * **Grouping Anagrams:** Grouping words that are anagrams of each other by using a sorted version of the word as the key.

-----

## Common Questions:


* **Valid Anagram**: Use a hash map (or a frequency array) to count character occurrences.
* **Two Sum**: Use a hash map to store numbers and their indices to find the required complement in O(1) time.
* **Group Anagrams**: Use a hash map where keys are a canonical representation (e.g., sorted string) of anagrams.
* **Top K Frequent Elements**: Use a hash map to count frequencies, followed by a bucket sort or a heap. The initial frequency counting is the key hashing step.

-----

## Advantages and Disadvantages

### ✅ Advantages

  * **Fast Operations:** Provides average-case constant time ($O(1)$) performance for insertion, deletion, and lookup.
  * **Flexible Keys:** Keys and values can be of any object type.
  * **Efficient Lookups:** Excellent for problems that require finding pairs or checking for the existence of an item.

### ❌ Disadvantages

  * **Unordered:** HashMaps do not maintain any order of elements. If you need insertion order, use `LinkedHashMap`. If you need keys to be sorted, use `TreeMap`.
  * **Memory Overhead:** Can consume more memory than arrays or lists due to the underlying array structure and the need to handle potential collisions.
  * **Worst-Case Performance:** Although rare with a good hash function, the worst-case $O(n)$ or $O(\\log n)$ performance can be a concern.