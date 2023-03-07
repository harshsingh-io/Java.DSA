import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlights {
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

    static void createGraph(int[][] flight, ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class FlightInfo {
        int vertex;
        int cost;
        int stops;

        public FlightInfo(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(int n, int[][] flights, int src, int dest, int k) { // O(V+ElogV) -> Priority Queue
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) { //dis[i] -> src to i
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; //+infinity for neighbour of src
            }
        }
//        boolean[] vis = new boolean[graph.length];
        Queue<FlightInfo> pq = new LinkedList<>();
        pq.add(new FlightInfo(src, 0, 0));
        //loop
        while (!pq.isEmpty()) {
            FlightInfo curr = pq.remove();
            if (curr.stops > k) {
                break;
            }
            //neighbours ke liye check karlo
            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    pq.add(new FlightInfo(v, dist[v], curr.stops + 1));
                }
            }
        }
        //distance[destination]
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }


    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {1, 3, 600}, {2, 0, 100}, {2, 3, 200}};
        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}

