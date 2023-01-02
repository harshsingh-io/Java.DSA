import java.util.*;
import java.util.LinkedList;

public class DequeB {
//    DEQUE-> Double Ended QUEue  // Dequeue -> verb, action, method which means to remove
    static class Stack{// Creating Stack using deque
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getFirst();
        }
}
    static class Queue{
        Deque<Integer> deque = new LinkedList<>();
        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
//        Deque is Interface
//        Deque<Integer> deque = new LinkedList<>();
//        deque.addFirst(1); //1
//        deque.addLast(2); //2 1
//        deque.addFirst(3); //3 1 2
//        System.out.println(deque);
//        deque.removeFirst();  //12
//        System.out.println("last element = " + deque.getLast());
//        System.out.println("first element = " + deque.getFirst());

//        Stack using deque
//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());

//        Queue using Deque
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek = " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
