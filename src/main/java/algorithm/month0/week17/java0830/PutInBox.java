package algorithm.month0.week17.java0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PutInBox {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] boxes = new int[n];
    for (int i = 0; i < n; i++) {
      boxes[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n];

    Arrays.fill(dp, 1);
    int MAX = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (boxes[i] > boxes[j]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
      MAX = Math.max(dp[i], MAX);
    }
    System.out.println(MAX);

  }
}
