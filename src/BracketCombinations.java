import java.util.*;
import java.io.*;

class Main {

public static int BracketCombinations(int num) {
  if (num < 0)
    return 0;
  if (num == 0)
    return 1;

  int[] dp = new int[num + 1];
  dp[0] = 1;
  dp[1] = 1;

  for (int i = 2; i <= num; i++) {
      for (int j = 0; j < i; j++) {
          dp[i] += dp[j] * dp[i - j - 1];
      }
  }

  return dp[num];

}
  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(BracketCombinations(s.nextLine()));
  }

}
