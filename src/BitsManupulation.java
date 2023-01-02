/*
00 -> 000, 01 -> 001, 02 -> 010, 03 -> 011, 04 -> 100,
05 -> 101, 06 -> 110, 07 -> 111, 08 -> 1000
 */
public class BitsManupulation {
    public static int setBit(int n, int i){
        int bitMask = (n | 1<<i);
        return bitMask;
    }
    public static int clearBit(int n, int i){
        int bitMask = (n & ~(1<<i));
        return bitMask;
    }
    public static int updateBit(int n, int i, int newBit){
//        if (newBit==0){
//            return clearBit(n,i);
//        }else{
//            return setBit(n,i);
//        }
        n = clearBit(n,i);
        int BitMask = newBit<<i;
        return n | BitMask;
    }
    public static int clearIBits(int n, int i){
        int bitMask = ~0<<i;
        return n & bitMask;
    }
    public static int clearIBitsRange(int n, int i, int j){
//      n = 1001|110100|11 it can be brake into 2 phase
//        a = 1111(j+1)0000000000 -> (~0)<<(j+1) all one will go from j+1 to left most position
//        b = 00000000000(i-1)11 -> (2^no. of ones)-1 which is basically 2^i-1 -> (1<<i)-1
        /*
        01=1=2^1-1
        011=3=2^2-1
        0111=5=2^3-1
         */
        int a = ((~0)<<j+1);
//        b will be 2^b-1 which can we written as (1<<b)-1 . similarly for i
//        2^i-1 -> (1<<i)-1
        int b = (1<<i)-1;
        return (a|b) & n;
    }
    public static boolean isPowerOfTwo(int n){
        return (n&(n-1)) == 0;
    }
    public static int countSetBits(int n){
        int counter=0;
        while(n>0){
            if((n&1) != 0){ //check our LSB
                counter++;
            }
            n = n>>1;
        }
        return counter;
    }
//    a^n
    public static int fastExponentiation(int a,int n){
        int ans = 1;
        while (n > 0) {
            // If y is odd, multiply x with result
            if ((n&1) != 0){ //check LSB
                ans = ans * a;
            }
            // y must be even now
            a = a*a;
            n = n>>1;
        }
        return ans;
    }
//    a^n%b =?
    public static int modularExponentiation(int a, int n, int b){
        int ans = 1; // Initialize result
        while (n > 0) {
            // If y is odd, multiply x with result
            if ((n&1) != 0){ //check LSB
                ans = ans * a;
            }
            // y must be even now
            a = a*a;
            n = n>>1;
        }
        return ans % b;
    }

    public static void main(String[] args) {
//        10 -> 1010
//        System.out.println(setBit(10,2));
//        System.out.println(clearBit(10,1));
//        System.out.println(updateBit(10,2,1));
//        System.out.println(clearIBits(15,2));
//        System.out.println((clearIBitsRange(10,2,4)));
        System.out.println(isPowerOfTwo(16));
        System.out.println(countSetBits(10));
        System.out.println(fastExponentiation(5,3));
        System.out.println(modularExponentiation(5,3,5));

    }
}