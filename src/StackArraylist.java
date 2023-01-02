import java.util.ArrayList;
import java.util.Stack;

public class StackArraylist {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
//        to check arraylist is empty or not
        public static boolean isEmpty(){
            return list.size()==0;
        }
//        push in Stack
        public static void push(int data){
            list.add(data);
        }
//        pop in Stack
        public static int pop(){
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
//        peek in Stack - jhaakna
        public static int peek(){
            int top = list.get(list.size()-1);
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        s.push(4);
        s.push(9);
        while (!s.isEmpty()){
            System.out.print(s.peek());
            s.pop();
        }
        s.push(80);
        System.out.println();
        System.out.println(s.peek());
    }
}