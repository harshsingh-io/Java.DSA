public class TwoD_arraypractice {
//    Question 1st :Print the number of 7’s that are in the 2d array.
    public static int numOfKeys(int[][] matrix){
        int counter = 0;
        /*
        here time complexity of out code is O(n^2)
        basically this is a brute force approach
         */
        for (int i = 0; i< matrix.length;i++){
            for (int j=0;j< matrix[0].length;j++){
                if (matrix[i][j]==7){
                    counter++;
                }
            }
        }
        return counter;
    }
    /*
    Question 2 : Print out the sum of the numbers in the second row of the “nums” array.
Example :
Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
Output - 18
     */
    public static int sumRows(int[][] nums){
        int sum=0;
        for (int j = 0; j < nums[0].length; j++) {
            sum += nums[1][j];
        }
    return sum;
    }
    /*
    Question 3 : Write a program to Find Transpose of a Matrix.
What is Transpose?
Transpose of a matrix is the process of swapping the rows to columns. For a 2x3 matrix,
Matrix
a11 a12 a13
a21 a22 a23
Transposed Matrix
a11 a21
a12 a22
a13 a23
     */

public static void transposeArray(int[][] array){
    for (int i = 0; i< array[0].length;i++){
        for (int j =0;j< array.length;j++){
//            int temp=0;
//            temp = array[i][j];
//            array[i][j]=array[j][i];
            System.out.print(array[j][i] + " ");
        }
        System.out.println();
    }
    /*
    alpha approach
    // Transpose the matrix
int[][] transpose = new int[column][row];
for(int i = 0; i<row; i++) {
for (int j = 0; j<column; j++) {
transpose[j][i] = matrix[i][j];
}
}

     */
}
    public static void main(String[] args) {
//        int[][] array = { {4,7,8},{8,8,7} };
//        System.out.println(numOfKeys(array));
//        int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
//        System.out.println(sumRows(nums));
        int[][] nums = { {1,2,3},{4,5,6}};
        transposeArray(nums);

    }
}
