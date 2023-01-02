import java.util.*;

public class PrimeRange {
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n==2) {
            isPrime = true;
        }
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
        
    }
    public static void prime(int n) {
       for(int i = 2; i <= n ; i++ ){
        boolean condition = isPrime(i);
        if(condition== true){
            System.out.print(i +" ");
        }
       }System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int range = sc.nextInt();
            prime(range);
    }
}
