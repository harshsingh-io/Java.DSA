public class RecursionPractice{
    /*
    Question 1 : For a given integer array of size N. You have to find all the occurrences
(indices) of a given element (Key) and print them. Use a recursive function to solve this
problem.
Sample Input : arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2
Sample Output : 1 5 7 8

     */
    static void searchIndices(int[]arr,int key, int index){
//        base case
        if(index>arr.length-1){
            return;
        }
//        kaam
        if(arr[index]==key){
            System.out.print(index+" ");
        }
        searchIndices(arr,key,index+1);
    }
    /*
    Question 2 :
You are given a number (eg - 2019), convert it into a String of english like
“two zero one nine”. Use a recursive function to solve this problem.
NOTE - The digits of the number will only be in the range 0-9 and the last digit of a number
can’t be 0.
Sample Input : 1947
Sample Output : “one nine four seven”
     */
    static void numToWord(int number){
        //BAse CAse
        if (number==0){
            return;
        }
        int lastDigit = number%10;
        numToWord(number/10);
        System.out.print(digits[lastDigit]+" ");
    }
        static String[] digits = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    /*
    Question 3 : Write a program to find Length of a String using Recursion.
     */
    static int stringLength(String str){
    if(str.length()==0){
        return 0;
    }
    return stringLength(str.substring(1))+1;
    }

    public static int countSubstrs(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int res = countSubstrs(str, i + 1, j, n - 1) +
                countSubstrs(str, i, j - 1, n - 1) -
                countSubstrs(str, i + 1, j - 1, n - 2);
        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }
    static int fiboFormula(int n){
        return (int)(Math.pow(((1 + Math.sqrt(5)) / 2), n)/ Math.sqrt(5));
    }
    public static void main(String[] args) {
//        int[] arr = {3,2,4,5,6,2,7,2,2};
//        int key = 2;
//        searchIndices(arr,key,0);
//        int[] arr2 = {1,9,4,7};
//        numToWord(1947);
//        String str = "Hello";
//        System.out.println(stringLength(str));
//        String str = "abcab";
//        int n = str.length();
//        System.out.print(countSubstrs(str, 0, n-1, n));
        System.out.println(fiboFormula(5));
    }
}
