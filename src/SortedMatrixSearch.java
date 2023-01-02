//This is StairCase Matrix
//time complexity is O(n+m)
public class SortedMatrixSearch {
    public static void matrixSearch(int[][] matrix, int key){
        int row =0, column = matrix[0].length-1;
        while(row<matrix.length && column >= 0){
            if (matrix[row][column]==key){
                System.out.println(row + "," + column);
                return;
            }
            else if(key<matrix[row][column]){
                column--;
            }
//            else if (key>matrix[row][column]){
            else if (key>matrix[row][column]){
                row++;
            }
        }
        System.out.println("Key not found!");
    }
    public static void main(String[] args) {
        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};
        int key = 33;
        matrixSearch(matrix,key);

    }
}
