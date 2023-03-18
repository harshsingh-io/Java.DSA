public class ZeroOneKnapsack {
    public static int knapsackRecursion(int[] val, int[] wt, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) { //Valid Condition
            //Include
            int ans1 = val[n - 1] + knapsackRecursion(val, wt, W - wt[n - 1], n - 1);
            //Exclude
            int ans2 = knapsackRecursion(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsackRecursion(val, wt, W, n - 1);
        }
    }

    public static int knapsackMemoization(int[] val, int[] wt, int W, int n, int[][] dp) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) { //Valid Condition
            //Include
            int ans1 = val[n - 1] + knapsackMemoization(val, wt, W - wt[n - 1], n - 1, dp);
            //Exclude
            int ans2 = knapsackMemoization(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapsackMemoization(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTabulation(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) { // 0th Column
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) { // 0th Row
            dp[0][j] = 0;
        }
        //Tabulation LOOP
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) { //Valid Condition
                    int includeProfit = v + dp[i - 1][j - w];
                    int excludeProfit = dp[i - 1][j - w];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else {
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        printDP(dp); // printing DP for Clarification
        return dp[n][W];
    }

    public static void printDP(int[][] dp) {
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        //i= items & ] = target sum
        for (int i = 0; i < n + 1; i++) {
            dp[1][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];
                //include
                if (v < j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                //exclude
                else if (dp[i - 1][j] = true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        int n = val.length;
        //Recursion
        System.out.println(knapsackRecursion(val, wt, W, n));

        //Memoization
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
//        System.out.println(knapsackMemoization(val, wt, W, n, dp));
//        System.out.println(knapsackTabulation(val, wt, W));

        int[] num = {4,3,1,2,7};
        int sum = 10;
        System.out.println(targetSumSubset(num, sum));

    }
}
