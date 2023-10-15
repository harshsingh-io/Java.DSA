import java.util.LinkedList;
 
class DepthfirstSearch {
    private int V;                  // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    public DepthfirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's adjacency list
    }

    void DFSUtil(int vertex, boolean visited[]) {
        visited[vertex] = true; // Mark the current node as visited
        System.out.print(vertex + " ");

        // Recursive for all the vertices adjacent to this vertex
        for (Integer neighbor : adj[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V]; // Mark all vertices as not visited
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        DepthfirstSearch g = new DepthfirstSearch(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        System.out.println("Depth First Traversal (starting from vertex 0):");
        g.DFS(0);
    }
}







