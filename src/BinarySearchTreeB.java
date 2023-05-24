import java.util.ArrayList;

public class BinarySearchTreeB {

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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {// value is smaller than root the search in left
            root.left = insert(root.left, val);
        } else {// value is greater than root the search in left
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
//            System.out.print(-1+" ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
//            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) { //if root become null while searching
            return false;
        }
        if (root.data == key) { // root is equal to key
            return true;
        }
        if (root.data > key) { // key is smaller than root the search in left
            return search(root.left, key);
        }
        if (root.data < key) {// key is greater than root the search in left
            return search(root.right, key);
        }
        return false;
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { //voila case : root.data==val
//            case1 ; leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
//            case 2 ; 1 child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

//            case 3 = two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        } else if (k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else { // root.data > k2
            printInRange(root.right, k1, k2);
        }

    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {
//        1. Add(Node) to Path
//        2. Left Subtree Call
//        3. right Subtree Call
//        if Leaf node condition then print PATH from root to Leaf
//        BackTrack
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node invertTree(Node root) { //O(N)
        if (root == null) {
            return root;
        }
        Node left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public static Node createArrBalBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createArrBalBST(arr, start, mid - 1);
        root.right = createArrBalBST(arr, mid + 1, end);
        return root;
    }

    public static Node bstToBalancedBST(Node root) { //O(N)
        // inorder sequence =O(N)
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrderlevelSeq(root, inOrder);

        // sorted inorder array into -> balanced BST =O(N)
        root = createBalBST(inOrder, 0, inOrder.size() - 1);
        return root;
    }

    public static void inOrderlevelSeq(Node root, ArrayList<Integer> sortedArray) {
        if (root == null) {
//            System.out.print(-1+" ");
            return;
        }
        inOrderlevelSeq(root.left, sortedArray);
        sortedArray.add(root.data);
        inOrderlevelSeq(root.right, sortedArray);
    }

    public static Node createBalBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBalBST(arr, start, mid - 1);
        root.right = createBalBST(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
//        int[] values ={8,5,3,1,4,6,10,11,14};
//        Node root = null;
//        for (int i = 0 ; i < values.length;i++) {
//            root= insert(root, values[i]);
//        }
//        inOrder(root);
//        System.out.println();
////        System.out.println(search(root,1));
////        root = delete(root,6);
////        System.out.println();
////        inOrder(root);
////        printInRange(root,5,12);
////        rootToLeaf(root, new ArrayList<>());
//        if (isValidBST(root,null,null)) {
//            System.out.println("Valid");
//        } else {
//            System.out.println("Not Valid");
//        }
//        invertTree(root);
//
//        int[] arr = {2,5,6,8,10,11,12};
//        Node root2 = createArrBalBST(arr,0,arr.length-1);
//        inOrder(root2);

        /*
                         8
                       /   \
                     6      10
                   /         \
                 5            11
               /               \
             3                 12
         */
        Node root3 = new Node(8);
        root3.left = new Node(6);
        root3.left.left = new Node(5);
        root3.left.left.left = new Node(3);
        root3.right = new Node(10);
        root3.right.right = new Node(11);
        root3.right.right.right = new Node(12);

        root3 = bstToBalancedBST(root3);
        preorder(root3);
    }
}