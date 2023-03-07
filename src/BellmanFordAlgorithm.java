import java.util.ArrayList;

public class BellmanFordAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
//    static void createGraph(ArrayList<Edge> graph[]){
//        for (int i=0; i< graph.length; i++){
//            graph[i]=new ArrayList<>();
//        }
//        graph[0].add(new Edge(0,1,2));
//        graph[0].add(new Edge(0,2,4));
//
//        graph[1].add(new Edge(1,2,-4));
//
//        graph[2].add(new Edge(2,3,2));
//
//        graph[3].add(new Edge(3,4,4));
//
//    }

    static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));

    }

    //    public static void bellmanFord(ArrayList<Edge> []graph, int src){
//        int[] dist = new int[graph.length];
//        for (int i=0; i< dist.length; i++){
//            if (i != src){
//                dist[i] = Integer.MAX_VALUE;
//            }
//        }
//        int V = graph.length;
//        //Algorithm
//        // O(V*E)
//        for (int i=0; i< V-1; i++){
//            //edge - O(E)
//            for (int j=0; j< graph.length; j++){
//                for (int k=0; k<graph[j].size(); k++){
//                    Edge e = graph[j].get(k);
//                    //u,v,wt
//                    int u = e.src;
//                    int v = e.dest;
//                    int wt = e.wt;
//                    if (dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]) { // in java if something added in infinity value then it makes the value negative therefore dist[u] != Integer.MAX_VALUE
//                        dist[v] = dist[u]+wt;
//                    }
//                }
//            }
//        }
//        //print
//        for (int i = 0; i<dist.length; i++){
//            System.out.print(dist[i]+" ");
//        }
//        System.out.println();
//    }
    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int[] dist = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        //Algorithm
        // O(V*E)
        for (int i = 0; i < V - 1; i++) { //O(V)
            //edge - O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);
                //u,v,wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) { // in java if something added in infinity value then it makes the value negative therefore dist[u] != Integer.MAX_VALUE
                    dist[v] = dist[u] + wt;
                }
            }
        }

        //print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
//        ArrayList<Edge> []graph = new ArrayList[V];
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        bellmanFord(graph, 0, V);
    }
}
