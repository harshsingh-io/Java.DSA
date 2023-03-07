import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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
        static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,40));


        graph[2].add(new Edge(2,3,50));
        graph[2].add(new Edge(2,0,15));

        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));

    }
    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;
        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public static int primsAlgorithm(ArrayList<Edge> []graph){
        boolean []visited = new boolean[graph.length];
        Arrays.fill(visited,false);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0,0));
        int finalCost = 0;
        while (!pq.isEmpty()){
            Pair current = pq.remove();
            if (!visited[current.vertex]){
                visited[current.vertex]=true;
                finalCost+=current.cost;
                for (int i=0; i<graph[current.vertex].size(); i++){
                        Edge e = graph[current.vertex].get(i);
                        pq.add(new Pair(e.dest,e.wt));

                }
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> []graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(primsAlgorithm(graph));
    }
}
