import java.util.*;
import java.util.LinkedList;

public class GraphB {
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

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));


        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 2, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) { // O(V+E) Depends on which is greater V or E in AL || O(V^2) AM
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) { //visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                // add all neighbour of current
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visit) { // O(V+E)
        //visited
        System.out.print(curr + " ");
        visit[curr] = true;

        //call for neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) { //false
                dfs(graph, e.dest, visit);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) { // O(V+E)
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        /*
                   (5)
               0---------1
                       / |
                 (1) /   | (3)
                   2-----3
                  |
                  |(2)
                 4
         */
//        int v = 5;
//        // int arr[] = new arr[5];
//        ArrayList<Edge>[] graph = new ArrayList[v]; // initially null(khaali) -> empty arralist
//
//        for(int i = 0; i<v; i++){
//            graph[i] = new ArrayList<>();
//        }
//
//        //0 -vertex
//        graph[0].add(new Edge(0,1,5));
//
//        //1 vertex
//        graph[1].add(new Edge(1,0,5));
//        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,3,3));
//
//        //2 vertex
//        graph[2].add(new Edge(2,1,1));
//        graph[2].add(new Edge(2,3,1));
//        graph[2].add(new Edge(2,4,2));
//
//        //3 vertex
//        graph[3].add(new Edge(3,1,3));
//        graph[3].add(new Edge(3,2,1));
//
//        //4 vertex
//        graph[4].add(new Edge(4,2,2));
//
//        //for storing info of neighbour of any vertex
//        for(int i = 0 ; i<graph[2].size();i++){
//            Edge e = graph[2].get(i);
//            System.out.println(e.dest);
//        }

        /*
                   1----3
                  /     | \
                 0      |  5 -- 6
                 \      | /
                  2-----4
         */
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
//        bfs(graph);
//        dfs(graph,0, new boolean[v]);
        System.out.println(hasPath(graph, 0, 5, new boolean[v]));
    }
}
