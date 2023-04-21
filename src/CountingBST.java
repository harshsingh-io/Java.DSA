import java.util.Arrays;

public class CountingBST {
    //refer to catalan's Number problem firstly
    public static int countingBST(int n){
        int [] dp = new int[n+1];
        dp[0]=dp[1]=1;
        for (int i=2;i<=n;i++){
            //Ci => BST (i nodes) -> dp[i]
            for (int j=0;j<i;j++){
                int left = dp[j]; // for left subtree
                int right = dp[i-j-1]; // for right subtree
                dp[i]+=left*right; //Ci= Cj * Ci-j-1
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(countingBST(n));
    }
}
