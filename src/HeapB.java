import java.util.*;
public class HeapB {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last index
            arr.add(data);
            int x = arr.size()-1; // child index
            int parent = (x-1)/2; // parent index

            while(arr.get(x) < arr.get(parent)){ //O(log n)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent)); //(index,data)
                arr.set(parent, temp);
                x=parent;
                parent=(x-1)/2;
            }
        }
        public int peak() {
            return arr.get(0);
        }
        private void heapify(int i){ // O(log n)
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if (left<arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if (minIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove() {
            int data = arr.get(0);

            //step 1 - swap first & last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2 - delete last
            arr.remove(arr.size()-1);

            //step 3 - heapify / fix heap
            heapify(0);
            return data;
        }
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }
    static class MaxHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last index
            arr.add(data);
            int x = arr.size()-1; // child index
            int parent = (x-1)/2; // parent index

            while(arr.get(x) > arr.get(parent)){ //O(log n)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent)); //(index,data)
                arr.set(parent, temp);
                x=parent;
                parent=(x-1)/2;
            }
        }
        public int peak() {
            return arr.get(0);
        }
        private void heapify(int i){ // O(log n)
            int left = 2*i+1;
            int right = 2*i+2;
            int maxIdx = i;

            if (left<arr.size() && arr.get(maxIdx) < arr.get(left)) {
                maxIdx = left;
            }
            if (right < arr.size() && arr.get(maxIdx) < arr.get(right)){
                maxIdx = right;
            }
            if (maxIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);

                heapify(maxIdx);
            }
        }
        public int remove() {
            int data = arr.get(0);

            //step 1 - swap first & last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2 - delete last
            arr.remove(arr.size()-1);

            //step 3 - heapify / fix heap
            heapify(0);
            return data;
        }
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {

        // Heap is basically same as Priority Queue or we can say that Priority Queue which we implemented from JCF is made by this heap
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()){
            System.out.println(h.peak());
            h.remove();
        }
        System.out.println();
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(5);
        while (!maxHeap.isEmpty()){ //Heap Sort - P(nlogn)
            System.out.println(maxHeap.peak());
            maxHeap.remove();
        }
    }
}
