class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
class Res {
    public int val;
}
class Solution {
    Node root;
    int findMaxUtil(Node node, Res res) {
        if (node == null)
            return 0;
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);
        int max_single = Math.max(Math.max(l, r) + node.data, node.data);
        int max_top = Math.max(max_single, l + r + node.data);
        res.val = Math.max(res.val, max_top);
        return max_single;
    }
    int findMaxSum() {
        return findMaxSum(root);
    }
    int findMaxSum(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        findMaxUtil(node, res);
        return res.val;
    }
    public static void main(String args[]) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                tree.findMaxSum());
    }
}

