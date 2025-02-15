
**Notes on DFS (Depth-First Search) Traversal in Graphs**

1. **Introduction to DFS**  
   - DFS is a graph traversal technique that prioritizes depth over breadth.  
   - Contrasts with BFS (Breadth-First Search), which explores nodes level by level.  
   - Key concept: "Go as deep as possible, then backtrack."

2. **Traversal Process**  
   - **Starting Node**: Begin at a specified node (e.g., node 1).  
   - **Neighbor Selection**: Choose a neighbor (e.g., leftmost in adjacency list) and explore its depth first.  
   - **Backtracking**: When no unvisited neighbors remain, return to the previous node and explore other branches.  
   - **Example Path**: Starting at 1 → 2 → 5 → backtrack to 2 → 6 → backtrack to 1 → 3 → 7 → 8 → 4.  

3. **Algorithm Mechanics**  
   - **Recursion**: DFS inherently uses recursion to manage the traversal stack.  
   - **Adjacency List**: Nodes are stored in adjacency lists (order affects traversal path).  
   - **Visited Array**: Tracks visited nodes to avoid cycles.  

4. **Implementation Steps**  
   - **Initialize**: Create a visited array (size = number of nodes) and mark the starting node as visited.  
   - **Recursive Function**:  
     - Add current node to the traversal list.  
     - Iterate through neighbors; if unvisited, recursively call DFS.  
   - **Termination**: When all nodes are visited, return the traversal list.  

5. **Example Code (Java/Python)**  
   ```java
    class Solution {
        
        public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, 
        ArrayList<Integer> ls) {
            
            //marking current node as visited
            vis[node] = true;
            ls.add(node);
            
            //getting neighbour nodes
            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                    dfs(it, vis, adj, ls);
                }
            }
        }
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            //boolean array to keep track of visited vertices
            boolean vis[] = new boolean[V+1];
            vis[0] = true; 
            ArrayList<Integer> ls = new ArrayList<>();
            dfs(0, vis, adj, ls); 
            return ls; 
        }
    }
   ```  

6. **Complexity Analysis**  
   - **Time Complexity**: O(N + E), where N = nodes, E = edges (each node/edge is processed once).  
   - **Space Complexity**: O(N) for the visited array and recursion stack (worst case: skewed graph).  

7. **Key Takeaways**  
   - DFS order depends on the adjacency list’s node ordering.  
   - Different starting nodes yield different traversal sequences.  
   - Recursion is essential for handling backtracking.  
   - Adjacency lists are preferred for sparse graphs.  

8. **Additional Tips**  
   - Review recursion concepts for deeper understanding.  
   - Practice implementing DFS on various graph structures (e.g., trees, cyclic graphs).  

**Summary**: DFS explores graphs by prioritizing depth, using recursion to manage traversal. Its efficiency and path variability depend on the graph’s structure and adjacency list ordering.

### When to use DFS


- Do we need to explore all complete paths? (yes)
- Do we need to backtrack to explore different branches? (yes)
- Do we need to do a level order traversal? (no)
- Do we need to find the shortest path between 2 nodes? (no)

 **CHOOSE DFS**

### Dry Run 

Let's perform a dry run of the provided DFS code using the graph structure from the image.

### Graph Structure from the Image:
- Node 1 is connected to nodes 2 and 3.
- Node 2 is connected to nodes 1, 5, and 6.
- Node 3 is connected to nodes 1, 4, and 7.
- Node 4 is connected to nodes 3 and 8.
- Node 5 is connected to node 2.
- Node 6 is connected to node 2.
- Node 7 is connected to node 3.
- Node 8 is connected to node 4.

### Adjacency List Representation:
```java
ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
adj.add(new ArrayList<>(Arrays.asList(2, 3)));
adj.add(new ArrayList<>(Arrays.asList(1, 5, 6)));
adj.add(new ArrayList<>(Arrays.asList(1, 4, 7)));
adj.add(new ArrayList<>(Arrays.asList(3, 8)));
adj.add(new ArrayList<>(Arrays.asList(2)));
adj.add(new ArrayList<>(Arrays.asList(2)));
adj.add(new ArrayList<>(Arrays.asList(3)));
adj.add(new ArrayList<>(Arrays.asList(4, 7)));
```

### DFS Implementation:
```java
class Solution {
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        // Marking current node as visited
        vis[node] = true;
        ls.add(node);

        // Getting neighbor nodes
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Boolean array to keep track of visited vertices
        boolean vis[] = new boolean[V + 1];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }
}
```

### Dry Run:
1. Start at node 1:
   - Mark node 1 as visited.
   - Add node 1 to the list: [1]
   - Explore neighbors: 2 and 3 (unvisited)
2. Move to node 2:
   - Mark node 2 as visited.
   - Add node 2 to the list: [1, 2]
   - Explore neighbors: 1 (visited), 5, 6 (unvisited)
3. Move to node 5:
   - Mark node 5 as visited.
   - Add node 5 to the list: [1, 2, 5]
   - Explore neighbors: 2 (visited), no further nodes
4. Backtrack to node 2, then to node 6:
   - Mark node 6 as visited.
   - Add node 6 to the list: [1, 2, 5, 6]
   - Explore neighbors: 2 (visited), no further nodes
5. Backtrack to node 2, then to node 3:
   - Mark node 3 as visited.
   - Add node 3 to the list: [1, 2, 5, 6, 3]
   - Explore neighbors: 1 (visited), 4, 7 (unvisited)
6. Move to node 4:
   - Mark node 4 as visited.
   - Add node 4 to the list: [1, 2, 5, 6, 3, 4]
   - Explore neighbors: 3 (visited), 8 (unvisited)
7. Move to node 8:
   - Mark node 8 as visited.
   - Add node 8 to the list: [1, 2, 5, 6, 3, 4, 8]
   - Explore neighbors: 4, 7 (visited), no further nodes
8. Backtrack to node 4, then to node 7:
   - Mark node 7 as visited.
   - Add node 7 to the list: [1, 2, 5, 6, 3, 4, 8, 7]
   - Explore neighbors: 3 (visited), 8 (visited), no further nodes

### Final Traversal List:
```java
[1, 2, 5, 6, 3, 4, 8, 7]
```

This dry run demonstrates how the DFS algorithm explores the graph starting from node 1, visiting nodes in depth-first order.
