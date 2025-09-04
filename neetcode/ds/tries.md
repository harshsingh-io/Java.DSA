### **1. About Tries**

A **Trie** (pronounced "try"), also known as a **prefix tree**, is a tree-based data structure used for storing and retrieving a dynamic set of strings. In a Trie, nodes do not store keys themselves. Instead, a node's position in the tree defines the key it's associated with. Each path from the root to a node represents a common prefix, and nodes have a special flag to indicate the end of a complete word. 🌳

-----

### **2. Syntax (Java)**

A Trie is typically implemented with two classes: a `TrieNode` to represent each character and a `Trie` class to manage the overall structure.

```java
// Represents a single node in the Trie
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        // Assuming only lowercase 'a'-'z' characters
        children = new TrieNode[26]; 
        isEndOfWord = false;
    }
}

// The main Trie class
class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    // Operations will be defined here...
}
```

-----

### **3. Operations with Syntax**

The primary operations are inserting a word, searching for a complete word, and checking if any word starts with a given prefix.

  * **Insert**: Adds a word to the Trie.

    ```java
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    ```

  * **Search**: Checks if a complete word exists in the Trie.

    ```java
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    ```

  * **Starts With**: Checks if there is any word in the Trie that starts with the given prefix.

    ```java
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
    ```

-----

### **4. Time Complexity**

The efficiency of Trie operations depends on the length of the key (word or prefix), not the number of keys in the Trie.

Let $L$ be the length of the string being processed.

  * **Insertion**: $O(L)$
  * **Search**: $O(L)$
  * **Starts With**: $O(L)$
  * **Space Complexity**: $O(C \\times L\_{avg} \\times N)$, where $C$ is the alphabet size (e.g., 26), $L\_{avg}$ is the average length of keys, and $N$ is the number of keys. In the worst case, it's proportional to the total number of characters in all words.

-----

### **5. Patterns**

Tries are ideal for problems involving prefixes or sets of strings.

  * **Autocomplete/Search Suggestions**: Suggesting words as a user types.
  * **Spell Checkers & Dictionaries**: Efficiently storing a dictionary for lookup.
  * **IP Routing**: Finding the longest prefix match in routing tables.
  * **Bioinformatics**: Storing and searching DNA sequences.
  * **Maximum XOR Pair**: Using a binary Trie (alphabet of {0, 1}) to find two numbers in a set with the maximum XOR value.

-----

### **6. Common Question**

### Implement Trie (Prefix Tree)
This is the most fundamental problem. You are asked to build the Trie data structure from scratch, implementing its core functionalities: `insert`, `search` (for a whole word), and `startsWith` (for a prefix).

### Design Add and Search Words Data Structure
This is a variation of the standard Trie. You build a Trie to store words, but the search functionality is enhanced to handle the `.` wildcard character. This requires a modified search algorithm that can explore multiple branches of the Trie simultaneously.

### Word Search II
This is an advanced problem that combines a **Trie** with a **Depth-First Search (DFS)**. The most efficient solution involves first inserting all the target words into a Trie. Then, you perform a DFS on the grid, traversing the Trie at the same time. The Trie allows you to instantly prune any search path that doesn't match a valid prefix, making the solution much faster than searching for each word individually.

-----

### **7. Advantages and Disadvantages**

#### **Advantages 👍**

  * **Fast Lookups**: Searching for a word is very fast, with a time complexity of $O(L)$, making it faster than unbalanced BSTs and independent of the dictionary size.
  * **Efficient Prefix Search**: Finding all keys with a common prefix is highly efficient.
  * **No Collisions**: Unlike hash tables, Tries don't have key collisions.
  * **Alphabetical Ordering**: Tries can naturally store strings in alphabetical order.

#### **Disadvantages 👎**

  * **High Memory Usage**: Each node may store an array of pointers for every character in the alphabet, which can lead to significant memory consumption, especially if the Trie is sparse.
  * **Not Ideal for All Data**: Tries are specialized for string-like data and are not a general-purpose replacement for other data structures like hash maps.