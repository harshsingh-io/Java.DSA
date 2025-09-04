# DSA Notes: Graphs

## 1. About Data Structure

A **graph** is a non-linear data structure consisting of vertices (nodes) and edges that connect these vertices[1][2]. Graphs are used to represent relationships between objects and are fundamental in modeling networks, dependencies, and complex relationships[1][3]. 

Unlike linear data structures such as arrays or linked lists, graphs allow multiple paths between elements, making them versatile for representing real-world scenarios like social networks, transportation systems, computer networks, and dependency graphs[2][4][5].

**Key Components:**
- **Vertices (Nodes):** The fundamental units representing objects or entities[2][3]
- **Edges (Arcs):** Connections between vertices representing relationships[2][3]

**Types of Graphs:**
- **Directed vs Undirected:** Edges have direction (directed) or no direction (undirected)[1][2]
- **Weighted vs Unweighted:** Edges may have associated weights/costs or all have equal weight[4]
- **Connected vs Disconnected:** All vertices reachable from any vertex (connected) or isolated components exist[2]
- **Cyclic vs Acyclic:** Contains cycles or no cycles[4]

## 2. Syntax (Java)

### Basic Graph Class Structure

```java
import java.util.*;

// Graph using Adjacency List
class Graph {
    private Map> adjList;
    
    public Graph() {
        adjList = new HashMap<>();
    }
    
    // Add vertex
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }
    
    // Add edge (undirected)
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); neighbors
    public List getNeighbors(int vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }
    
    // Print graph
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print("Vertex " + vertex + ": ");
            for (int neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
```

### Generic Graph Implementation

```java
import java.util.*;

class Graph {
    private Map> adjList = new HashMap<>();
    
    public void addVertex(T vertex) {
        adjList.put(vertex, new LinkedList<>());
    }
    
    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!adjList.containsKey(source))
            addVertex(source);
        if (!adjList.containsKey(destination))
            addVertex(destination);
            
        adjList.get(source).add(destination);
        if (bidirectional) {
            adjList.get(destination).add(source);
        }
    }
    
    public boolean hasVertex(T vertex) {
        return adjList.containsKey(vertex);
    }
    
    public boolean hasEdge(T source, T destination) {
        return adjList.get(source).contains(destination);
    }
}
```

### Adjacency Matrix Implementation

```java
class GraphMatrix {
    private int[][] adjMatrix;
    private int numVertices;
    
    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }
    
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1; // For undirected graph
    }
    
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }
    
    public boolean hasEdge(int i, int j) {
        return adjMatrix[i][j] == 1;
    }
}
```

## 3. Operations with Syntax

### Basic Operations

| Operation | Adjacency List | Adjacency Matrix |
|-----------|----------------|------------------|
| **Add Vertex** | O(1) | O(V²) |
| **Add Edge** | O(1) | O(1) |
| **Remove Vertex** | O(V+E) | O(V²) |
| **Remove Edge** | O(E/V) | O(1) |
| **Check Edge** | O(min(degree(u), degree(v))) | O(1) |
| **Get Neighbors** | O(1) | O(V) |

### Depth-First Search (DFS)

```java
public void dfs(int vertex, Set visited) {
    visited.add(vertex);
    System.out.print(vertex + " ");
    
    for (int neighbor : adjList.get(vertex)) {
        if (!visited.contains(neighbor)) {
            dfs(neighbor, visited);
        }
    }
}

// Iterative DFS
public void dfsIterative(int start) {
    Set visited = new HashSet<>();
    Stack stack = new Stack<>();
    
    stack.push(start);
    
    while (!stack.isEmpty()) {
        int vertex = stack.pop();
        
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            System.out.print(vertex + " ");
            
            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
```

### Breadth-First Search (BFS)

```java
public void bfs(int start) {
    Set visited = new HashSet<>();
    Queue queue = new LinkedList<>();
    
    visited.add(start);
    queue.offer(start);
    
    while (!queue.isEmpty()) {
        int vertex = queue.poll();
        System.out.print(vertex + " ");
        
        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }
}
```

### Cycle Detection

```java
// Cycle detection in undirected graph
public boolean hasCycleUndirected() {
    Set visited = new HashSet<>();
    
    for (int vertex : adjList.keySet()) {
        if (!visited.contains(vertex)) {
            if (dfsHasCycle(vertex, -1, visited)) {
                return true;
            }
        }
    }
    return false;
}

private boolean dfsHasCycle(int vertex, int parent, Set visited) {
    visited.add(vertex);
    
    for (int neighbor : adjList.get(vertex)) {
        if (!visited.contains(neighbor)) {
            if (dfsHasCycle(neighbor, vertex, visited)) {
                return true;
            }
        } else if (neighbor != parent) {
            return true; // Cycle found
        }
    }
    return false;
}
```

### Topological Sort

```java
public List topologicalSort() {
    Map inDegree = new HashMap<>();
    Queue queue = new LinkedList<>();
    List result = new ArrayList<>();
    
    // Calculate in-degrees
    for (int vertex : adjList.keySet()) {
        inDegree.put(vertex, 0);
    }
    
    for (int vertex : adjList.keySet()) {
        for (int neighbor : adjList.get(vertex)) {
            inDegree.put(neighbor, inDegree.get(neighbor) + 1);
        }
    }
    
    // Add vertices with 0 in-degree
    for (int vertex : inDegree.keySet()) {
        if (inDegree.get(vertex) == 0) {
            queue.offer(vertex);
        }
    }
    
    while (!queue.isEmpty()) {
        int vertex = queue.poll();
        result.add(vertex);
        
        for (int neighbor : adjList.get(vertex)) {
            inDegree.put(neighbor, inDegree.get(neighbor) - 1);
            if (inDegree.get(neighbor) == 0) {
                queue.offer(neighbor);
            }
        }
    }
    
    return result.size() == adjList.size() ? result : null; // Null if cycle exists
}
```

## 4. Time Complexity of Operations

### Graph Representation Complexities

| Representation | Space | Add Vertex | Add Edge | Remove Vertex | Remove Edge | Check Edge | Get Neighbors |
|----------------|-------|------------|----------|---------------|-------------|------------|---------------|
| **Adjacency List** | O(V+E) | O(1) | O(1) | O(V+E) | O(V) | O(V) | O(1) |
| **Adjacency Matrix** | O(V²) | O(V²) | O(1) | O(V²) | O(1) | O(1) | O(V) |

### Traversal Algorithms

| Algorithm | Time Complexity | Space Complexity | Description |
|-----------|----------------|------------------|-------------|
| **DFS** | O(V+E) | O(V) | Explores as far as possible before backtracking[6][7] |
| **BFS** | O(V+E) | O(V) | Explores neighbors level by level[6][7] |
| **Topological Sort** | O(V+E) | O(V) | Linear ordering of DAG vertices[8] |
| **Cycle Detection** | O(V+E) | O(V) | Detects cycles in graph[8] |
| **Connected Components** | O(V+E) | O(V) | Finds all connected components |

**Explanation of O(V+E) complexity:**
- **V:** Each vertex is visited exactly once[6][7]
- **E:** Each edge is examined once during traversal[6][7]
- The algorithm processes all vertices and all edges, hence O(V+E)[7][9]

## 5. Patterns

### Common Graph Patterns in Coding Interviews

**1. Graph Traversal Pattern**
- **DFS/BFS for connectivity:** Finding connected components, path existence
- **Applications:** Island counting, friend circles, maze solving

**2. Cycle Detection Pattern**
- **Undirected graphs:** Use DFS with parent tracking
- **Directed graphs:** Use DFS with recursion stack or topological sort
- **Applications:** Dependency resolution, deadlock detection

**3. Topological Sorting Pattern**
- **Kahn's Algorithm:** BFS-based using in-degree
- **DFS-based:** Post-order traversal
- **Applications:** Course scheduling, build systems, task dependencies

**4. Shortest Path Pattern**
- **Unweighted graphs:** BFS
- **Weighted graphs:** Dijkstra's algorithm
- **Negative weights:** Bellman-Ford algorithm
- **All pairs:** Floyd-Warshall algorithm

**5. Union Find (Disjoint Set) Pattern**
- **Dynamic connectivity:** Check if nodes are connected
- **Applications:** Minimum spanning tree, cycle detection, network connectivity

**6. Bipartite Graph Pattern**
- **Two-coloring:** Check if graph can be colored with two colors
- **Applications:** Matching problems, scheduling conflicts

**7. Minimum Spanning Tree Pattern**
- **Kruskal's Algorithm:** Union-find based
- **Prim's Algorithm:** Priority queue based
- **Applications:** Network design, clustering

**8. Strongly Connected Components Pattern**
- **Kosaraju's Algorithm:** Two-pass DFS
- **Tarjan's Algorithm:** Single-pass DFS
- **Applications:** Web crawling, social network analysis

### Problem Recognition Patterns

| Pattern Type | Key Indicators | Common Problems |
|--------------|----------------|------------------|
| **Traversal** | Visit all nodes, explore paths | Number of Islands, Clone Graph |
| **Shortest Path** | Find minimum distance/cost | Word Ladder, Network Delay Time |
| **Cycle Detection** | Check for circular dependencies | Course Schedule, Redundant Connection |
| **Topological Sort** | Order with dependencies | Course Schedule II, Alien Dictionary |
| **Connected Components** | Find isolated groups | Number of Provinces, Graph Valid Tree |
| **Bipartite** | Two-group classification | Is Graph Bipartite, Possible Bipartition |

## 6. Advantages and Disadvantages

### Advantages

**1. Flexibility and Expressiveness**
- Can model complex relationships and dependencies[10]
- Suitable for representing real-world networks and systems[4][5]
- Supports both directed and undirected relationships[4]

**2. Efficient Algorithms**
- Well-established algorithms for common problems[10]
- Linear-time complexity for many operations (O(V+E))[6][7]
- Reusable implementations across different applications[10]

**3. Scalability**
- Can handle large datasets efficiently with proper representation[10]
- Adjacency list representation is memory-efficient for sparse graphs[11][12]

**4. Real-world Applications**
- Social networks, transportation systems, computer networks[5]
- Dependency management, scheduling, pathfinding[8]
- Recommendation systems, web crawling[4]

### Disadvantages

**1. Complexity**
- Can be complex to understand and implement[13][10]
- Requires careful consideration of representation choice[11]
- Some algorithms have steep learning curves[10]

**2. Memory and Performance Issues**
- Adjacency matrix uses O(V²) space even for sparse graphs[13][12]
- Large graphs can become difficult to manage[13][14]
- Performance degrades with increasing vertices and edges[13]

**3. Representation Limitations**
- Graphs only represent relationships, not object properties[13]
- Choice between adjacency list vs matrix affects performance[11][12]
- Dense graphs may require different optimization strategies[11]

**4. Visualization and Debugging Challenges**
- Large graphs are difficult to visualize and understand[13][14]
- Debugging graph algorithms can be challenging[13]
- Maintenance of complex graph structures requires additional effort[10]

**5. Specific Algorithmic Limitations**
- Some algorithms only work with specific graph types (e.g., DAGs)[8]
- Negative cycles can cause issues in shortest path algorithms
- Strongly connected component algorithms are complex to implement[8]

### When to Use Different Representations

**Adjacency List:**
- **Best for:** Sparse graphs (E << V²)[11][12]
- **Advantages:** Memory efficient, fast neighbor iteration[11]
- **Use cases:** Social networks, web graphs, dependency graphs[11]

**Adjacency Matrix:**
- **Best for:** Dense graphs (E ≈ V²)[11][12]
- **Advantages:** Constant-time edge lookup, simple implementation[11]
- **Use cases:** Complete graphs, small graphs with frequent edge queries[11]

This comprehensive overview provides the foundation for understanding graphs as a fundamental data structure in computer science, with practical Java implementations and real-world applications that align with your software development background.

[1] https://www.simplilearn.com/tutorials/data-structure-tutorial/graphs-in-data-structure
[2] https://www.geeksforgeeks.org/dsa/introduction-to-graphs-data-structure-and-algorithm-tutorials/
[3] https://en.wikipedia.org/wiki/Graph_(abstract_data_type)
[4] https://dzone.com/articles/introduction-to-the-graph-data-structure
[5] https://www.w3schools.com/dsa/dsa_theory_graphs.php
[6] https://www.geeksforgeeks.org/dsa/time-and-space-complexity-of-dfs-and-bfs-algorithm/
[7] https://www.geeksforgeeks.org/dsa/why-is-the-complexity-of-both-bfs-and-dfs-ove/
[8] https://www.geeksforgeeks.org/dsa/graph-based-algorithms-for-gate-exam/
[9] https://stackoverflow.com/questions/11468621/why-is-the-time-complexity-of-both-dfs-and-bfs-o-v-e
[10] https://askfilo.com/user-question-answers-smart-solutions/advantages-disadvantages-and-applications-of-dsa-algorithm-3335313934313335
[11] https://imkarthikeyans.hashnode.dev/understanding-graphs-in-javascript-adjacency-matrix-vs-adjacency-list
[12] https://www.baeldung.com/cs/graphs
[13] https://www.geeksforgeeks.org/dsa/applications-advantages-and-disadvantages-of-graph/
[14] https://www.tutorialspoint.com/applications-advantages-and-disadvantages-of-graph
[15] https://dev.to/hellocodeclub/graph-implementation-example-in-java-1mhh
[16] https://dev.to/vijayr00/understanding-dsa-patterns-p9b
[17] https://www.softwaretestinghelp.com/java-graph-tutorial/
[18] https://www.scribd.com/document/843938448/DSA-Techniques-and-Patterns
[19] https://www.programiz.com/java-programming/examples/graph-implementation
[20] https://blog.algomaster.io/p/master-graph-algorithms-for-coding
[21] https://herovired.com/learning-hub/blogs/graphs-in-data-structure/
[22] https://www.geeksforgeeks.org/java/implementing-generic-graph-in-java/
[23] https://www.inf.unibz.it/~nutt/Teaching/DSA1617/DSASlides/chapter07.pdf
[24] https://www.geeksforgeeks.org/dsa/what-is-graph-data-structure/
[25] https://docs.vultr.com/java/examples/implement-the-graph-data-structure
[26] https://javachallengers.com/graph-data-structure-with-java/
[27] https://hackernoon.com/5-graph-patterns-to-ace-coding-interviews
[28] https://byjus.com/gate/graph-and-its-applications/
[29] https://www.baeldung.com/java-graphs
[30] https://www.geeksforgeeks.org/dsa/time-complexity-and-space-complexity/
[31] https://stackoverflow.com/questions/77568628/adjacency-matrix-and-adjacency-list-time-complexity
[32] https://www.w3schools.com/dsa/dsa_timecomplexity_theory.php
[33] https://www.youtube.com/watch?v=0QnFZlorhqc
[34] https://www.geeksforgeeks.org/dsa/graph-data-structure-and-algorithms/
[35] https://www.educative.io/answers/what-is-an-adjacency-list
[36] https://www.wscubetech.com/resources/dsa/graph-algorithms
[37] https://www.youtube.com/watch?v=ZpOy0-QBVPM
[38] https://dev.to/akashdeep/big-o-complexity-for-graphs-adjacency-matrix-vs-adjacency-list-3akf
[39] https://www.baeldung.com/java-collections-complexity
[40] https://www.geeksforgeeks.org/time-and-space-complexity-of-depth-first-search-dfs/
[41] https://www.cs.cmu.edu/~eugene/teach/algs03b/works/s10.pdf
[42] https://www.educative.io/courses/data-structures-coding-interviews-java/complexities-of-graph-operations
[43] https://www.slideshare.net/slideshow/bfs-and-dfs-244040667/244040667
[44] https://stackoverflow.com/questions/44983431/time-complexity-of-adjacency-list-representation
[45] https://dev.to/_hm/data-structure-operations-time-complexity-guide-19pi
[46] https://visualgo.net/en/dfsbfs
[47] https://www.cs.cornell.edu/courses/cs2112/2012sp/lectures/lec24/lec24-12sp.html
[48] https://opendsa.cs.vt.edu/ODSA/Books/vt/cs5040/summer-ii-2023/Summer2023/html/GraphTraversal.html
[49] https://www.ida.liu.se/opendsa/Books/TDDE22F24/html/GraphTraversal.html
[50] https://www.studocu.com/en-us/document/oklahoma-state-university/data-structures-and-algorithms-ii/graph-representation-and-operations-adjacency-matrix-vs-list-6092/125925831
[51] https://www.ida.liu.se/opendsa/Books/TDDI16F20/html/GraphTraversal.html
[52] https://www.slideshare.net/CHIRANTANMONDAL2/brief-reletionship-between-adjacency-matrix-and-listpptx
[53] https://www.tutorialspoint.com/applications-advantages-and-disadvantages-of-directed-graph
[54] https://opendsa-server.cs.vt.edu/ODSA/Books/pubbook/cs3/fall-2024/CS3_Public_F24/html/GraphTraversal.html
[55] https://www.geeksforgeeks.org/dsa/graph-and-its-representations/
[56] https://www.designgurus.io/answers/detail/what-are-common-graph-traversal-questions-in-coding-interviews
[57] https://www.geeksforgeeks.org/comparison-between-adjacency-list-and-adjacency-matrix-representation-of-graph/