package algorithm.month0.week16.java0825;
import java.io.*;

public class TouringSales {

  private static int[][] cost;
  private static boolean[] visit;
  private static int N;
  private static int MIN = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    cost = new int[N + 1][N + 1];
    visit = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      String[] strArr = br.readLine().split(" ");
      for (int j = 1; j <= N; j++) {
        cost[i][j] = Integer.parseInt(strArr[j - 1]);
      }
    }

    for (int i = 1; i <= N; i++) {
      visit = new boolean[N+1];
      visit[i] = true;
      dfs(i, i, 0);
    }

    System.out.println(MIN);
  }

  private static void dfs(int start, int current, int costSum) {
    if (finished() && cost[current][start] != 0) {
      costSum += cost[current][start];
      if (MIN > costSum) {
        MIN = costSum;
        return;
      }
    }

    for (int i = 1; i <= N; i++) {
      if (!visit[i] && cost[current][i] != 0) {
        visit[i] = true;
        dfs(start, i, costSum + cost[current][i]);
        visit[i] = false;
      }
    }
  }

  private static boolean finished() {
    for (int i = 1; i <= N; i++) {
      if (!visit[i]) {
        return false;
      }
    }
    return true;
  }


}

