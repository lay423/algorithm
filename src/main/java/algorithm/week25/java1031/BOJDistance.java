package algorithm.week25.java1031;

import java.util.Arrays;
import java.util.Scanner;


public class BOJDistance {
  static int[] dp;
  static String s;
  static int max = 1000000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    s = sc.next();
    dp = new int[s.length()];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == 'B') {
        make(i, 'O');
      } else if (c == 'O') {
        make(i, 'J');
      } else {
        make(i, 'B');
      }
    }
    if (dp[s.length() - 1] == max) {
      System.out.println(-1);
    } else {
      System.out.println(dp[s.length() - 1]);
    }
  }

  private static void make(int index, char next) {
    for (int j = index + 1; j < dp.length; j++) {
      char k = s.charAt(j);
      if (k == next) {
        dp[j] = Math.min(dp[j], dp[index] + (j - index) * (j - index));
      }
    }
  }
}