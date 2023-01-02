import java.util.Scanner;

public class OOPs_Exercise {
    public static void main(String[] args) {
/*
    Question 1 : Print the sum, difference and product of two complex numbers by creating a
    class named 'Complex' with separate methods for each operation whose real and imaginary
    parts are entered by the user.
 */
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Input 1st Real Part : ");
        int a1 = sc.nextInt();
        System.out.print("Input 1st Imaginary Part : ");
        int b1 = sc.nextInt();
        System.out.print("Input 2nd Real Part : ");
        int a2 = sc.nextInt();
        System.out.print("Input 2nd Imaginary Part : ");
        int b2 = sc.nextInt();
        Complex value = new Complex();
        value.sum(a1,b1,a2,b2);
        value.diff(a1,b1,a2,b2);
        value.product(a1,b1,a2,b2);
         */

    }
}
class Complex{
    void sum(int a1, int b1, int a2, int b2){
        System.out.println("Real Part : "+ (a1+a2));
        System.out.println("Imaginary Part : " + (b1+b2));
    }
    void diff(int a1, int b1, int a2, int b2){
        System.out.println("Real Part : "+ (a1-a2));
        System.out.println("Imaginary Part : " + (b1-b2));
    }
    void product(int a1, int b1, int a2, int b2){
        int real = (a1*a2)-(b1*b2);
        int imaginary= (b1*a2)+(a1*b2);
        System.out.println("Real : "+ real);
        System.out.println("Imaginary : "+ imaginary);
    }
}
