import java.util.Arrays;
public class DynamicProgrammingB {
    public static int climbingStairsWays(int n) {
        //recursion
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbingStairsWays(n - 1) + climbingStairsWays(n - 2);
    }

    public static int climbingStairsWays(int n, int[] ways) {
        //recursion
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = climbingStairsWays(n - 1) + climbingStairsWays(n - 2);
        return ways[n];
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int climbingStairs(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                ways[i] = ways[i - 1] + 0;
            } else {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(climbingStairsWays(n));
//        System.out.println(climbingStairsWays(n,ways));
        System.out.println(climbingStairsWays(n));
    }
}
