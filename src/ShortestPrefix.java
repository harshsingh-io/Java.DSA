import java.util.Arrays;

public class ShortestPrefix {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            Arrays.fill(children, null);
            freq = 1;
        }
    }
    public static void insert(String word){
        Node curr=root;
        for (int level=0; level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if (curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            else {
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static void shortestPrefix(Node root,String ans){ //O(L) where l is level in my trie or longest word
        if (root==null){
            return;
        }
        if (root.freq==1){
            System.out.println(ans);
            return;
        }
        for (int i=0;i<root.children.length;i++){
            if (root.children[i]!=null){
                shortestPrefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }

    public static Node root = new Node();
    public static void main(String[] args) {
        String[] arr = {"zebra","dog","duck","dove"};
        for (int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        root.freq=-1;
        shortestPrefix(root,""); //answer will be in alphatical order because by default trie me string alphabatically store hote hai
    }
}
