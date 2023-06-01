public class WildcardMatching {
    public static boolean isMatch(String s, String p) { //O(n*m)
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        //initialize
        dp[0][0] = true;

        // pattern = " "
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // string = " "
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; //store the previous result
            }
            //don't have to write the remaining cases which will give false as java by default stores false value

        }
        // Bottom Up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //case1 -> ith char == jth char || jth char == ?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // when we have to match with last character '*' OR when we have match/ignore '*' with empty, as it'll not use further(True)
                } else { //not matching characters
                    dp[i][j] = false;
                }
            }
        }
        //string -> n, pattern -> m
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "baaabab";
//        String p = "*****ba*****ab"; // true
        String p = "*****dMa*****ab"; // false

        System.out.println(isMatch(s, p));
    }
}
