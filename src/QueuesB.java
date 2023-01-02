import java.util.Stack;

public class QueuesB {
//    static  class Queue{
//        static int arr[];
//        static int size;
//        static int rear;
//        Queue(int n) {
//            arr = new int[n];
//            size = n;
//            rear = -1;
//        }
////        to check weather is empty or not ?
//        public static boolean isEmpty(){
//            return rear == -1;
//        }
////        add function
//        public static void add(int data){
//            if (rear == size-1){
//                System.out.println("queue is full");
//                return;
//            }
//            rear = rear +1;
//            arr[rear] = data;
//        }
//
////        remove function one by one
//        public static int remove(){
//            if (isEmpty()){
//                System.out.println("Empty Queue");
//                return -1;
//            }
//            int front = arr[0];
//            for (int i=0; i<rear; i++){
//                arr[i] = arr[i+1];
//            }
//            rear = rear-1;
//            return  front;
//        }
//
////        peek
//        public static int peek(){
//            if (isEmpty()){
//                System.out.println("Empty Queue");
//                return -1;
//            }
//            return arr[0];
//        }
//    }
//
    // FOR ARRAY IN A CIRCULAR QUEUE
/*    static int arr[];
    static int size;
    static int rear;

    //        for circular array front can be change
    static int front;
    Queue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
    }
    //        to check weather is empty or not ?
    public static boolean isEmpty(){
        return rear == -1;
    }
    //        add function
    public static void add(int data){
        if (rear == size-1){
            System.out.println("queue is full");
            return;
        }
        rear = rear +1;
        arr[rear] = data;
    }

    //        remove function one by one
    public static int remove(){
        if (isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        int front = arr[0];
        for (int i=0; i<rear; i++){
            arr[i] = arr[i+1];
        }
        rear = rear-1;
        return  front;
    }

    //        peek
    public static int peek(){
        if (isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        return arr[0];
    }
}*/

//        For LinkedList
//    static class Node {
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//    static class Queue {
//        static Node head = null;
//        static Node tail = null;
//
//        //        to check weather is empty or not ?
//        public static boolean isEmpty(){
//            return head == null && tail == null;
//        }
//        //        add function
//        public static void add(int data){
//            Node newNode= new Node(data);
//            if (head == null){
//                head = tail = newNode;
//                return;
//            }
//            tail.next = newNode;
//            tail = newNode;
//        }
//
//    //        remove function one by one
//        public static int remove(){
//            if (isEmpty()) {
//                System.out.println("Empty Queue");
//                return -1;
//            }
//            int front = head.data;
//            if(tail == head) {
//                tail = head = null;
//            }
//            else {
//                head = head.next;
//            }
//            return front;
//        }
//
//    //        peek
//        public static int peek(){
//            if (isEmpty()) {
//                System.out.println("Empty Queue");
//                return -1;
//            }
//            return head.data;
//        }
//    }
    //    Queue using Two Stacks when push = O(n)
//    static class Queue{
//        static Stack<Integer> s1 = new Stack<>();
//        static Stack<Integer> s2 = new Stack<>();
//
////        isEmpty
//        public static boolean isEmpty() {
//            return s1.isEmpty();
//        }
////        add -> O(n)
//        public static void add(int data){
////            1. S1 -> S2
//            while(!s1.isEmpty()){
//                s2.push(s1.pop());
//            }
////            2. S1.push data
//            s1.push(data);
////            3. S2 -> S1
//            while (!s2.isEmpty()){
//                s1.push(s2.pop());
//            }
//        }
//
////        remove
//        public static int remove(){
//            if (isEmpty()){
//                System.out.println("Queue is Empty");
//                return -1;
//            }
//            return s1.pop();
//        }
//        public static int peek(){
//            if (isEmpty()){
//                System.out.println("Queue is Empty");
//                return -1;
//            }
//            return s1.peek();
//        }
//    }

    //    Queue using Two Stacks when pop = O(n)

//    static class Queue{
//        static Stack<Integer> s1 = new Stack<>();
//        static Stack<Integer> s2 = new Stack<>();
//
//        //        isEmpty
//        public static boolean isEmpty() {
//            return s1.isEmpty();
//        }
//        //        add -> O(n)
//        public static void add(int data){
//            s1.push(data);
//        }
//
//        //        remove
//        public static int remove(){
////            1. S1 -> S2
//            while(!s1.isEmpty()){
//                s2.push(s1.pop());
//            }
////            2. S1.push data
//            int ans = s2.pop();
////            3. S2 -> S1
//            while (!s2.isEmpty()){
//                s1.push(s2.pop());
//            }
//            return ans;
//        }
//        public static int peek(){
//            if (isEmpty()){
//                System.out.println("Queue is Empty");
//                return -1;
//            }
////            1. S1 -> S2
//            while(!s1.isEmpty()){
//                s2.push(s1.pop());
//            }
////            2. S1.push data
//            int ans = s2.peek();
////            3. S2 -> S1
//            while (!s2.isEmpty()){
//                s1.push(s2.pop());
//            }
//            return ans;
//        }
//    }
    public static void main(String[] args) {
//        Queue q = new Queue();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//        }
    }
}

