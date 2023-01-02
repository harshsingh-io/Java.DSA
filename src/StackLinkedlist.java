public class StackLinkedlist {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack{
        static Node head = null;
//        check the ll is empty or not
        public static boolean isEmpty(){
            return head==null;
        }
//        push
        public static void push(int data){
            Node newNode = new Node(data);
            if (isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
//        pop
        public static int pop(){
            if (isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
//        peek
        public static int peek(){
            if (isEmpty()){
                return -1;
            }
            int top = head.data;
            return top;
        }
    }
    public static void main(String[] args) {
        Stack sl = new Stack();
        sl.push(1);
        sl.push(4);
        sl.push(3);
        sl.push(5);
        sl.push(6);

        while(!sl.isEmpty()){
            System.out.print(sl.peek());
            sl.pop();
        }
    }
}
