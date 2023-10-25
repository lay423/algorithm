package algorithm.month0.week17.java0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin2 { // 동전 2
  static int[] dp;
  static final int LIMIT = 10001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());

    int[] coins = new int[N];
    for (int i = 0; i < coins.length; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    dp = new int[target + 1];

    Arrays.fill(dp, LIMIT);
    dp[0] = 0;

    for (int coin : coins) {
      for (int i = coin; i < dp.length; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                System.out.println(dp[i]);
      }
    }

    System.out.println(dp[target] == LIMIT ? -1 : dp[target]);
  }

}