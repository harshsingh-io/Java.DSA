public class SpiralArray {
    public static void printSpiral(int[][] matrix){
        /*
        approach :
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}
        for top : startRow is fix, sc -> ec
        for right : endcolumn id fix, sr+1 -> er
        for bottom : endRow is fix, ec-1 -> sc (reverse loop)
        for left : startColumn is fix, er-1 -> sr+1 (reverse loop)
        [in bottom loop we will check startRow != endRow
        in left loop we will check startColumn != endColumn]
        ==> if matrix is odd for like 3*3, 5*5 we have to check above 2 statement for
        printing centre element

         */
        int startRow = 0;
        int endRow = matrix.length-1;
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;
//        we used "&&" cause we hve to check the minimum row or coloumn condition
//        when matrix row or column is very less like below matrix
//          1 2 3 4 5 6
//        7 8 9 10 11 12
        while(startRow<=endRow && startColumn<= endColumn){
//            top
            for(int j = startColumn; j<=endColumn;j++){
                System.out.print(matrix[startRow][j] + " ");
            }
//            right
            for(int i = startRow+1; i<=endRow;i++){
                System.out.print(matrix[i][endColumn] + " ");
            }
//            bottom
            for (int j = endColumn-1; j>= startColumn;j--){
//                for odd elements in rows
                if (startRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
//            left
            for (int i = endRow-1;i>=startRow+1;i--){
//                for odd elements in column
                if (startColumn==endColumn){
                    break;
                }
                System.out.print(matrix[i][startColumn] + " ");
            }
            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        printSpiral(matrix);
    }
}
