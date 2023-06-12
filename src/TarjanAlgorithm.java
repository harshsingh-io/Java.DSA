import java.util.ArrayList;

public class TarjanAlgorithm {
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
        graph[3].add(new Edge(3, 5, 1));


        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par,
                           int[] dt, int[] low, boolean[] vis, int time) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // e.src ---- e.dest
            int neighbour = e.dest;
            if (neighbour == par) {
                continue;
            } else if (!vis[neighbour]) {
                dfs(graph, neighbour, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neighbour]);
                if (dt[curr] < low[neighbour]) {
                    System.out.println("Bridge : " + curr + " ---- " + neighbour);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
        }
    }

    public static void tarjanAlgo(ArrayList<Edge>[] graph, int V) { // To find bridge in a graph we use tarjan's Algorithm
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];

        int time = 0;

        for (int i = 0; i < V; i++) {
            dfs(graph, i, -1, dt, low, vis, time);
        }
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        tarjanAlgo(graph, V);
    }
}