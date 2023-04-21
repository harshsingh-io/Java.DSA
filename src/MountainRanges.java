public class MountainRanges {
    public static int mountainRanges(int n){
        int [] dp = new int[n+1];
        dp[0]=dp[1]=1;
        for (int i=2;i<=n;i++){
            //Ci => i Up and Down Range Pair ->  Mountain Range == dp[i]
            for (int j=0;j<i;j++){
                int inside = dp[j]; // for Inside arrangement possible cases
                int outside = dp[i-j-1]; // for Outside arrangement possible cases
                dp[i]+=inside*outside; //Ci= Cj * Ci-j-1
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int pair = 3;
        System.out.println(mountainRanges(pair));
    }
}
