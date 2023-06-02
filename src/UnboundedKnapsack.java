public class UnboundedKnapsack {
    public static int unboundedKnapsackTabulation(int[] val, int[] wt, int W) {
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
                    int includeProfit = v + dp[i][j - w]; //Here is the only change instead of i-1 we use i as we can include the current item again and again
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else { //Unvalid Condition
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
//        printDP(dp); // printing DP for Clarification
        return dp[n][W];
    }

    public static int rodCutting(int[] length, int[] price, int totRod) {
        int n = price.length;
        int[][] dp = new int[n + 1][totRod + 1];
        for (int i = 0; i < dp.length; i++) { // 0th Column
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) { // 0th Row
            dp[0][j] = 0;
        }
        //Tabulation LOOP
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {
                int v = price[i - 1];
                int w = length[i - 1];
                if (w <= j) { //Valid Condition
                    int includeProfit = v + dp[i][j - w]; //Here is the only change instead of i-1 we use i as we can include the current item again and again
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else { //Unvalid Condition
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
//        printDP(dp); // printing DP for Clarification
        return dp[n][totRod];
    }

    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(unboundedKnapsackTabulation(val, wt, W));

        int[] length = {1, 2, 3, 4, 5, 6, 7, 8}; //Pieces Length
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int totRod = 8;

        System.out.println(rodCutting(length, price, totRod));
    }
}
