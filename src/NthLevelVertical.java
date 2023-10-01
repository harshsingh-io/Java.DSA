// code to find elements at Nth level vertically
import java.util.*;

public class NthLevelVertical{

static class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
static void printTree(Node root){
    if(root == null){
        return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        Node curr = q.poll();
        System.out.print(curr.data + " ");
        if(curr.left != null){
            q.add(curr.left);
        }
        if(curr.right != null){
            q.add(curr.right);
        }
    }
}
static int left(Node root){
    if (root ==null) return 0;
    return 1 + left(root.left);
}
static int right(Node root){
    if (root ==null) return 0;
    return 1 + right(root.right);
}
public static void main(String[] args) {
    //construct a tree
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left  = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    root.right.right.right = new Node(9);
    root.right.right.left= new Node(10);
    root.right.right.left.right= new Node(11);
    root.right.right.left.right.right= new Node(12);

    //print the tree
    printTree(root);
    int leftCount = left(root);
    int rightCount = right(root);
    System.out.println("left count: " + leftCount);
    System.out.println("right count: " + rightCount);

    //print vertical order
    for (int i=1-leftCount; i<=rightCount-1; i++){
        printVertical(root, i, 0);
        System.out.println();
    }

}
private static void printVertical(Node root, int givenLevel, int currentLevel) { // curretlevel is root's level
 if(root==null) return;
    if(givenLevel == currentLevel){
        System.out.print(root.data + " ");
        return; // if we dont return here, it will print all the nodes at that level and if we want to print only one node, we need to return
    }
    printVertical(root.left, givenLevel, currentLevel-1);
    printVertical(root.right, givenLevel, currentLevel+1);

}

}
