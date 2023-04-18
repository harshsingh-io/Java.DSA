public class StringConversion {
//    public static int stringConversion(String str1, String str2) {
//        int n = str1.length();
//        int m = str2.length();
//        int dp[][] = new int[n + 1][m + 1];
//
//        //Initialise
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < m + 1; j++) {
//                if (i == 0) dp[i][j] = j;
//                if (j == 0) dp[i][j] = i;
//            }
//        }
//        //Bottom Up Approach
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { //same
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else { //different
//                    int add = dp[i][j - 1];
//                    int delete = dp[i - 1][j];
//                    dp[i][j] = Math.min(add, delete) + 1;
//                }
//            }
//        }
//        return dp[n][m];
//    }
    public static int stringConversionLCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return (m-dp[n][m])+(n-dp[n][m]);
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";
//        System.out.println(stringConversion(str1, str2));
        System.out.println(stringConversionLCS(str1,str2));
    }
}
