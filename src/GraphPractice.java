import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphPractice {
    static void addEdge(ArrayList<Integer> graph[], int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean detectCycleUtilBFS(ArrayList<Integer>[] graph, int curr, boolean[] visited, int V) {
        int parent[] = new int[V];

        Queue<Integer> q = new LinkedList<>();
        visited[curr] = true;
        q.add(curr);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < graph[u].size(); i++) {
                int v = graph[u].get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleBFS(ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false); // we are marking false in all
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtilBFS(graph, i, visited, graph.length)) {
                    return true;
                    //Cycle exists in one of the parts
                }
            }
        }
        return false;
    }

    //    Find Minimum Depth of a Binary Tree
//    public static int minimumDepth(Node root){ // this is going to traverse whole binary tree
//        if (root == null){
//            return 0;
//        }
//        // If the root has no children, the minimum depth is 1
//        if (root.left == null && root.right == null){
//            return 1;
//        }
//        // If the root has only one child, return the minimum depth of the child subtree
//        if (root.left==null){
//            return minimumDepth(root.right)+1 ; // Depth of right subtree from root
//
//        }
//        if (root.right==null){
//            return minimumDepth(root.left)+1; // Depth of left subtree from root
//
//        }
//        // If the root has two children, return the minimum depth of the two subtrees
//        return Math.min(minimumDepth(root.left),minimumDepth(root.right)) + 1; // returned the minimum of left subtree depth and right subtree depth
//
//        // we +1 minimum of left and right subtree depth. so it gives the depth of itself to parent node by adding 1 in minimum of left and right subtree depth
//    }
    public static int minimumDepth(Node root) { // this is going to traverse level order and trigger level wise if the node has no child
        int minDepth = 0;
        if (root == null) {
            return minDepth;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            minDepth++;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node currNode = q.remove();
                if (currNode.left == null && currNode.right == null) {
                    return minDepth;
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
            }
        }
        return minDepth;
    }
    // structure for storing coordinates of the cell
    static class Cordinates {
        int i = 0;
        int j = 0;

        public Cordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    // Function to check whether the cell is delimiter
    // which is (-1, -1)
    static boolean isDelimiter(Cordinates temp) {
        return (temp.i == -1 && temp.j == -1);
    }
    // function to check whether a cell is valid / invalid
    static boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    public final static int R = 3;
    public final static int C = 5;
    // Function to check whether there is still a fresh
    // orange remaining
    static boolean checkAll(int arr[][]) {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }
    // This function finds if it is possible to rot all
    // oranges or not. If possible, then it returns minimum
    // time required to rot all, otherwise returns -1
    public static int orangesRotting(int[][] grid) {
        // Create a queue of cells
        Queue<Cordinates> queue = new LinkedList<>();
        Cordinates curr;
        int ans = 0;
        // Store all the cells having rotten orange in first
        // time frame
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cordinates(i, j));
                }
            }
        }
        // Separate these rotten oranges from the oranges
        // which will rotten due the oranges in first time
        // frame using delimiter which is (-1, -1)
        queue.add(new Cordinates(-1, -1));
        while (!queue.isEmpty()) {
            // This flag is used to determine whether even a
            // single fresh orange gets rotten due to rotten
            // oranges in the current time frame so we can
            // increase the count of the required time.
            boolean flag = false;
            // Process all the rotten oranges in current
            // time frame.
            while (!isDelimiter(queue.peek())) {
                curr = queue.peek();
                // Check right adjacent cell that if it can
                // be rotten
                if (isValid(curr.i + 1, curr.j) && grid[curr.i + 1][curr.j] == 1) {
                    // if this is the first orange to
                    // get rotten, increase count and
                    // set the flag.
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    // Make the orange rotten
                    grid[curr.i + 1][curr.j] = 2;
                    // push the adjacent orange to Queue
                    curr.i++;
                    queue.add(new Cordinates(curr.i, curr.j));
                    // Move back to current cell
                    curr.i--;
                }
                //Left Adjacent Cell
                if (isValid(curr.i - 1, curr.j) && grid[curr.i - 1][curr.j] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    grid[curr.i - 1][curr.j] = 2;
                    curr.i--;
                    queue.add(new Cordinates(curr.i, curr.j));
                    curr.i++;
                }
                //Top Adjacent Cell
                if (isValid(curr.i, curr.j + 1) && grid[curr.i][curr.j + 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    grid[curr.i][curr.j + 1] = 2;
                    curr.j++;
                    queue.add(new Cordinates(curr.i, curr.j));
                    curr.j--;
                }
//                Bottom Adjacent Cell
                if (isValid(curr.i, curr.j - 1) && grid[curr.i][curr.j - 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    grid[curr.i][curr.j - 1] = 2;
                    curr.j--;
                    queue.add(new Cordinates(curr.i, curr.j));
                }
                queue.remove();
            }
            // Pop the delimiter
            queue.remove();
            // If oranges were rotten in current frame than
            // separate the rotten oranges using delimiter
            // for the next frame for processing.
            if (!queue.isEmpty()) {
                queue.add(new Cordinates(-1, -1));
            }
            // If Queue was empty than no rotten oranges
            // left to process so exit
        }
        // Return -1 if all arranges could not rot,
        // otherwise ans
        return (checkAll(grid)) ? -1 : ans;
    }


    public static void main(String[] args) {
//        int V = 4;
//        ArrayList<Integer> graph[] = new ArrayList[V];
//        for (int i = 0; i < 4; i++) graph[i] = new ArrayList<Integer>();
//        addEdge(graph, 0, 1);
//        addEdge(graph, 1, 2);
//        addEdge(graph, 2, 0);
//        addEdge(graph, 2, 3);
//
//        System.out.println(detectCycleBFS(graph));

                        /*
                    1
                  /  \
                8     2
              / \    /
            6    5 9
         */
//        Node root = new Node(1);
//        root.left = new Node(8);
//        root.right = new Node(2);
//        root.left.left = new Node(6);
//        root.left.right = new Node(5);
//        root.right.left = new Node(9);
//        System.out.println(minimumDepth(root) - 1);

         /*
         2 1 0 2 1
         0 0 1 2 1
         1 0 0 2 1
          */
        int arr[][] = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        System.out.println(orangesRotting(arr));
    }
}
