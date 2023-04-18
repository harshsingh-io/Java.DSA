public class CatalanNumber {
    public static int catalan(int n){
        if (n==0||n==1) return 1;
        int ans=0;
        for (int i=0; i<n;i++){
            ans+= catalan(i)*catalan(n-i-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(catalan(4));
    }
}
