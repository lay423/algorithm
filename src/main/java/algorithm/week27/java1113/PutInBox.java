package algorithm.week27.java1113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PutInBox {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] boxes = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      boxes[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];
    int MAX = 0;
    Arrays.fill(dp, 1);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (boxes[i] > boxes[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      MAX = Math.max(MAX, dp[i]);
    }
    System.out.println(MAX);
  }

}
