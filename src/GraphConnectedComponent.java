import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphConnectedComponent {
        static class Edge{
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
        for(int i = 0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));


        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,2,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

    }

    static void createGraphCycle(ArrayList<Edge>[] graph) {
        for(int i = 0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
//        graph[0].add(new Edge(0,2,1));
        graph[0].add(new Edge(0,3,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,2,1));

//        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,1,1));

        graph[3].add(new Edge(3,0,1));
        graph[3].add(new Edge(3,4,1));

        graph[4].add(new Edge(4,3,1));
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis) { // O(V+E) Depends on which is greater V or E in AL || O(V^2) AM
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) { //visit curr
                System.out.print(curr+" ");
                vis[curr] = true;
                // add all neighbour of current
                for (int i = 0 ; i < graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for (int i=0; i<graph.length; i++){
            if (!visited[i]){
                bfsUtil(graph,visited);
            }
        }

    }
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visit){ // O(V+E)
        //visited
        System.out.print(curr+" ");
        visit[curr] = true;

        //call for neighbours
        for (int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]){ //false
                dfsUtil(graph, e.dest, visit);
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph){
            boolean[] visited = new boolean[graph.length];
            for (int i = 0 ; i < graph.length ; i++){
                dfsUtil(graph,i,visited);
            }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){ // O(V+E)
            boolean[] visited = new boolean[graph.length];
            for (int i=0; i< graph.length;i++){ //for connected component we put this loop
                if (!visited[i]){
                    if(detectCycleUtil(graph,i,visited,-1)){
                        return true;
                        //Cycle exists in one of the parts
                    }
                }
            }
            return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, int parent){
        visited[curr]=true;
        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            // case 3
            if (!visited[e.dest]){
                if (detectCycleUtil(graph,e.dest,visited,curr)) {
                    return true;
                }
            }
            //case 1
            else if (visited[e.dest] && e.dest!=parent){
                return true;
            }
            //case 2 - do nothing or continue

        }
        return false;
    }
    public static void main(String[] args) {
        /*
             0-------3
            /|       |
          /  |      |
        1    |     4
        \   |
         \ |
          2
         */
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraphCycle(graph);
        System.out.println(detectCycle(graph));
    }
}
