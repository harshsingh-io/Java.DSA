public class DiagonalSum {
    public static int diagonalSum(int[][] matrix){
        /*
//        This is brute force approach of code and its time complexity is O(n^2)
        int sum=0;
        for (int i=0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (i==j){
                    sum += matrix[i][j];
                }
                else if(i+j==matrix.length-1){
                    sum+= matrix[i][j];
                }
            }
        }
         */
        int sum = 0;
        for(int i = 0 ; i < matrix.length;i++){
            //Primary Diagonal
            sum += matrix[i][i];
            //Secondary Diagonal
            if (i != matrix.length-i-1){ //if i !=j(matrix.length-i-1)
//                here i+j=matrix.length-1
//                j = matrix.length-i-1
                sum += matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        System.out.println(diagonalSum(matrix));
    }
}
