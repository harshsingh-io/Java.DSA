public class BackTracking {
    public static void findSubString(String str, String ans, int i) {
//        Base Case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.print("null");
            }
            System.out.print(ans + " ");
            return;
        }
//        Recursive call
//        if yes choice
        findSubString(str, ans + str.charAt(i), i + 1);
//        if no choice
        findSubString(str, ans, i + 1);
    }

    public static void findPermutation(String str, String ans) {
//        Base Case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
//        recursion
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
//            "abcde" => "ab"+"de" = "abde"
            String NewStr = str.substring(0, i) + str.substring(i + 1);
            findPermutation(NewStr, ans + cur);
        }
    }

    public static void nQueens(char[][] board, int row) {
//        Base Condition
        if (row == board.length) {
//            to print board
//            printBoard(board);
//            to count total solution
            count++;
            return;
        }
//        column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);//Function Call
                board[row][j] = 'X';//Back Tracking
            }
        }
    }

    public static boolean CheckNQueens(char[][] board, int row) {
//        Base Condition
        if (row == board.length) {
//            to print board
//            printBoard(board);
//            to count total solution
            count++;
            return true;
        }
//        column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (CheckNQueens(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'X';//Back Tracking
            }
        }
        return false;
    }

    static int count = 0;

    public static boolean isSafe(char[][] board, int row, int col) {
//        vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
//        Diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
//        Diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        System.out.println("------CHESS BOARD------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int gridWays(int i, int j, int n, int m) {
        //base case
        if (i == n - 1 && j == m - 1) { // condition for last cell
            return 1;
        } else if (i == n || j == n) { //boundary cross condition
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static void main(String[] args) {
//        String str = "abc";
//        findSubString(str,"",0);
//        findPermutation(str,"");
//        int n = 4;
//        char[][] chess = new char[n][n];
//        nQueens(chess, 0);
//        System.out.println("Total ways to solve nQueens = " + count);
        
        int n = 3, m = 3;
        System.out.println(gridWays(0,0,n,m));

    }
}
