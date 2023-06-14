import java.util.ArrayList;

public class ArticulationPoint {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }

    // Time Complexity is O(V+E) Optimised Approach Of Articulation Point
    public static void dfs(ArrayList<Edge>[] graph, int curr, int par,
                           int[] dt, int[] low, int time, boolean[] vis, boolean[] articulationPoint) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // e.src ---- e.dest
            int neighbour = e.dest;
            if (neighbour == par) {
                continue;
            } else if (!vis[neighbour]) {
                dfs(graph, neighbour, curr, dt, low, time, vis, articulationPoint);
                low[curr] = Math.min(low[curr], low[neighbour]);
                if (par != -1 && dt[curr] <= low[neighbour] && !articulationPoint[curr]) {
                    articulationPoint[curr] = true;
                }
                children++;
            } else {
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
        }
        if (par == -1 && children > 1) {
            articulationPoint[curr] = true;
        }
    }

    public static void getArticulationPoint(ArrayList<Edge>[] graph, int V) { // To find bridge in a graph we use tarjan's Algorithm
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        int time = 0;
        boolean[] articulationPoint = new boolean[V]; //To avoid printing same articulation point in a long graph we have track our articulation point if it's visited then we skip it.

        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                dfs(graph, i, -1, dt, low, time, vis,articulationPoint);
            }
        }
        for (int i=0;i<articulationPoint.length;i++){
            if (articulationPoint[i]){
                System.out.println("Articulation Point : "+ i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        getArticulationPoint(graph, V);
    }
}
