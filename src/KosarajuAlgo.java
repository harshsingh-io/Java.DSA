import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i=0;i< graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

    }
    public static void topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack){
        visited[curr] = true;
        for (int i=0 ; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSort(graph, e.dest, visited, stack);
            }

        }
        stack.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr+" ");
        for (int i=0 ; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }

        }
    }
    public static void kosaraju(ArrayList<Edge>[] graph, int V){ // O(V+E)
        // Step 1 : Get nodes in stack(Topological Sort) // O(V+E)
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i=0 ; i<V;i++){
            if (!visited[i]) {
                topologicalSort(graph,i,visited,stack);
            }
        }
        // Step 2 : Transpose the existing graph and make a copy of it. // O(V+E)
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i=0;i< graph.length;i++){
            visited[i] = false; // reinitialised for further use in 3rd step
            transpose[i] = new ArrayList<Edge>();
        }
        for (int i=0;i< V;i++){
            for (int j=0; j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        // Step 3 : Do DFS according to stack nodes on the transposed graph. // O(V+E)
        while (!stack.isEmpty()){
            int curr = stack.pop();
            if (!visited[curr]){
                System.out.print("SCC ->");
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
