import java.util.Scanner;
public class ArrayInOut {
    public static void search(int[][] matrix, int search){
        int n= matrix.length; //here we will get the no. of rows
        int m = matrix[0].length; //here we will get the no. of columns
        for (int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                if (matrix[i][j] == search) {
//                    System.out.print(matrix[i][j] + " ");
                    System.out.println("(" + ++i + ","+ ++j +")");
                }
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][4];
        Scanner sc = new Scanner(System.in);
        int n= matrix.length; //here we will get the no. of rows
        int m = matrix[0].length; //here we will get the no. of columns
        for (int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                matrix[i][j]= sc.nextInt();
            }
        }
        for (int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        int search = sc.nextInt();
        search(matrix, search);
    }
}