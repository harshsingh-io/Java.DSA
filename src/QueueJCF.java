import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class QueueJCF {
//    static class Stack{
//        static Queue<Integer> q1 = new LinkedList<>();
//        static Queue<Integer> q2 = new LinkedList<>();
//        public static boolean isEmpty(){
//            return q1.isEmpty() && q2.isEmpty();
//        }
//        public static void push(int data){
//            if (!q1.isEmpty()){
//                q1.add(data);
//            } else {
//                q2.add(data);
//            }
//        }
//        public static int pop(){
//            if (isEmpty()){
//                System.out.println("Empty Stack");
//                return-1;
//            }
//            int top = -1;
////            case 1
//            if (!q1.isEmpty()){
//                while(!q1.isEmpty()){
//                    top = q1.remove();
//                    if (q1.isEmpty()){
//                        break;
//                    }
//                    q2.add(top);
//                }
////                case 2
//            }else{
//                while(!q2.isEmpty()){
//                    top = q2.remove();
//                    if (q2.isEmpty()){
//                        break;
//                    }
//                    q1.add(top);
//                }
//            }
//            return top;
//        }
//        public static int peek(){
//            if (isEmpty()){
//                System.out.println("Empty Stack");
//                return -1;
//            }
//            int top = -1;
//            if (!q1.isEmpty()){
//                while(!q1.isEmpty()){
//                    top = q1.remove();
//                    q2.add(top);
//                }
//            }else{
//                while(!q2.isEmpty()){
//                    top = q2.remove();
//                    q2.add(top);
//                }
//            }
//            return top;
//        }
//    }

//    public static void printNonRepeating(String str){
//        int[] freq = new int[26];
//        Queue<Character> q = new LinkedList<>();
//        for (int i = 0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            q.add(ch);
//            freq[ch-'a']++;
//
//            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
//                q.remove();
//            }
//
//            if (q.isEmpty()){
//                System.out.print(-1 + " ");
//            }else {
//                System.out.print(q.peek()+" ");
//            }
//        }
//        System.out.println();
//    }

//     interleave 2 Halves  of a Queue(even length)
//     public static void interLeave(Queue<Integer> q){
//        int size = q.size();
//        Queue<Integer> firstHalf = new LinkedList<>();
//        for (int i = 0; i<size/2;i++){
//            firstHalf.add(q.remove());
//        }
//        while (!firstHalf.isEmpty()){
//            q.add(firstHalf.remove());
//            q.add(q.remove());
//        }
//     }
//     public static void reverseQueue(Queue<Integer> q){
//         Stack<Integer> s = new Stack<>();
//         while (!q.isEmpty()){
//             s.push(q.remove());
//         }
//         while (!s.isEmpty()){
//             q.add(s.pop());
//         }
//     }
    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>(); //ArrayDeque
//        Queue<Integer> q = new ArrayDeque<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//        }
//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        while (!s.isEmpty()){
//            System.out.println(s.peek());
//            s.pop();
//        }

//        String str = "aabccxb";
//        printNonRepeating(str);
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
////        interLeave(q);
//        reverseQueue(q);
//        while (!q.isEmpty()) {
//            System.out.print(q.remove() + " ");
//        }
//        System.out.println();

//        Queue<String> q = new LinkedList<String>();
//        q.add("1");
//        String s1 = q.peek();
//        q.remove();
//        q.add(s1+"0");
//        while (!q.isEmpty()){
//            System.out.print(q.remove());
//        }

    }
}
