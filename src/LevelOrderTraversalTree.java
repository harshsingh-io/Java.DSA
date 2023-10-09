import java.util.*;
import java.util.LinkedList;

class TreeNode{
    //    val
    // left  right
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LevelOrderTraversalTree {
    private static TreeNode root = null;


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        //using queue to perform bfs traversal
        Queue<TreeNode> q = new LinkedList<>();

        //push root to queue
        q.offer(root);

        while(!q.isEmpty()){

            //finding the len of current queue
            int len = q.size();
            List<Integer> curLevelList = new ArrayList<>();
            
            //iterating on len -> gets all the nodes on same level
            for(int i=0; i<len; i++){
                //push left, if present
                if(q.peek().left!=null) q.add(q.peek().left);
                //push right, if present
                if(q.peek().right!=null) q.add(q.peek().right);
                
                //add to cur level list
                curLevelList.add(q.poll().val);
            }
            
            //finally add by level
            res.add(curLevelList);
        }

        return res;
    }
    public static void main(String[] args) {
        
        root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        List<List<Integer>> printLevels = levelOrder(root);

        for(List<Integer> list: printLevels){
            System.out.println(list);
        }
    }


}
