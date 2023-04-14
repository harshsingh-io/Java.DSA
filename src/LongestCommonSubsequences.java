public class LongestCommonSubsequences {
    public static int lcs(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } else {
            int lcs1 = lcs(str1, str2, n - 1, m);
            int lcs2 = lcs(str1, str2, n, m - 1);
            return Math.max(lcs1, lcs2);
        }
    }
    public static int lcsMemoization(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] !=-1){
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcsMemoization(str1, str2, n - 1, m - 1,dp) + 1;
        } else {
            int lcs1 = lcsMemoization(str1, str2, n - 1, m,dp);
            int lcs2 = lcsMemoization(str1, str2, n, m - 1,dp);
            return dp[n][m]= Math.max(lcs1, lcs2);
        }
    }
    public static int lcsTab(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for (int i=0; i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if (i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for (int i=1; i<n+1;i++) {
            for (int j =1; j < m + 1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
//        System.out.println(lcs(str1,str2,str1.length(),str2.length()));
        int n = str1.length();
        int m = str2.length();
//        int[][] dp = new int[n+1][m+1];
//        //initialization
//        for (int i=0;i<n+1;i++){
//            for (int j=0;j<m+1;j++){
//                dp[i][j] = -1;
//            }
//        }
//        System.out.println(lcsMemoization(str1,str2,n,m,dp));
        System.out.println(lcsTab(str1,str2));
    }
}
