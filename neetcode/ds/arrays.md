# **Arrays**

## 1\. About Arrays

An array is a **linear data structure** that stores a collection of elements of the same data type in **contiguous memory locations**. Each element is identified by a unique, non-negative integer called an **index**, which typically starts at 0. Because of this indexed structure, arrays offer direct access to any of their elements. 💾

-----

## 2\. Syntax (Java)

In Java, arrays are objects. They need to be declared and then instantiated.

  * **Declaration:** Declares a variable that will hold a reference to an array.
    ```java
    dataType[] arrayName;
    ```
  * **Instantiation:** Creates the array in memory and specifies its size.
    ```java
    arrayName = new dataType[size];
    ```
  * **Declaration & Instantiation:** A common one-line approach.
    ```java
    dataType[] arrayName = new dataType[size];
    ```
  * **Initialization:** Declares, instantiates, and initializes the array with values in a single statement.
    ```java
    dataType[] arrayName = {value1, value2, ...};
    ```
    **Example:**
    ```java
    // Declares and instantiates an integer array of size 5
    int[] numbers = new int[5];

    // Initializes a string array with three elements
    String[] fruits = {"Apple", "Banana", "Cherry"};
    ```

-----

## 3\. Operations with Syntax

  * **Access:** Retrieve the value at a specific index.
    ```java
    // Accesses the element at index 1 ("Banana")
    String fruit = fruits[1];
    ```
  * **Update/Modify:** Change the value at a specific index.
    ```java
    // Changes the element at index 0 to "Mango"
    fruits[0] = "Mango";
    ```
  * **Get Length/Size:** Find the number of elements the array can hold.
    ```java
    int arrayLength = fruits.length; // Result is 3
    ```
  * **Search (Linear):** Iterate through the array to find an element.
    ```java
    for (int i = 0; i < fruits.length; i++) {
        if (fruits[i].equals("Banana")) {
            System.out.println("Found at index: " + i); // Prints "Found at index: 1"
            break;
        }
    }
    ```
  * **Insertion/Deletion:** Not directly supported. These operations require creating a new array and manually copying elements, as the size of an array is fixed.

-----

## 4\. Time Complexity of Operations

The efficiency of array operations is measured using Big O notation.

| Operation | Time Complexity | Description |
|-----------|----------------|-------------|
| Access by Index | $O(1)$ | Constant |
| Update by Index | $O(1)$ | Constant |
| Search (Linear Search) | $O(n)$ | Linear |
| Search (Binary Search) | $O(\log n)$ | Logarithmic - requires sorted array |
| Insertion | $O(n)$ | Linear - requires shifting elements |
| Deletion | $O(n)$ | Linear - requires shifting elements |

-----

## 5\. Common Patterns

Arrays are fundamental to many algorithmic patterns.

  * **Two Pointers:** Using two indices to traverse the array from different points (e.g., finding pairs, reversing an array).
  * **Sliding Window:** Using a subarray (window) of a fixed or variable size that slides over the array to solve problems (e.g., finding the maximum sum of a subarray).
  * **Prefix Sum:** Pre-calculating sums up to each index to quickly find the sum of any given range `[i...j]`.
  * **Kadane's Algorithm:** An efficient dynamic programming approach to find the maximum sum of a contiguous subarray.
  * **Frequency Count:** Using an auxiliary array (or a hash map) to count the occurrences of elements.

-----

## 6\. Common Questions:

* **Product of Array Except Self**: Solved by creating prefix and postfix product arrays and combining them. This is a classic array manipulation problem.
* **Encode and Decode Strings**: This problem relies on list/array manipulation and a specific string format (e.g., `length#string`) to serialize and deserialize the data. No hashing is required.

-----

## 7\. Advantages and Disadvantages

### ✅ Advantages

  * **Fast Random Access:** Accessing any element by its index takes constant time, $O(1)$.
  * **Cache Friendliness:** Elements are stored in contiguous memory blocks, leading to better cache performance and faster iteration compared to linked data structures.
  * **Simplicity:** Easy to create and use for a known number of elements.

### ❌ Disadvantages

  * **Fixed Size:** The size of an array is determined at creation and cannot be changed. If you need a dynamic size, you must create a new array and copy data.
  * **Inefficient Insertion/Deletion:** Adding or removing elements from anywhere other than the end is slow ($O(n)$) because it requires shifting all subsequent elements.
  * **Homogeneous:** An array can only store elements of the same data type.