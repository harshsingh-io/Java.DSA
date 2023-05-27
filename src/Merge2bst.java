import java.util.ArrayList;

public class Merge2bst {
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
    public static void getInorder(Node root, ArrayList<Integer> arr){
        if (root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right,arr);
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
    public static Node mergeBSTs(Node root1, Node root2){
        //step 1
        ArrayList<Integer> arr1= new ArrayList<>();
        getInorder(root1, arr1);

        //step 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //merge
        int i=0,j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i<arr1.size()&&j<arr2.size()){
            if (arr1.get(i)<= arr2.get(i)){
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        //sorted arraylist to -> BST
        return createBalBST(finalArr,0,finalArr.size()-1);
    }
    public static void preorder(Node root) {
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        /*
                2
               / \
              1   4
              BST1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
                9
              /  \
             3    12
             BST2
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        Node root = mergeBSTs(root1,root2);
        preorder(root);
    }
}
