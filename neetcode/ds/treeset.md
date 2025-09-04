# TreeSet

A `TreeSet` is a class in the Java Collections Framework that implements the `Set` and `NavigableSet` interfaces. It stores unique elements in a sorted order (either natural ordering or by a custom `Comparator`). It is backed by a `TreeMap`, which is a Red-Black Tree implementation. 🌲

-----

## 1\. About the TreeSet

A **`TreeSet`** is a sorted collection that does not allow duplicate elements. It uses a self-balancing binary search tree (specifically, a Red-Black Tree in Java) to store elements. This structure ensures that the elements are always in a sorted order, which allows for efficient retrieval operations based on their order.

-----

## 2\. Syntax (Java)

You can create a `TreeSet` in two primary ways:

  * **Using natural ordering:** The elements must implement the `Comparable` interface.

    ```java
    import java.util.TreeSet;
    import java.util.Set;

    // Creates an empty TreeSet sorted according to the natural ordering of its elements.
    Set<Integer> numbers = new TreeSet<>();
    ```

  * **Using a custom `Comparator`:** Provide a `Comparator` at creation time to define a custom sorting logic.

    ```java
    import java.util.Comparator;
    import java.util.TreeSet;
    import java.util.Set;

    // Creates a TreeSet sorted in descending order.
    Set<Integer> descendingNumbers = new TreeSet<>(Comparator.reverseOrder());
    ```

-----

## 3\. Operations with Syntax

Here are the fundamental operations for a `TreeSet`:

  * **Add an element:** `add(E element)`
    ```java
    numbers.add(10); // Returns true if the element was added, false if it already exists.
    ```
  * **Remove an element:** `remove(Object element)`
    ```java
    numbers.remove(10); // Returns true if the element was present and removed.
    ```
  * **Check for an element:** `contains(Object element)`
    ```java
    boolean hasTen = numbers.contains(10); // Returns true if the set contains the element.
    ```
  * **Get the size:** `size()`
    ```java
    int count = numbers.size(); // Returns the number of elements in the set.
    ```
  * **Get first/last element:** `first()` / `last()`
    ```java
    Integer smallest = numbers.first();
    Integer largest = numbers.last();
    ```
  * **Get elements based on order:** `lower(E e)` / `higher(E e)`
    ```java
    // Get the greatest element strictly less than e
    Integer lowerNum = numbers.lower(15);
    // Get the least element strictly greater than e
    Integer higherNum = numbers.higher(15);
    ```
  * **Clear the set:** `clear()`
    ```java
    numbers.clear(); // Removes all elements from the set.
    ```

-----

## 4\. Time Complexity

The performance of `TreeSet` is logarithmic due to its underlying tree structure.

| Operation            | Time Complexity   |
| -------------------- | ----------------- |
| `add(E element)`     | $O(\\log n)$       |
| `remove(Object o)`   | $O(\\log n)$       |
| `contains(Object o)` | $O(\\log n)$       |
| `size()`             | $O(1)$            |
| `first()`, `last()`  | $O(\\log n)$       |
| `lower(E e)`         | $O(\\log n)$       |
| `higher(E e)`        | $O(\\log n)$       |

Here, **n** is the number of elements in the `TreeSet`.

-----

## 5\. Patterns

`TreeSet` is particularly useful in scenarios that require both uniqueness and order.

  * **Maintaining a Sorted Collection:** When you need to keep a list of unique items (like user scores, timestamps) sorted at all times.
  * **Finding the Kth Element:** Efficiently finding the k-th smallest or largest element.
  * **Range Queries:** Finding all elements within a specific range using methods like `subSet()`, `headSet()`, and `tailSet()`.
  * **Finding Ceilings and Floors:** Quickly finding the nearest element that is greater than or equal to (`ceiling()`) or less than or equal to (`floor()`) a given value.

-----

## 6\. Advantages and Disadvantages

### Advantages ✅

  * **Sorted Order:** Elements are automatically kept in sorted order, which is useful for many algorithms.
  * **No Duplicates:** Enforces uniqueness of elements, just like any `Set`.
  * **Efficient Lookups:** Provides fast ($O(\\log n)$) search, insertion, and deletion.
  * **Navigable Operations:** Offers powerful methods like `lower`, `higher`, `floor`, and `ceiling` for order-based retrieval.

### Disadvantages ❌

  * **Slower than HashSet:** Basic operations ($O(\\log n)$) are slower than `HashSet`'s average time complexity of $O(1)$.
  * **Higher Memory Usage:** The tree structure requires more memory overhead compared to a `HashSet`.
  * **Ordering Requirement:** Elements must be comparable (implement `Comparable`) or a `Comparator` must be provided. Attempting to add non-comparable objects will result in a `ClassCastException`.