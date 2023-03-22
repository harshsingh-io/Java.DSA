
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
    static class HashMap<K, V> {
        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n
        private int N;
        // just like private int arr[];
        private LinkedList<Node>[] buckets; //N = buckets.length
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N =4;
            this.buckets = new LinkedList[4];// bucket n initialised
            for (int i=0; i<buckets.length;i++){ // initialised empty linkedlist in every index
                this.buckets[i]= new LinkedList<>();
            }
        }
        public int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%N;
            //for getting index  from 0 to n-1(3) we have to take hashcode Modulo with n
            // agar kisi ka bhi modulo 4 ya n ke sath le to value 0 se leke n-1 tak hi ati hai

        }
        private int SearchLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di=0;
            for (int i=0; i<ll.size();i++){
                Node node= ll.get(i);
                if (node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N=2*N;
            for (int i = 0; i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
            //nodes -> add in new bucket
            for (int i=0;i<oldBuck.length;i++){
                LinkedList<Node> ll = oldBuck[i];
                for (int j=0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key); // index 0-n-1(3)
            int di = SearchLL(key, bi);

            if (di != -1){
                Node node =buckets[bi].get(di);
                node.value = value;
            }else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n/N;
            if (lambda>2.0){ // 2.0 is the threshold value
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key); // index 0-n-1(3)
            int di = SearchLL(key, bi);

            if (di != -1){
                return true;
            }else {
                return false;
            }
        }
        public V get(K key){
            int bi = hashFunction(key); // index 0-n-1(3)
            int di = SearchLL(key, bi);

            if (di != -1){
                Node node =buckets[bi].get(di);
                return node.value;
            }else {
                return null;
            }
        }
        public V remove(K key){
            int bi = hashFunction(key); // index 0-n-1(3)
            int di = SearchLL(key, bi);

            if (di != -1){
                Node node =buckets[bi].remove(di);
                n--;
                return node.value;

            }else {
                return null;
            }
        }
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for (Node node:ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for (String key: keys){
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}
