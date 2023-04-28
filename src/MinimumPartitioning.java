public class MinimumPartitioning {
    public static int minPartition(int[] arr) { // 0-1 Knapsack Code
        int n = arr.length;
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            sum+= arr[i];
        }
        int W = sum/2;
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
                if (arr[i-1] <= j) { //Valid Condition
                    int includeProfit = arr[i-1]+dp[i-1][j-arr[i-1]];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else { //Invalid Condition
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        int sum1= dp[n][W];
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
    }

    public static void main(String[] args) {
        int[] num ={1, 6, 11, 5};
        System.out.println(minPartition(num));
    }
}
