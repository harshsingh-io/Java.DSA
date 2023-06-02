public class CoinChange {
    public static int coinChange(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        //initialization (i-> coins, j -> sum/change
        for (int i = 0; i < dp.length; i++) { // where sum  is 0
            dp[i][0] = 0;
        }
        for (int j = 1; j < dp[0].length; j++) { // Where no. of coin is 0
            dp[0][j] = 0;
        }
        //Tabulation LOOP
        for (int i = 1; i < n + 1; i++) { // O(n*sum)
            for (int j = 1; j < sum + 1; j++) {
                int ithcoin = coins[i - 1];
                if (ithcoin <= j) { //When ith coin is less than sum
                    int includeProfit = dp[i][j - ithcoin]; //Here is the only change instead of i-1 we use i as we can include the current item again and again
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = includeProfit + excludeProfit;
                } else { //Uncoinsid Condition
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
//        printDP(dp); // printing DP for Clarification
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println(coinChange(coins, sum));
    }
}
