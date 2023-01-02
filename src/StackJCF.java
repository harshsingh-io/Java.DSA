import java.util.*;
public class StackJCF {
//    push stack from bottom
    public static void pushBottom(Stack<Integer> s, int data){
//        base condition
        if (s.isEmpty()){
            s.push(data);
            return;
        }
//        recursive step
        int top = s.pop();
        pushBottom(s,data);
        s.push(top);
    }
//    Reverse a String using a Stack
    public static String reverseString(String str){
//        kaam
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()){
            char curr = s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }

//    reverse a stack
    public static void reverseStack(Stack<Integer> s){
        //base condition
        if (s.isEmpty()){
            return;
        }
//        kaam
        int top = s.pop();
        reverseStack(s);
        pushBottom(s,top);
    }
    //    stock span
    public static void stockSpan(int[]stock,int[]span){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1 ; i < stock.length ; i++){
            int currPrice = stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }

//     valid Parenthesis Code
    public static boolean isValid(String str){ //O(n)
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            //opening
            if(ch == '(' ||ch == '{' ||ch == '['){
                s.push(ch);
            }
            //closing
            else{
                // 1 -> ")))))"
                if(s.isEmpty()){
                return false;
                }
                // pair condition
                if ( (s.peek() == '(' && ch == ')') || // ()
                 (s.peek() == '{' && ch == '}') || // {}
                 (s.peek() == '[' && ch == ']') ){ // []
                    s.pop();
                }
                else {
                return false;
                }
            }
        }
        if (s.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

//    Duplicate Parenthesis
    public static boolean isDuplicate(String str){ // O(n)
        Stack<Character> s = new Stack<>();
        for (int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);

            // closing bracket
            if (ch == ')'){
                    int count = 0 ;
                while (s.peek() != '('){
                    s.pop();
                    count++;
                }
                if (count < 1){
                    return true; // for duplicate parenthesis
                }
                else {
                    s.pop();  // for removing opening pairs
                }
            }
//            for opening parenthesis, operands, operators
            else {
                s.push(ch);
            }
        }
        return false;
    }

//    Max Area Of Histogram's Rectangle
    public static void maxArea(int[] arr){
        int maxArea = 0 ;
        int [] nsl = new int[arr.length];
        int [] nsr = new int[arr.length];

        Stack<Integer> s = new Stack<>();
//        For next smaller left
        for (int i = 0; i<arr.length ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsl[i] = -1;
            }else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

//        For next smaller right
        s = new Stack<>();
        for (int i = arr.length-1; i>= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsr[i] = arr.length;
            }else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
//        Maximum area of rectangle formed in histogram
        for (int i = 0; i < arr.length ; i++){
            int height = arr[i];
//            for width j-i-1 -> nsr[i] - nsl[j] - 1
            int width = nsr[i] - nsl[i] - 1;
            int currArea =  height*width;
            maxArea = Math.max(currArea,maxArea);
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        Stack<Integer> sl = new Stack<>();
        sl.push(1);
        sl.push(4);
        sl.push(3);
        sl.push(5);
        sl.push(6);
//        in Stack 6,5,3,4,1

//        while(!sl.isEmpty()) {
//            System.out.print(sl.peek());
//            sl.pop();
//        }

//        pushBottom(sl,9);
//        while(!sl.isEmpty()) {
//            System.out.println(sl.peek());
//            sl.pop();
//        }

//        String str = "HarshSingh";
//        System.out.println(reverseString(str));
//        reverseStack(sl);
////        after reversing -> 1,4,3,5,6
//        while(!sl.isEmpty()) {
//            System.out.println(sl.peek());
//            sl.pop();
//        }
        //stock and span
//        int stock[] = {100,80,60,70,60,85,100};
//        int span[] = new int[stock.length];
//        stockSpan(stock,span);
//        for (int i = 0 ; i < span.length ; i++ ){
//            System.out.print(span[i]+" ");
//        }

//        imp***
//        int arr[] = {6,8,0,1,3};
//        Stack<Integer> stack = new Stack<>();
//        int[] nextGreater = new int[arr.length];
//
//        for (int i = arr.length-1; i>=0 ; i--){
////            1-> while
//            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
//                stack.pop();
//            }
////            2-> id-else
//            if (stack.isEmpty()) {
//                nextGreater[i] = -1;
//            } else {
//                nextGreater[i] = arr[stack.peek()];
//            }
////            3-> push in Stack
//            stack.push(i);
//        }
//        for (int i = 0 ; i < nextGreater.length ; i++){
//            System.out.print(nextGreater[i] + " ");
//        }
//        System.out.println();

//        variations of this Question
//        nextGreater Right i: n-1 to 0 :  while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
//        nextGreater Left i: 0 to n-1 :  while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
//        nextSmaller Right i: n-1 to 0 ; while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
//        nextSmaller Left i: 0 to n-1 : while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])

////        valid Parenthesis Code
//        String str = "((){}[])"; // true
//        System.out.println(isValid(str));

        // Duplicate pairs
        //duplicate paranthesis
//        String str = "((a+b)+(c+d))"; // false
//        String str2 = "(((a+b))+c)"; // true
//        System.out.println(isDuplicate(str));
//        System.out.println(isDuplicate(str2));

        // Max Area of histogram of rectangle
//        int[] height = {2,1,5,6,2,3};
//        maxArea(height);

    }
}