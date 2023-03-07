import java.util.*;
import java.util.LinkedList;

public class BinaryTreesB {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if (nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left =buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        public static void preorder(Node root){
            if (root==null){
                System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inOrder(Node root){
            if (root==null){
                System.out.print(-1+" ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        public static void postOrder(Node root){
            if (root==null){
                System.out.print(-1+" ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        //    Level Order
        public static void levelOrder(Node root){
            if(root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()){
                Node currNode = q.remove();
                if (currNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                else {
                    System.out.print(currNode.data+" ");
                    if (currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if (currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }
    public static int heightOfTree(Node root){
//            base case
            if (root == null){
                return 0;
            }
            int leftSubtreeHeight = heightOfTree(root.left);
            int rightSubTreeHeight = heightOfTree(root.right);
            return Math.max(leftSubtreeHeight,rightSubTreeHeight) + 1;
    }
    public static int countNodes(Node root){
        if (root == null) {
            return 0;
        }
        int leftSubtreeNode = countNodes(root.left);
        int rightSubTreeNode = countNodes(root.right);
        return leftSubtreeNode+rightSubTreeNode+1;
    }
    public static int daimeter2(Node root){ // O(n^2)
        if(root==null){
            return 0;
        }

        int leftDiameter = daimeter2(root.left);
        int leftHeight = heightOfTree(root.left);
        int rightDiameter = daimeter2(root.right);
        int rightHeight = heightOfTree(root.right);

        int selfDiameter = leftHeight+rightHeight+1;
        return Math.max(selfDiameter, Math.max(leftDiameter,rightDiameter));
    }
    static class Info {
        int diaM;
        int hieght;
        public Info(int diaM,int hieght){
            this.diaM = diaM;
            this.hieght = hieght;
        }
    }
    public static Info diameter(Node root){ //O(n)
        if (root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diaM,rightInfo.diaM),leftInfo.hieght+rightInfo.hieght+1);
        int height = Math.max(leftInfo.hieght, rightInfo.hieght) + 1;

        return new Info(diam,height);
    }

    public static boolean isIdentical(Node node, Node subRoot){
        if (node==null && subRoot == null){
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(node.left,subRoot.left)){
            return false;
        }
        if (!isIdentical(node.right,subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if(root==null){
            return false;
        }
        if (root.data==subRoot.data){
            if (isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
//    public static void topView(Node root){
//
//    }

    public static void kthLevelElements(Node root, int level, int k){
//        Base Case
        if (root==null){
            return;
        }
//        kaam
        if(level == k){
            System.out.print(root.data+" ");
            return;
        }
//        recursive call
        kthLevelElements(root.left,level+1,k);
        kthLevelElements(root.right,level+1,k);
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if (root==null){
            return false;
        }

        path.add(root);
        if (root.data == n){
            return true;
        }

        boolean foundleftPath = getPath(root.left, n, path);
        boolean foundrightPath = getPath(root.right, n, path);

        if (foundrightPath || foundleftPath){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){ //O(N) sc)(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

//        last common ancestor
        int i = 0; // put outside the loop to use further in Node lca
        for (; i<path1.size() && i<path2.size();i++){
            if (path1.get(i)!= path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static Node lca2(Node root,int n1,int n2){// Tc O(N) sc O(1)
        if (root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca2(root.left,n1,n2);
        Node rightLca = lca2(root.right,n1,n2);

        // leftLca = value and rightLca = null
        if (rightLca==null){
            return leftLca;
        }
        // leftLca = null and rightLca = value

        if (leftLca==null){
            return rightLca;
        }
//        if 1 value of 'n' is in leftSubtree(leftLca) and 1 is in rightSubtree(rightLca) the root itself is LCA
        return root;
    }
    public static int lcaDistance(Node root,int n){
        if (root == null){
            return -1;
        }
        if (root.data == n){
            return 0;
        }
        int leftSubtreeDistance = lcaDistance(root.left, n);
        int rightSubtreeDistance = lcaDistance(root.right,n);

        if (leftSubtreeDistance== -1&&rightSubtreeDistance == -1){
        return -1;
        }else if (leftSubtreeDistance== -1){
            return rightSubtreeDistance+1;
        } else { //(rightSubtreeDistance == -1)
            return leftSubtreeDistance+1;
        }
    }
    public static int minDist(Node root, int n1,int n2){
        Node lca = lca2(root, n1,n2);
        int distance1 = lcaDistance(lca,n1);
        int distance2 = lcaDistance(lca,n2);
        return distance1+distance2;
    }
    public static int kAncestor(Node root, int n , int k){
        if (root==null){
            return -1;
        }
        if (root.data == n){
            return 0;
        }
        int leftDistance = kAncestor(root.left,n,k);
        int rightDistance = kAncestor(root.right,n,k);

        if (leftDistance == -1 && rightDistance == -1){
            return -1;
        }
        int max = Math.max(leftDistance,rightDistance);

        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }
    public static int transformSumTree(Node root){
        if (root == null){
            return 0;
        }
        int leftChild = transformSumTree(root.left);
        int rightChild = transformSumTree(root.right);
        int data = root.data;
        int newLeft = root.left==null ? 0 : root.left.data; // when we are on leaf node we cant fetch the data of null code
        int newRight = root.right==null ? 0 : root.right.data; // when we are on leaf node we cant fetch the data of null code
        root.data = newLeft+leftChild+newRight+rightChild;
        return data;
    }
    public static void preorder(Node root){
        if (root==null){
//            System.out.print("N"+" ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static boolean isUnivalued(Node root){
        if (root == null){
            return true;
        }
//        int newLeft = root.left==null ? 0 : root.left.data; // when we are on leaf node we cant fetch the data of null code
//        int newRight = root.right==null ? 0 : root.right.data; // when we are on leaf node we cant fetch the data of null code
        if (root.left!= null && root.data != root.left.data){
            return false;
        }
        if (root.right!=null && root.data != root.right.data){
            return false;
        }
        boolean leftCond = isUnivalued(root.left);
        boolean rightCond = isUnivalued(root.right);

        return leftCond && rightCond;
    }
    public static Node invertTree(Node root){
        if (root == null){
            return null;
        }
        Node left = invertTree(root.left);
        Node rignt = invertTree(root.right);
        root.left = rignt;
        root.right = left;
        return root;
    }
    public static Node removeLeafNodes(Node root, int target){
        if (root == null){
            return root;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.data == target) {
            return null;
        }
        return root;
    }
    public static ArrayList<Node> findDuplicates(Node root){
        if (root == null){
            return null;
        }
        ArrayList<Node> duplicates = new ArrayList<>();
        if (findDuplicates(root.left)==findDuplicates(root.right)){
            duplicates.add(root);
        }
        return duplicates;
    }
    int maxPathSum(Node root) {
        int maxPath = Integer.MIN_VALUE;;
        if (root == null ){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int sum = 0;
        if (root.right == null){
            return Math.max(maxPath, root.data + root.left.data);
        }
        else if (root.left == null){
            return Math.max(maxPath, root.data + root.right.data);
        }
        else{
            sum = root.data + root.left.data + root.right.data;
            maxPath = Math.max(maxPath, sum);
            return Math.max(maxPath, Math.max(maxPathSum(root.right), maxPathSum(root.left)));
        }
    }
    public static void levelOrder(Node root){
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode == null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else {
                System.out.print(" " +currNode.data+" ");
                if (currNode.left!=null){
                    q.add(currNode.left);
                }
                if (currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
//        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//        BinaryTree tree = new BinaryTree();
//        Node root = tree.buildTree(nodes);
////        System.out.println(root.data);
//        System.out.println("preOrder");
//        tree.preorder(root);
//        System.out.println();
//        System.out.println("inOrder");
//        tree.inOrder(root);
//        System.out.println();
//        System.out.println("postOrder");
//        tree.postOrder(root);
//        System.out.println();
//        System.out.println("Level Order");
//        tree.levelOrder(root);
        /*
                    1
                  /  \
                2     3
              / \    / \
             4  5   6   7
         */
//
//        Node root = new Node(1);
//        root.left =  new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);

//        System.out.println(heightOfTree(root));
//        System.out.println(countNodes(root));
//        System.out.println(diameter2(root));
//        System.out.println(diameter(root).diaM);

        /*
             2
            / \
           4  5
         */
//        Node subRoot = new Node(2);
//        subRoot.left = new Node(4);
//        subRoot.right = new Node(5);
//
//        System.out.println(isSubtree(root,subRoot));

//        Kth Level Elements
//        kthLevelElements(root,1,3);
//
//        System.out.println(lca(root,4,7).data);
//        System.out.println(lca2(root,4,7).data);
//        System.out.println(minDist(root,4,7));
//        kAncestor(root,5,2);
//        transformSumTree(root);
//         preorder(root);

//        Node root = new Node(1);
//        root.left =  new Node(1);
//        root.right = new Node(1);
//        root.left.left = new Node(1);
//        root.left.right = new Node(1);
//        root.right.left = new Node(1);
//        root.right.right = new Node(1);
//        System.out.println(isUnivalued(root));
//        invertTree(root);
//        levelOrder(root);
//        removeLeafNodes(root, 6);
//        levelOrder(root);
                /*
                    1
                  /  \
                4     3
              /     / \
             3     4   3
                 /
                3
         */
//        Node root = new Node(1);
//        root.left =  new Node(4);
//        root.right = new Node(3);
//        root.left.left = new Node(3);
////        root.left.right = new Node(5);
//        root.right.left = new Node(3);
//        root.left.right = new Node(4);
//        root.right.left.left = new Node(3);
////        System.out.println(findDuplicates(root));
//        levelOrder(root);

//        Node root = new Node(-10);
//        root.left = new Node(9);
//        root.right = new Node(20);
//        root.right.left = new Node(15);
//        root.right.right = new Node(7);
//        System.out.println(maxPathSum(root));
//
//        Node root2 = new Node(2);
//        System.out.println(maxPathSum(root2));
//
//        Node root3 = new Node(1);
//        root3.left = new Node(2);
//        root3.right = new Node(3);
//        System.out.println(maxPathSum(root3));
//
//        Node root4 = new Node(3);
//        root4.left = new Node(4);
//        System.out.println(maxPathSum(root4));


    }
}
