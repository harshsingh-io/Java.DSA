# **A Computer Scientist's Guide to Graphs: From Theory to FAANG Interview Success**

## **Introduction: Deconstructing Graph Problems**

Graphs are arguably the most versatile data structure in computer science, providing a powerful abstraction for modeling networks and relationships. Their prevalence in real-world systems—from the social connections on Facebook to the routing of internet traffic and the logistics of global supply chains—makes them a cornerstone of modern software engineering and a frequent, often challenging, topic in technical interviews at top-tier companies. Success in these interviews hinges not on rote memorization of algorithms, but on developing a deep, intuitive understanding that allows for rapid pattern recognition. The ability to look at a problem description, abstract it into a graph model, and select the optimal algorithm from a well-understood toolkit is the hallmark of an expert engineer.

This guide is structured to build that expertise. It moves from foundational concepts to advanced algorithms, always with an eye toward practical application and the strategic decision-making required in a high-pressure interview setting.

### **1. About the Graph Data Structure**

At its core, a graph is an abstract data type (ADT) designed to represent connections between objects.

#### **Formal Definition**

Formally, a graph G is defined as an ordered pair of sets, G=(V,E), where:

* V is a finite set of **vertices** (also called nodes or points).  
* E is a set of **edges** (also called links or arcs), where each edge is a pair of vertices from V.

This formal definition is the precise language expected in a technical discussion. It cleanly separates the entities (vertices) from their relationships (edges).

#### **Core Terminology**

A shared vocabulary is essential for discussing graph problems. The following terms are fundamental:

* **Vertex (or Node):** An individual object or point in the graph. In a social network graph, a vertex could represent a user.  
* **Edge (or Link/Arc):** A connection between two vertices. An edge represents a relationship, such as a friendship between two users.  
* **Adjacency:** Two vertices are considered **adjacent** if they are directly connected by an edge.  
* **Path:** A sequence of edges that connects a sequence of vertices. For example, a path from vertex A to D might be A → B → C → D.  
* **Cycle:** A path that starts and ends at the same vertex, and contains at least one edge. The presence or absence of cycles is a critical property of a graph that dictates which algorithms can be applied.  
* **Degree:** The number of edges incident to a vertex. In **directed graphs**, this is further specified:  
  * **In-degree:** The number of incoming edges.  
  * **Out-degree:** The number of outgoing edges.

#### **A Comprehensive Typology of Graphs**

The constraints and properties described in a problem statement are not mere details; they are powerful signals that guide algorithm selection. Recognizing the type of graph is the first step in pattern recognition.

* **Directed vs. Undirected Graphs:** This is the most fundamental classification.  
  * **Undirected Graph:** Edges have no direction. An edge (u,v) implies a symmetric, bidirectional relationship; if u is connected to v, then v is connected to u. Social networks are often modeled this way.  
  * **Directed Graph (Digraph):** Edges have a direction, represented by an arrow. An edge (u,v) represents a one-way relationship from u to v. Following a link on a webpage or a dependency where task u must be completed before task v are examples.  
* **Weighted vs. Unweighted Graphs:** This distinction relates to the "cost" of traversing an edge.  
  * **Unweighted Graph:** All edges are considered equal. The "length" of a path is simply the number of edges.  
  * **Weighted Graph:** Each edge is assigned a numerical weight, which can represent cost, distance, time, or capacity. A map of cities where edge weights are the driving distances between them is a classic example. The nature of these weights (e.g., positive, negative) is a crucial factor in choosing a shortest path algorithm.  
* **Cyclic vs. Acyclic Graphs:**  
  * **Cyclic Graph:** Contains at least one cycle. Most general graphs fall into this category.  
  * **Acyclic Graph:** Contains no cycles. A **tree** is a special type of connected, undirected acyclic graph. A **Directed Acyclic Graph (DAG)** is a directed graph with no directed cycles. DAGs are exceptionally important for modeling dependencies and scheduling tasks, and they have a unique set of applicable algorithms.

A common pitfall in interviews is to mistake a general graph for a tree. A graph might be drawn to look like a tree, but if it contains a cycle, a simple recursive traversal without tracking visited nodes will lead to an infinite loop and a stack overflow error. A tree is a constrained form of a graph—specifically, it is connected and acyclic. This implies that any algorithm designed for a general graph must incorporate a mechanism, typically a visited set or array, to handle potential cycles. An interviewer may specifically test this by presenting a cyclic graph that appears tree-like to see if the candidate writes robust code.

* **Other Important Types:**  
  * **Connected Graph:** An undirected graph where there is a path between every pair of vertices. If not, it is a **Disconnected Graph**.  
  * **Complete Graph:** A simple graph where every pair of distinct vertices is connected by a unique edge.  
  * **Bipartite Graph:** A graph whose vertices can be divided into two disjoint and independent sets, U and V, such that every edge connects a vertex in U to one in V.

### **7. Advantages and Disadvantages of Graphs**

Graphs are a powerful tool, but like any data structure, they come with trade-offs.

#### **Advantages**

* **Modeling Complex Relationships:** Graphs are unparalleled in their ability to represent intricate, non-hierarchical relationships between entities, making them ideal for modeling systems like social networks, computer networks, and logistical chains.  
* **Powerful Analytical Tools:** A rich body of graph algorithms exists for analyzing these relationships, enabling critical functionalities like finding the shortest path, identifying influential nodes, detecting communities, and optimizing network flow.  
* **Visual Intuition:** The visual nature of graphs helps in understanding and communicating complex systems and data patterns that might be opaque in other representations.

#### **Disadvantages**

* **Complexity and Memory:** Storing and processing graphs can be complex and memory-intensive. For a dense graph with many edges, the memory footprint can become a significant issue.  
* **Computational Cost:** Many graph algorithms, while powerful, can be computationally expensive. Traversing a large graph or finding all-pairs shortest paths can be time-consuming, posing challenges for real-time applications.  
* **Implementation Overhead:** Unlike arrays or linked lists, graphs are not a primitive data structure in most languages. Implementing a graph representation and its associated algorithms requires careful design and coding.

## **Part I: Foundational Representations and Operations**

Before any algorithm can be executed, the abstract concept of a graph must be translated into a concrete data structure in memory. This choice of representation is the first and most critical implementation decision, with profound implications for an algorithm's performance and complexity. The two canonical representations are the adjacency matrix and the adjacency list.

### **2. Syntax (Java): Graph Representations**

#### **Adjacency Matrix**

An adjacency matrix represents a graph as a two-dimensional V×V array, where V is the number of vertices. The entry matrix[i][j] indicates the relationship between vertex i and vertex j.

* For an **unweighted graph**, matrix[i][j] = 1 (or true) if an edge exists from i to j, and 0 (or false) otherwise.  
* For a **weighted graph**, matrix[i][j] stores the weight of the edge. A special value, such as infinity or 0, is used to indicate the absence of an edge.

For an undirected graph, the adjacency matrix is always symmetric (i.e., matrix[i][j] = matrix[j][i]).

**Java Implementation (Adjacency Matrix):**

```java
public class GraphAdjMatrix {  
    private int adjMatrix;  
    private int numVertices;

    // Initialize the matrix  
    public GraphAdjMatrix(int numVertices) {  
        this.numVertices = numVertices;  
        adjMatrix = new int[numVertices][numVertices];  
    }

    // Add edges  
    public void addEdge(int i, int j) {  
        // For an unweighted, undirected graph  
        adjMatrix[i][j] = 1;  
        adjMatrix[j][i] = 1;  
    }

    // Remove edges  
    public void removeEdge(int i, int j) {  
        adjMatrix[i][j] = 0;  
        adjMatrix[j][i] = 0;  
    }

    // Print the matrix  
    public void printGraph() {  
        for (int i = 0; i < numVertices; i++) {  
            for (int j = 0; j < numVertices; j++) {  
                System.out.print(adjMatrix[i][j] + " ");  
            }  
            System.out.println();  
        }  
    }  
}
```

#### **Adjacency List**

An adjacency list represents a graph as an array or map of lists. The entry at index i (or key i) contains a list of all vertices adjacent to vertex i. This is the most common representation used in coding interviews due to its space efficiency for sparse graphs.

Java Implementation (Adjacency List):  
A flexible and robust implementation uses a Map where keys are vertices and values are lists of their neighbors. This approach easily supports vertices with arbitrary labels (e.g., strings) beyond simple integer indices.

```Java
import java.util.*;

public class GraphAdjList<T> {  
    private Map<T, List<T>> adjList;

    public GraphAdjList() {  
        this.adjList = new HashMap<>();  
    }

    // Add a vertex  
    public void addVertex(T vertex) {  
        adjList.putIfAbsent(vertex, new ArrayList<>());  
    }

    // Add an edge (for undirected graph)  
    public void addEdge(T source, T destination) {  
        // Ensure both vertices exist in the graph  
        addVertex(source);  
        addVertex(destination);

        adjList.get(source).add(destination);  
        adjList.get(destination).add(source); // For undirected graph  
    }

    // Remove an edge  
    public void removeEdge(T source, T destination) {  
        if (adjList.containsKey(source)) {  
            adjList.get(source).remove(destination);  
        }  
        if (adjList.containsKey(destination)) {  
            adjList.get(destination).remove(source); // For undirected graph  
        }  
    }  
      
    // Get neighbors of a vertex  
    public List<T> getNeighbors(T vertex) {  
        return adjList.getOrDefault(vertex, Collections.emptyList());  
    }

    // Print the list  
    public void printGraph() {  
        for (T vertex : adjList.keySet()) {  
            System.out.print("Vertex " + vertex + " is connected to: ");  
            for (T neighbor : adjList.get(vertex)) {  
                System.out.print(neighbor + " ");  
            }  
            System.out.println();  
        }  
    }  
}
```

### **3. Operations with Syntax and 4. Time Complexity**

The choice of representation has a direct and significant impact on the performance of fundamental graph operations.

| Operation | Adjacency Matrix | Adjacency List | Adjacency Set (Optimized List) | When to Use |
| :---- | :---- | :---- | :---- | :---- |
| **Storage Space** | O(V2) | O(V+E) | O(V+E) | **Matrix:** Dense graphs (E≈V2). **List/Set:** Sparse graphs (E≪V2), which is the common case. |
| **Add Vertex** | O(V2) (resize matrix) | O(1) | O(1) | List/Set is far superior. Matrix requires reallocating and copying the entire structure. |
| **Remove Vertex** | O(V2) (resize matrix) | O(V+E) (must scan all lists) | O(V+E) | All are costly, but matrix is particularly bad. Removing from a list requires iterating through all other nodes' neighbor lists. |
| **Add Edge** | O(1) | O(1) | O(1) (amortized) | All are efficient. |
| **Remove Edge** | O(1) | O(degree(u)) | O(1) (amortized) | Matrix and Set are optimal. List requires a linear scan of the neighbor list. |
| **Check Adjacency (u, v)** | O(1) | O(degree(u)) | O(1) (amortized) | Matrix and Set are optimal. List is slow if this is a frequent operation. |
| **Find Neighbors(u)** | O(V) | O(degree(u)) | O(degree(u)) | List/Set are optimal. Matrix requires scanning an entire row. |

#### **Strategic Analysis of Representations**

In a FAANG interview context, the **Adjacency List is the default, correct choice** almost 100% of the time. The reasoning is straightforward: most graph problems involve some form of traversal (BFS, DFS) or an algorithm based on traversal (Dijkstra's, Prim's). The single most frequent operation in these algorithms is "get all neighbors of the current vertex." The adjacency list is optimized for this operation, providing neighbors in time proportional to the number of neighbors, O(degree(v)). The adjacency matrix is grossly inefficient here, requiring O(V) time to scan an entire row, regardless of how many neighbors a vertex actually has. Choosing a matrix for a traversal problem on a sparse graph would turn an optimal O(V+E) algorithm into a suboptimal O(V2) one, a mistake a top-tier candidate should not make.

A more advanced, senior-level point of discussion is the **"Adjacency Set"** optimization. By replacing the List<T> with a HashSet<T> in the adjacency list implementation (Map<T, Set<T>>), one can achieve the best of both worlds for sparse graphs. This structure retains the O(V+E) space efficiency and fast neighbor iteration of the adjacency list, while also gaining the O(1) average time complexity for checking edge existence and removing edges, a key advantage of the matrix. Mentioning this trade-off demonstrates a nuanced understanding of data structure performance beyond the textbook definitions.

## **Part II: Universal Graph Traversal Algorithms**

Breadth-First Search (BFS) and Depth-First Search (DFS) are the foundational algorithms for exploring a graph. They serve as the building blocks for many advanced algorithms and are the direct solution to a vast category of interview problems. The choice between them is not arbitrary; it is dictated by the structure of the problem itself.

### **Breadth-First Search (BFS): The Level-by-Level Explorer**

#### **1. About the Algorithm**

Breadth-First Search (BFS) is a traversal algorithm that explores a graph "layer by layer." It starts at a source vertex and explores all of its immediate neighbors. Then, for each of those neighbors, it explores their unvisited neighbors, and so on. This level-by-level exploration is managed using a **Queue** data structure, which follows a First-In, First-Out (FIFO) principle. Because it systematically expands outwards from the source, BFS is guaranteed to find the shortest path in terms of the number of edges in an **unweighted graph**.

#### **2. & 3. Syntax and Operations (Java)**

A standard iterative implementation of BFS is expected in interviews. It requires a queue to hold the nodes to visit next and a set or boolean array to keep track of nodes that have already been visited to prevent cycles and redundant processing.

```Java
import java.util.*;

public class BreadthFirstSearch {

    // Assumes a graph represented by an adjacency list  
    // Map<Integer, List<Integer>> graph;  
      
    public static void bfs(Map<Integer, List<Integer>> graph, int startNode) {  
        if (!graph.containsKey(startNode)) {  
            System.out.println("Start node not in graph.");  
            return;  
        }

        Queue<Integer> queue = new LinkedList<>();  
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);  
        visited.add(startNode);

        while (!queue.isEmpty()) {  
            int currentNode = queue.poll();  
            System.out.print(currentNode + " "); // Process the node

            List<Integer> neighbors = graph.getOrDefault(currentNode, Collections.emptyList());  
            for (int neighbor : neighbors) {  
                if (!visited.contains(neighbor)) {  
                    visited.add(neighbor);  
                    queue.add(neighbor);  
                }  
            }  
        }  
        System.out.println();  
    }  
}
```

#### **4. Time and Space Complexity**

* **Time Complexity:** O(V+E). Each vertex is enqueued and dequeued exactly once, which takes O(V) time in total. When a vertex is dequeued, its adjacency list is scanned once. Over the course of the algorithm, every edge is scanned exactly twice in an undirected graph (once from each endpoint) or once in a directed graph. Thus, the total time spent scanning edges is O(E).  
* **Space Complexity:** O(W), where W is the maximum width of the graph. In the worst-case scenario (a complete graph or a star graph), the queue may need to hold up to V−1 vertices at once. Therefore, the worst-case space complexity is O(V).

#### **5. Patterns**

The pattern for BFS is triggered by keywords related to finding the shortest path in an unweighted context.

* **Shortest Path in an Unweighted Graph:** This is the quintessential BFS pattern. If a problem asks for the "minimum number of steps," "fewest moves," "shortest path," or "shortest distance," and each step or edge has a uniform cost of 1, BFS is the optimal algorithm.  
* **Level-Order Traversal:** Any problem that requires processing the graph in distinct layers or levels, such as "find all nodes at distance k from a source," is a direct application of BFS's inherent structure.  
* **Matrix/Grid Traversal:** Many problems set in a 2D grid or maze, such as finding the shortest path from a start cell to an end cell while avoiding obstacles, can be modeled as an implicit graph. Each cell is a vertex, and adjacent (non-obstacle) cells are connected by edges. BFS is the perfect tool for these scenarios.

#### **6. Most Commonly Asked Questions**

* **Rotten Oranges (LeetCode 994):** A classic multi-source BFS problem. The goal is to find the minimum time for all fresh oranges to become rotten. The "time" is the distance from the nearest initial rotten orange. The solution involves adding all initially rotten oranges to the queue and running a single BFS to find the maximum of these shortest paths.  
* **Word Ladder (LeetCode 127):** Given two words and a dictionary, find the length of the shortest transformation sequence. This is a shortest path problem on an implicit graph where words are nodes, and an edge exists between two words if they differ by a single letter. BFS is used to explore this graph level by level.  
* **Snakes and Ladders (LeetCode 909):** Find the minimum number of dice rolls to win. Each square on the board is a node. A dice roll creates potential edges to the next 6 squares. Snakes and ladders are special edges that transport the player to a different node. Since each roll is one "step," this is a shortest path problem on an unweighted graph, ideal for BFS.

#### **7. Advantages and Disadvantages**

* **Advantages:** Guarantees finding the shortest path (in terms of edge count) in an unweighted graph. It is a "complete" algorithm, meaning it will find a solution if one exists.  
* **Disadvantages:** Can be memory-intensive, especially for wide graphs where the queue might need to store a large number of nodes simultaneously. It is not suitable for finding the shortest path in weighted graphs.

### **Depth-First Search (DFS): The Deep Dive Explorer**

#### **1. About the Algorithm**

Depth-First Search (DFS) explores a graph by going as deep as possible down one path before backtracking. When it hits a dead end or a previously visited node, it backtracks to the last decision point and explores the next available unvisited path. This behavior is naturally managed by a **Stack** data structure, which follows a Last-In, First-Out (LIFO) principle. This stack can be the program's implicit call stack (in a recursive implementation) or an explicit Stack object (in an iterative implementation).

#### **2. & 3. Syntax and Operations (Java)**

A strong candidate should be able to implement DFS both recursively and iteratively and discuss the trade-offs.

**Recursive DFS:** Elegant and concise, but risks stack overflow on very deep graphs.

```Java
import java.util.*;

public class DepthFirstSearchRecursive {  
      
    public static void dfs(Map<Integer, List<Integer>> graph, int startNode) {  
        if (!graph.containsKey(startNode)) return;  
        Set<Integer> visited = new HashSet<>();  
        dfsRecursive(graph, startNode, visited);  
        System.out.println();  
    }

    private static void dfsRecursive(Map<Integer, List<Integer>> graph, int currentNode, Set<Integer> visited) {  
        visited.add(currentNode);  
        System.out.print(currentNode + " "); // Process the node

        for (int neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {  
            if (!visited.contains(neighbor)) {  
                dfsRecursive(graph, neighbor, visited);  
            }  
        }  
    }  
}
```

**Iterative DFS:** More robust against stack overflow and makes the underlying stack mechanism explicit.

```Java
import java.util.*;

public class DepthFirstSearchIterative {  
      
    public static void dfs(Map<Integer, List<Integer>> graph, int startNode) {  
        if (!graph.containsKey(startNode)) return;

        Stack<Integer> stack = new Stack<>();  
        Set<Integer> visited = new HashSet<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {  
            int currentNode = stack.pop();

            if (!visited.contains(currentNode)) {  
                visited.add(currentNode);  
                System.out.print(currentNode + " "); // Process the node

                // Add neighbors to the stack in reverse order to mimic recursion  
                List<Integer> neighbors = graph.getOrDefault(currentNode, Collections.emptyList());  
                for (int i = neighbors.size() - 1; i >= 0; i--) {  
                    int neighbor = neighbors.get(i);  
                    if (!visited.contains(neighbor)) {  
                        stack.push(neighbor);  
                    }  
                }  
            }  
        }  
        System.out.println();  
    }  
}
```

The choice between recursive and iterative DFS is a classic trade-off. The recursive approach is often more intuitive and requires less code. However, for a graph that forms a long, unbranched chain of V nodes, the recursion depth can reach V, potentially causing a StackOverflowError if V is large (e.g., 105). The iterative approach, using an explicit stack on the heap, is limited only by available memory and is therefore safer and more scalable for any graph structure. An interviewer might ask about this specific scenario to test a candidate's awareness of practical system limitations.

#### **4. Time and Space Complexity**

* **Time Complexity:** O(V+E). Similar to BFS, each vertex is pushed and popped from the stack once (O(V)), and every edge is considered once (O(E)).  
* **Space Complexity:** O(H), where H is the maximum depth of the graph. The space is determined by the size of the stack (either the call stack for recursion or the explicit stack). In the worst case of a skewed, chain-like graph, H can be O(V). However, for a balanced, bushy graph, H can be as small as O(logV).

#### **5. Patterns**

DFS is the go-to algorithm for problems involving path exploration, connectivity, and structural properties of a graph.

* **Path Existence and Path Finding:** To answer "Is there a path from A to B?" or to find any such path, DFS is a natural fit. It will explore one potential path to its conclusion before trying another.  
* **Cycle Detection:** DFS can detect cycles in both directed and undirected graphs. In a directed graph, a cycle is found if the DFS encounters a node that is currently in the recursion stack (a "back edge"). This requires maintaining an additional set for nodes currently being visited in the active recursion path.  
* **Connected Components:** To find all connected components in an undirected graph, one can iterate through all vertices. If a vertex has not yet been visited, start a new DFS from it. Each such DFS will explore exactly one connected component.  
* **Topological Sorting:** A post-order DFS traversal is the basis for one of the main topological sorting algorithms for DAGs, which will be covered in detail later.

#### **6. Most Commonly Asked Questions**

* **Number of Islands (LeetCode 200):** A canonical grid problem. The grid of '1's and '0's is an implicit graph. The task is to count the connected components of '1's. The solution involves iterating through each cell; if an unvisited '1' is found, increment a counter and start a DFS (or BFS) to visit and mark all parts of that island.  
* **Clone Graph (LeetCode 133):** This requires creating a deep copy of a graph. A traversal is needed to visit every node and edge. DFS, particularly the recursive version, often leads to a clean solution where a map is used to store the mapping from original nodes to their copies to avoid re-cloning and handle cycles.  
* **Course Schedule (LeetCode 207):** This problem asks if a set of courses with prerequisites can be completed. This translates to detecting if a cycle exists in the directed graph of course dependencies. A DFS-based cycle detection algorithm is a standard solution.

#### **7. Advantages and Disadvantages**

* **Advantages:** Generally more space-efficient than BFS for wide, shallow graphs, as it only needs to store the current path on the stack. The recursive implementation is often very simple and elegant for problems that fit its structure.  
* **Disadvantages:** Does not guarantee the shortest path. It can get "lost" exploring a very deep path while a much shorter solution exists near the root. The recursive version is vulnerable to stack overflow on deep graphs.

| Criterion | Breadth-First Search (BFS) | Depth-First Search (DFS) |
| :---- | :---- | :---- |
| **Core Idea** | Explores level by level, visiting all neighbors before moving deeper. | Explores as far as possible along one path before backtracking. |
| **Data Structure** | Queue (FIFO) | Stack (LIFO) - implicit (recursion) or explicit. |
| **Time Complexity** | O(V+E) | O(V+E) |
| **Space Complexity** | O(W) (max-width of graph), worst case O(V). | O(H) (max-height/depth of graph), worst case O(V). |
| **Finds Shortest Path?** | Yes, for **unweighted** graphs. | No, not guaranteed. |
| **Cycle Detection** | Can be adapted, but less common. | Natural fit, especially for directed graphs (detecting back edges). |
| **Common Use Cases** | Shortest path in unweighted graphs, level-order traversal, web crawlers. | Path finding, cycle detection, connected components, topological sorting. |
| **Classic Interview Problem** | Word Ladder (LeetCode 127) | Number of Islands (LeetCode 200) |

## **Part III: The Quest for the Shortest Path (Weighted Graphs)**

When edges have weights or costs, the problem of finding the "shortest" path becomes more nuanced. It's no longer about the minimum number of edges but the minimum sum of weights along a path. This shift requires more sophisticated algorithms than BFS.

### **Dijkstra's Algorithm: The Greedy Path Finder**

#### **1. About the Algorithm**

Dijkstra's algorithm finds the shortest path from a single source vertex to all other vertices in a **weighted graph with non-negative edge weights**. It is a greedy algorithm. At each step, it selects the unvisited vertex with the smallest known distance from the source, "settles" it (meaning its shortest path is now considered final), and updates the distances to its neighbors. This greedy choice is only guaranteed to be optimal if adding an edge can never make a path shorter, which is true only when all edge weights are non-negative.

#### **2. & 3. Syntax and Operations (Java)**

The modern, efficient implementation of Dijkstra's algorithm uses a **Priority Queue** (min-heap) to store unvisited vertices, prioritized by their current shortest distance from the source. This allows for efficiently retrieving the "closest" unvisited node at each step.

```Java
import java.util.*;

public class DijkstraAlgorithm {

    static class Node implements Comparable<Node> {  
        public int vertex;  
        public int distance;

        public Node(int vertex, int distance) {  
            this.vertex = vertex;  
            this.distance = distance;  
        }

        @Override  
        public int compareTo(Node other) {  
            return Integer.compare(this.distance, other.distance);  
        }  
    }

    // Adjacency list representation: Map<Integer, List<Node>> where Node contains neighbor and edge weight  
    public static int dijkstra(Map<Integer, List<Node>> graph, int startNode, int numVertices) {  
        int distances = new int[numVertices];  
        Arrays.fill(distances, Integer.MAX_VALUE);  
        distances[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();  
        pq.add(new Node(startNode, 0));

        while (!pq.isEmpty()) {  
            Node currentNode = pq.poll();  
            int u = currentNode.vertex;  
            int d = currentNode.distance;

            // If we've found a shorter path already, skip  
            if (d > distances[u]) {  
                continue;  
            }

            for (Node neighborNode : graph.getOrDefault(u, Collections.emptyList())) {  
                int v = neighborNode.vertex;  
                int weight = neighborNode.distance; // Here, distance in Node class means edge weight

                if (distances[u] + weight < distances[v]) {  
                    distances[v] = distances[u] + weight;  
                    pq.add(new Node(v, distances[v]));  
                }  
            }  
        }  
        return distances;  
    }  
}
```

The use of a priority queue is central to the algorithm's efficiency. A naive implementation might scan an array of distances at each step to find the next vertex to visit, resulting in an O(V2) runtime. The priority queue allows this "find minimum" operation to be performed in O(logV) time, leading to a much faster overall algorithm.

#### **4. Time and Space Complexity**

* **Time Complexity:** O((E+V)logV) or often simplified to O(ElogV) since graphs are typically connected (E≥V−1). Each vertex is added to the priority queue and extracted once (V operations). Each edge relaxation might result in adding a new entry to the priority queue (E operations). Each priority queue operation takes O(logV) time.  
* **Space Complexity:** O(V+E). O(V) for the distance array and O(V) for the priority queue in the worst case. The graph representation itself takes O(V+E).

#### **5. Patterns**

* **Shortest Path in a Positively Weighted Graph:** This is the direct application. Keywords like "minimum cost," "cheapest flight," "fastest route," where all costs are positive, point directly to Dijkstra's algorithm.  
* **Network Routing and Delay:** Problems involving finding the minimum time for a signal to propagate through a network, where links have different latencies, are classic Dijkstra's problems.

#### **6. Most Commonly Asked Questions**

* **Network Delay Time (LeetCode 743):** A direct application where you are given network travel times and a source node. The goal is to find how long it takes for a signal to reach all nodes. This is equivalent to finding the maximum shortest path distance from the source.  
* **Path with Maximum Probability (LeetCode 1514):** A clever variation. To find the path with the highest product of probabilities, one can transform the problem into a shortest path problem by taking the negative logarithm of the edge weights. Since probabilities are between 0 and 1, their logs are negative, and their negative logs are positive. Maximizing the product becomes minimizing the sum of negative logs, which can be solved with Dijkstra's.

#### **7. Advantages and Disadvantages**

* **Advantages:** Highly efficient and the standard algorithm for single-source shortest paths on graphs with non-negative weights.  
* **Disadvantages:** It fails if the graph contains any negative-weight edges. The greedy assumption—that once a vertex is settled, its shortest path is found—is violated by the possibility that a future path through a negative edge could create an even shorter path to the settled vertex.

### **Bellman-Ford Algorithm: Handling Negative Weights**

#### **1. About the Algorithm**

The Bellman-Ford algorithm is a more robust, though slower, single-source shortest path algorithm. Its key feature is its ability to handle graphs with **negative edge weights**. It works by applying a process called "relaxation" to every edge in the graph. This process is repeated V−1 times. After V−1 iterations, if the distances can still be improved, it indicates the presence of a **negative-weight cycle**, a cycle whose edges sum to a negative value, which means there is no shortest path (one could traverse the cycle infinitely to decrease the path cost).

#### **2. & 3. Syntax and Operations (Java)**

The implementation is based on a simple but powerful idea: a shortest path can have at most V−1 edges. By relaxing all E edges V−1 times, the algorithm guarantees finding all shortest paths of up to that length.

```Java
import java.util.Arrays;

public class BellmanFordAlgorithm {

    static class Edge {  
        int source, destination, weight;  
        Edge(int s, int d, int w) {  
            source = s; destination = d; weight = w;  
        }  
    }

    public static int bellmanFord(Edge edges, int numVertices, int source) {  
        int distance = new int[numVertices];  
        Arrays.fill(distance, Integer.MAX_VALUE);  
        distance[source] = 0;

        // Step 1: Relax all edges |V| - 1 times  
        for (int i = 1; i < numVertices; ++i) {  
            for (Edge edge : edges) {  
                int u = edge.source;  
                int v = edge.destination;  
                int weight = edge.weight;  
                if (distance[u]!= Integer.MAX_VALUE && distance[u] + weight < distance[v]) {  
                    distance[v] = distance[u] + weight;  
                }  
            }  
        }

        // Step 2: Check for negative-weight cycles  
        for (Edge edge : edges) {  
            int u = edge.source;  
            int v = edge.destination;  
            int weight = edge.weight;  
            if (distance[u]!= Integer.MAX_VALUE && distance[u] + weight < distance[v]) {  
                System.out.println("Graph contains a negative weight cycle");  
                return null; // Or throw an exception  
            }  
        }  
          
        return distance;  
    }  
}
```

#### **4. Time and Space Complexity**

* **Time Complexity:** O(V⋅E). The algorithm consists of two main parts: the relaxation loops and the cycle detection loop. The outer loop runs V−1 times, and the inner loop iterates through all E edges. This results in O(V⋅E) complexity.  
* **Space Complexity:** O(V) to store the distance array.

#### **5. Patterns**

* **Shortest Path with Negative Edges:** If a problem involves finding a shortest path and the costs/weights can be negative (e.g., gaining energy, receiving a payment, time travel paradoxes), Bellman-Ford is the required algorithm.  
* **Detecting Negative Cycles (Arbitrage):** A classic application is in finance for detecting arbitrage opportunities. If vertices are currencies and edges are exchange rates (transformed into a logarithmic scale), a negative-weight cycle implies a sequence of trades that results in a risk-free profit.

#### **6. Most Commonly Asked Questions**

* **Arbitrage Detection:** A common problem in quantitative finance interviews. The setup requires modeling currencies and exchange rates as a graph and then running Bellman-Ford to check for negative cycles.  
* **LeetCode 787. Cheapest Flights Within K Stops:** While this problem has a "K stops" constraint that makes it slightly different, it can be solved with a modified Bellman-Ford where the relaxation is performed only K+1 times instead of V−1.

#### **7. Advantages and Disadvantages**

* **Advantages:** Its main advantage is its robustness. It works correctly for graphs with negative edge weights and provides a reliable method for detecting negative-weight cycles.  
* **Disadvantages:** Its O(V⋅E) time complexity is significantly slower than Dijkstra's algorithm, making it impractical for large graphs where edge weights are guaranteed to be positive.

| Criterion | Breadth-First Search (BFS) | Dijkstra's Algorithm | Bellman-Ford Algorithm |
| :---- | :---- | :---- | :---- |
| **Graph Type** | Unweighted or Uniformly Weighted | Weighted | Weighted |
| **Edge Weights** | N/A (all are 1) | **Non-negative only** | Positive or Negative |
| **Time Complexity** | O(V+E) | O(ElogV) | O(V⋅E) |
| **Negative Cycle Detection** | No | No | Yes |
| **Key Idea** | Level-order exploration with a Queue. | Greedy selection of closest unvisited node with a Priority Queue. | Dynamic programming approach; relax all edges V−1 times. |

## **Part IV: Building Minimalist Networks: Minimum Spanning Trees (MST)**

A different class of optimization problems on graphs involves connectivity. Instead of finding a path between two points, the goal is to connect *all* points in a network with the minimum possible total cost. This is the Minimum Spanning Tree (MST) problem.

An MST of a connected, undirected, weighted graph is a subgraph that connects all the vertices together, without any cycles, and with the minimum possible total edge weight. This has direct applications in designing physical networks like electrical grids, computer networks, and road systems, where the goal is to provide full connectivity with minimal cost.

### **Prim's Algorithm: The Vertex-Centric Builder**

#### **1. About the Algorithm**

Prim's algorithm is a greedy algorithm that builds an MST by "growing" a single tree. It starts from an arbitrary source vertex and, at each step, adds the cheapest possible edge that connects a vertex inside the growing MST to a vertex outside the MST. This process continues until all vertices are included in the tree.

#### **2. & 3. Syntax and Operations (Java)**

Similar to Dijkstra's, an efficient implementation of Prim's algorithm uses a **Priority Queue** to keep track of the cheapest edges that connect the current MST to vertices not yet in it.

```Java
import java.util.*;

public class PrimsAlgorithm {

    static class Edge implements Comparable<Edge> {  
        int to;  
        int weight;

        public Edge(int to, int weight) {  
            this.to = to;  
            this.weight = weight;  
        }

        @Override  
        public int compareTo(Edge other) {  
            return Integer.compare(this.weight, other.weight);  
        }  
    }

    // Adjacency list: Map<Integer, List<Edge>>  
    public static List<int> primsMST(Map<Integer, List<Edge>> graph, int numVertices) {  
        boolean inMST = new boolean[numVertices];  
        PriorityQueue<Edge> pq = new PriorityQueue<>();  
        List<int> mstEdges = new ArrayList<>();  
        int totalWeight = 0;

        // Start from vertex 0  
        int startVertex = 0;  
        inMST[startVertex] = true;  
        for (Edge edge : graph.getOrDefault(startVertex, Collections.emptyList())) {  
            pq.add(edge);  
        }

        while (!pq.isEmpty() && mstEdges.size() < numVertices - 1) {  
            Edge minEdge = pq.poll();  
            int toVertex = minEdge.to;

            if (inMST[toVertex]) {  
                continue;  
            }

            // This edge is part of the MST  
            inMST[toVertex] = true;  
            // The source of this edge must be found, this implementation is simplified  
            // A full implementation would store {from, to, weight} in the PQ.  
            // For simplicity, let's assume we can reconstruct the 'from' vertex.  
            // mstEdges.add(new int{fromVertex, toVertex, minEdge.weight});  
            totalWeight += minEdge.weight;

            for (Edge neighborEdge : graph.getOrDefault(toVertex, Collections.emptyList())) {  
                if (!inMST[neighborEdge.to]) {  
                    pq.add(neighborEdge);  
                }  
            }  
        }  
          
        System.out.println("Total MST Weight: " + totalWeight);  
        return mstEdges;  
    }  
}
```

#### **4. Time and Space Complexity**

* **Time Complexity:** O(ElogV) with a priority queue (binary heap). Each edge is added to the priority queue at most once, and each vertex is extracted once.  
* **Space Complexity:** O(V+E) for the graph representation and O(E) for the priority queue in the worst case.

#### **5. Patterns**

* **Network Design:** Any problem that asks to connect a set of points with minimum total cost is a candidate for an MST algorithm.  
* **Dense Graphs:** Prim's algorithm is sometimes considered more efficient for dense graphs (where E is close to V2) compared to Kruskal's, although their asymptotic complexities are similar with modern data structures.

#### **6. Most Commonly Asked Questions**

* **Min Cost to Connect All Points (LeetCode 1584):** A direct application of an MST algorithm. The points are vertices, and the Manhattan distance between any two points is the weight of the edge connecting them. The goal is to find the total weight of the MST.

#### **7. Advantages and Disadvantages**

* **Advantages:** Conceptually straightforward as it always maintains a single connected tree during its execution. Can be faster on dense graphs.  
* **Disadvantages:** Implementation with a priority queue can be slightly more complex than Kruskal's with a DSU. It cannot naturally handle disconnected graphs; it will only produce an MST for the component containing the start vertex.

### **Kruskal's Algorithm: The Edge-Centric Builder**

#### **1. About the Algorithm**

Kruskal's algorithm also finds an MST using a greedy approach, but its strategy is different. It considers all edges in the entire graph, sorted by increasing weight. It iterates through the sorted edges and adds an edge to the MST if and only if adding it **does not form a cycle** with the edges already selected. This process continues until V−1 edges have been added, forming the complete MST.

#### **2. & 3. Syntax and Operations (Java)**

The crucial component of Kruskal's algorithm is an efficient way to detect cycles. This is perfectly handled by the **Disjoint Set Union (DSU)** data structure, also known as Union-Find. A DSU tracks a partition of a set into disjoint subsets (connected components). An edge (u,v) creates a cycle if vertices u and v are already in the same subset.

Disjoint Set Union (DSU) Implementation:  
An optimized DSU uses two techniques: path compression (flattens the tree structure during find operations) and union by rank/size (keeps the trees shallow during union operations). These optimizations make its operations nearly constant time on average.

```Java
class DSU {  
    private int parent;  
    private int rank;

    public DSU(int n) {  
        parent = new int[n];  
        rank = new int[n];  
        for (int i = 0; i < n; i++) {  
            parent[i] = i;  
        }  
    }

    public int find(int i) { // with path compression  
        if (parent[i] == i) {  
            return i;  
        }  
        return parent[i] = find(parent[i]);  
    }

    public void union(int i, int j) { // with union by rank  
        int rootI = find(i);  
        int rootJ = find(j);  
        if (rootI!= rootJ) {  
            if (rank[rootI] > rank[rootJ]) {  
                parent[rootJ] = rootI;  
            } else if (rank[rootI] < rank[rootJ]) {  
                parent[rootI] = rootJ;  
            } else {  
                parent[rootJ] = rootI;  
                rank[rootI]++;  
            }  
        }  
    }  
}
```

**Kruskal's Algorithm Implementation:**

```Java
import java.util.*;

public class KruskalsAlgorithm {  
      
    static class Edge implements Comparable<Edge> {  
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {  
            return this.weight - compareEdge.weight;  
        }  
    }

    public static List<Edge> kruskalsMST(List<Edge> edges, int numVertices) {  
        Collections.sort(edges);  
          
        DSU dsu = new DSU(numVertices);  
        List<Edge> mst = new ArrayList<>();  
          
        for (Edge edge : edges) {  
            int rootSrc = dsu.find(edge.src);  
            int rootDest = dsu.find(edge.dest);

            if (rootSrc!= rootDest) {  
                mst.add(edge);  
                dsu.union(edge.src, edge.dest);  
                if (mst.size() == numVertices - 1) break;  
            }  
        }  
        return mst;  
    }  
}
```

#### **4. Time and Space Complexity**

* **Time Complexity:** O(ElogE) or O(ElogV). The dominant step is sorting the edges, which takes O(ElogE). The subsequent loop iterates through all E edges, with each DSU operation taking nearly constant time, O(α(V)), where α is the very slow-growing inverse Ackermann function.  
* **Space Complexity:** O(V+E) to store the graph edges and the DSU data structure.

#### **5. Patterns**

* **Sparse Graphs:** Kruskal's is generally preferred for sparse graphs where E is close to V, as the cost of sorting E edges is less prohibitive.  
* **Disconnected Components:** Kruskal's algorithm naturally produces a **Minimum Spanning Forest** (a collection of MSTs for each connected component) if the input graph is disconnected.  
* **Dynamic Connectivity:** The underlying DSU data structure is a pattern in itself, useful for problems involving checking connectivity or counting components dynamically.

#### **6. Most Commonly Asked Questions**

* **Connecting Cities With Minimum Cost (LeetCode 1135):** A direct application of Kruskal's algorithm.  
* **Number of Operations to Make Network Connected (LeetCode 1319):** This problem can be solved using a DSU. First, count the number of connected components and the number of redundant edges. A redundant edge is one that connects two vertices already in the same component. To connect k components, you need k−1 edges. If the number of redundant edges is sufficient, the answer is k−1.

#### **7. Advantages and Disadvantages**

* **Advantages:** The implementation, particularly the logic of sorting edges and using a DSU, is often considered more straightforward than Prim's with a priority queue. It works naturally on disconnected graphs.  
* **Disadvantages:** The initial sorting of all edges can be a performance bottleneck on very dense graphs.

| Criterion | Prim's Algorithm | Kruskal's Algorithm |
| :---- | :---- | :---- |
| **Core Idea** | Grows a single tree by adding the cheapest edge from the tree to a non-tree vertex. | Selects the globally cheapest edges that do not form a cycle. |
| **Data Structure** | Priority Queue (Min-Heap) | Sorting + Disjoint Set Union (DSU) |
| **Time Complexity** | O(ElogV) | O(ElogE) |
| **Best for Graph Type** | Dense Graphs (E≈V2) | Sparse Graphs (E≈V) |
| **Handles Disconnected Graphs?** | No (finds MST for one component) | Yes (finds a Minimum Spanning Forest) |

## **Part V: Ordering and Dependencies: Directed Acyclic Graphs (DAGs)**

Directed Acyclic Graphs (DAGs) are a special but extremely important category of graphs. Their defining feature—the absence of directed cycles—makes them the perfect tool for modeling processes with dependencies, such as task scheduling, academic course prerequisites, or software build systems. The fundamental operation on a DAG is **Topological Sorting**.

A topological sort is a linear ordering of a DAG's vertices such that for every directed edge from vertex u to vertex v, u comes before v in the ordering. This ordering represents a valid sequence for executing the tasks. A topological sort is only possible if and only if the graph is a DAG.

### **Topological Sort Algorithms**

There are two primary algorithms for performing a topological sort, one based on BFS and the other on DFS.

#### **1. Kahn's Algorithm (BFS-based)**

##### **About the Algorithm**

Kahn's algorithm works by identifying vertices that have no prerequisites, i.e., an **in-degree of 0**. It starts by adding all such vertices to a queue. Then, it repeatedly dequeues a vertex, adds it to the topological order, and effectively "removes" it from the graph. This removal is simulated by decrementing the in-degree of all its neighbors. If a neighbor's in-degree becomes 0 as a result, it is added to the queue, as its prerequisites have now been met.

##### **Syntax (Java)**

```Java
import java.util.*;

public class KahnsAlgorithm {

    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int numVertices) {  
        int inDegree = new int[numVertices];  
        for (int u = 0; u < numVertices; u++) {  
            for (int v : graph.getOrDefault(u, Collections.emptyList())) {  
                inDegree[v]++;  
            }  
        }

        Queue<Integer> queue = new LinkedList<>();  
        for (int i = 0; i < numVertices; i++) {  
            if (inDegree[i] == 0) {  
                queue.add(i);  
            }  
        }

        List<Integer> topOrder = new ArrayList<>();  
        while (!queue.isEmpty()) {  
            int u = queue.poll();  
            topOrder.add(u);

            for (int v : graph.getOrDefault(u, Collections.emptyList())) {  
                inDegree[v]--;  
                if (inDegree[v] == 0) {  
                    queue.add(v);  
                }  
            }  
        }

        // Check for cycle  
        if (topOrder.size()!= numVertices) {  
            System.out.println("Graph has a cycle! Topological sort not possible.");  
            return Collections.emptyList();  
        }

        return topOrder;  
    }  
}
```

#### **2. DFS-based Algorithm**

##### **About the Algorithm**

This approach uses Depth-First Search. The key idea is that a vertex can only be finished (i.e., added to the topological order) after all of its descendants in the dependency chain have been visited and finished. A DFS traversal naturally accomplishes this. When the recursive DFS call for a vertex v finishes (meaning all its neighbors and their descendants have been fully explored), v is added to the front of a list or pushed onto a stack. The final topological order is obtained by reversing this list or popping all elements from the stack.

##### **Syntax (Java)**

```Java
import java.util.*;

public class DFSTopologicalSort {

    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int numVertices) {  
        Stack<Integer> stack = new Stack<>();  
        boolean visited = new boolean[numVertices];  
          
        for (int i = 0; i < numVertices; i++) {  
            if (!visited[i]) {  
                dfs(graph, i, visited, stack);  
            }  
        }

        List<Integer> topOrder = new ArrayList<>();  
        while (!stack.isEmpty()) {  
            topOrder.add(stack.pop());  
        }  
        return topOrder;  
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int u, boolean visited, Stack<Integer> stack) {  
        visited[u] = true;

        for (int v : graph.getOrDefault(u, Collections.emptyList())) {  
            if (!visited[v]) {  
                dfs(graph, v, visited, stack);  
            }  
        }  
        // After visiting all descendants, push current vertex to stack  
        stack.push(u);  
    }  
}
```

#### **4. Time and Space Complexity**

* **Time Complexity:** O(V+E) for both algorithms. They both process each vertex and each edge exactly once.  
* **Space Complexity:** O(V) for both algorithms, to store the in-degree array and queue (Kahn's) or the visited array and recursion/explicit stack (DFS-based).

#### **5. Patterns**

* **Task/Job Scheduling:** The most common pattern. If a problem states "task A must be completed before task B," it is defining a directed edge A → B. Finding a valid sequence of tasks is a topological sort.  
* **Dependency Resolution:** Used in software build systems (e.g., Maven, Gradle) and package managers to determine the correct order for compiling files or installing packages based on their dependencies.  
* **Finding an Ordering:** Any problem that asks to "find a valid sequence" or "determine a possible order" based on a set of constraints is likely a topological sort problem.

A critical aspect of harder graph problems is that the graph is often not given explicitly. The candidate must first parse the problem's input to construct the graph before applying an algorithm. This tests modeling and abstraction skills. For example, in the "Alien Dictionary" problem, the dependencies (edges) between letters must be inferred by comparing adjacent words in the sorted list. Only after building this graph can one apply topological sort to find the alien alphabet's order.

#### **6. Most Commonly Asked Questions**

* **Course Schedule (LeetCode 207) & Course Schedule II (LeetCode 210):** The canonical topological sort problems. Part I asks if a schedule is possible (i.e., is the graph a DAG?), which is a cycle detection problem. Part II asks for a valid course order, which is the topological sort itself.  
* **Alien Dictionary (LeetCode 269):** A hard problem that combines graph construction with topological sort. The candidate must derive the character precedence rules (edges) by comparing adjacent words in the given sorted list and then find a valid linear ordering of the characters.

#### **7. Advantages and Disadvantages (Kahn's vs. DFS)**

* Kahn's algorithm is often more intuitive for scheduling problems, as its process of consuming nodes with zero in-degree mirrors the real-world process of completing tasks whose prerequisites are met. Its cycle detection is also very explicit (the final list size is less than V).  
* The DFS-based approach is often more concise to implement recursively. It can also be adapted to detect cycles by tracking nodes currently in the recursion path.

## **Conclusion: A Framework for Acing Graph Interviews**

Mastering graphs for technical interviews is less about memorizing code and more about cultivating a problem-solving framework. The process can be broken down into three distinct, repeatable steps that transform a complex word problem into a clean, efficient solution.

### **The 3-Step Graph Problem-Solving Framework**

1. **Identify & Abstract:** Read the problem carefully and identify the core components. Ask:  
   * **Is this a graph problem?** Look for keywords like nodes, connections, network, cities, dependencies, states, etc.  
   * **What are the vertices and edges?** Abstract the problem's entities into vertices and their relationships into edges. Sometimes this is explicit (a list of connections); other times it is implicit (words in a dictionary, cells in a grid).  
   * **What are the graph's properties?** Is it directed or undirected? Weighted or unweighted? Are there cycles? Are weights negative? Answering these questions is the most critical step, as it drastically narrows down the set of possible algorithms.  
2. **Select & Justify:** Based on the graph's properties and the specific question being asked, select the appropriate algorithm using the master reference table below. In an interview, it is crucial to not only select the right algorithm but also to articulate *why* it is the right choice and why others are not. For example: "This is a shortest path problem on an unweighted graph, so I will use BFS. Dijkstra's would also work but is less efficient here, and Bellman-Ford is unnecessary as there are no negative weights."  
3. **Implement & Verify:**  
   * Choose the right representation (default to an adjacency list).  
   * Write clean, modular code for the chosen algorithm.  
   * Always include a mechanism to handle visited nodes to prevent infinite loops in cyclic graphs.  
   * Consider and discuss edge cases: an empty graph, a graph with one or two nodes, disconnected components, and self-loops.

### **Master Algorithm Reference for Interviews**

This table synthesizes the pattern-recognition logic of this guide into a high-density reference. It is designed to be the mental model for mapping interview problem statements to optimal algorithmic solutions.

| Problem Pattern / Keywords | Graph Type | Algorithm | Time Complexity | Classic LeetCode Example |
| :---- | :---- | :---- | :---- | :---- |
| "Shortest path", "minimum steps", "fewest moves" | Unweighted | **BFS** | O(V+E) | Rotten Oranges (994) |
| "Path exists?", "connected components", "find a path" | Any | **DFS** | O(V+E) | Number of Islands (200) |
| "Minimum cost path", "cheapest route" | Weighted (non-negative) | **Dijkstra's** | O(ElogV) | Network Delay Time (743) |
| "Shortest path with negative costs", "arbitrage" | Weighted (negative allowed) | **Bellman-Ford** | O(V⋅E) | Arbitrage Detection |
| "Connect all points with minimum cost", "cheapest network" | Weighted, Undirected | **Prim's / Kruskal's** | O(ElogV) | Min Cost to Connect All Points (1584) |
| "Task scheduling", "prerequisites", "find valid order" | Directed, Acyclic (DAG) | **Topological Sort** | O(V+E) | Course Schedule (207/210) |

By internalizing this framework and practicing the canonical problems associated with each pattern, a candidate can move beyond simply knowing what an algorithm does and achieve a state of mastery where they can confidently and efficiently solve any graph problem an interviewer presents.