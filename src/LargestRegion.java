import java.util.*;
public class LargestRegion {

    public static boolean isValid(int[][] matrix, int row, int colomn) {
        return (row >= 0 && colomn >= 0 && row < matrix.length && colomn < matrix[0].length && matrix[row][colomn] == 1);
    }

    public static void countRegion(int[][] matrix, int row, int colomn, int lregion) {

        if (matrix[row][colomn] == 0) {
            return;
        }
        lregion++;
        matrix[row][colomn] = 0;
        //Left,Right,Up,Down
        if (isValid(matrix, row, colomn - 1)) countRegion(matrix, row, colomn - 1, lregion + 1);
        if (isValid(matrix, row, colomn + 1)) countRegion(matrix, row, colomn + 1, lregion + 1);
        if (isValid(matrix, row - 1, colomn)) countRegion(matrix, row - 1, colomn, lregion + 1);
        if (isValid(matrix, row + 1, colomn)) countRegion(matrix, row + 1, colomn, lregion + 1);

        //Diagonally
        if (isValid(matrix, row + 1, colomn - 1)) countRegion(matrix, row + 1, colomn - 1, lregion + 1);
        if (isValid(matrix, row - 1, colomn - 1)) countRegion(matrix, row - 1, colomn - 1, lregion + 1);
        if (isValid(matrix, row - 1, colomn + 1)) countRegion(matrix, row - 1, colomn + 1, lregion + 1);
        if (isValid(matrix, row + 1, colomn + 1)) countRegion(matrix, row + 1, colomn + 1, lregion + 1);
    }


    public static int largestRegion(int[][] matrix) {
        int maxr = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int count = 0;
                    countRegion(matrix, i, j, count);
                    maxr = Math.max(maxr, count);
                }
            }
        }
        return maxr;
    }


    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}};
        System.out.println(largestRegion(matrix));
    }
}
