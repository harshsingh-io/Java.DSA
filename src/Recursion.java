public class Recursion {
    static void decreaseOrder(int n){
        if(n>0){//base case
            System.out.print(n+" ");
            decreaseOrder(n-1);
        }
    }
    static void increaseOrder(int n){
        if(n>0){
            increaseOrder(n-1);
            System.out.print(n + " ");
        }
    }
//        factorial(0) = 1;
//            factorial(n)= n*n-1*...1
//            factorial(5) + 5*4*3*2*1= 120
//            factorial(n) = n*factorial(n-1)
    static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    static int factorial_iterative(int n){
        int product =1;
        if(n==0 || n==1){
            return 1;
        }
        else{
        for (int i=1;i<=n;i++){
            product*=i;
        }
        }
        return product;
    }
    static int sumNo(int n){
        if (n ==1){
            return 1;
        }else{
            return n+sumNo(n-1);
        }
    }
    static int fib(int n){
        if (n==0 || n==1){
            return n;
        }
//            int fnm1= fib(n-1);
//            int fnm2 = fib(n-2);
//            int fn = fnm1+fnm2;
//            return fn;
        return fib(n-1)+fib(n-2);
    }
    static boolean isSorted(int[] arr, int i){
        if (i == arr.length-1){
            return true;
        } else if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }
    public static int findKey(int[] arr, int i, int key){
        if (i== arr.length-1){ // base case
            return -1; //which shows key not found
        }
        if(arr[i]==key){
            return i;
        }
        return findKey(arr,i+1,key);
    }
    public static int lastFindKey(int[] arr, int i,int key){
        if(i==0){
            return -1;
        }
        if (arr[i]==key){
            return i;
        }
        return lastFindKey(arr,i-1,key);
    }
    static int powOf(int x, int n){
        if(n==0){
            return 1;
        }
        return x*powOf(x,n-1);
    }
    static int OptPowOf(int x, int n){
        if(n==0){
            return 1;
        }
        int halfpower = OptPowOf(x,n/2);
        if (n%2==0){
//            return OptPowOf(x,n/2)*OptPowOf(x,n/2);// here we calling same function twice
//            instead of calling twice we will store it in variable
            return halfpower*halfpower;
        }
        return x*halfpower*halfpower;
    }
    static int tilingProblem(int n){
        if( n==0 || n==1){
            return 1;
        }
//        kaam
//        for vertical choice
        int fnm1 = tilingProblem(n-1);
//        for horizontal choice
        int fnm2 = tilingProblem(n-2);
        return fnm1+fnm2;
    }
    static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[] ){
        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }
//        kaam
        char currChar = str.charAt(idx);
        if (map[currChar-'a'] == true){
//            duplicate
            removeDuplicates(str, idx+1, newStr,map);
        } else{
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1,newStr.append(currChar),map);
        }
    }
    public static void main(String[] args) {
//        System.out.println(factorial(5));
//        System.out.println(factorial_iterative(5));
//        decreaseOrder(9);
//        increaseOrder(10);
//        System.out.println();
//        System.out.println(sumNo(5));
        int ans = fib(5);
        System.out.println(ans);
//        int[] array = {1,2,3,4,5};
//        System.out.println(isSorted(array,0));
//        int[] array1 = {8,3,6,9,5,10,2,5,3};
//        System.out.println(findKey(array1,0,3));
//        System.out.println(lastFindKey(array1,array1.length-1,5));
//        System.out.println(powOf(2,4));
//        System.out.println(OptPowOf(2,5));
//        System.out.println(tilingProblem(5));
//        String str = "appnnacolleggeee";
//        removeDuplicates(str,0,new StringBuilder(""), new boolean[26]);

    }
}
