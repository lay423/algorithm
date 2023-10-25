package algorithm.month0.week16.java0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//이모티콘
public class SolvingProcess {

  static int MIN = Integer.MAX_VALUE;
  static boolean[] visit = new boolean[100];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int s = Integer.parseInt(br.readLine());

    dfs(1, s, 0, 0);
    System.out.println(MIN);
  }

  private static void dfs(int now, int target, int cnt, int idx) {
    if (now == target) {
      MIN = Math.min(cnt, MIN);
      return;
    }

    for (int i = idx; i < visit.length; i++) {
      if(visit[i])
        continue;
    if (now < target) {
      dfs(now * 2, target, cnt + 2, idx+1);
    }
    dfs(now - 1, target, cnt + 1, idx+1);
    visit[i] = true;
    }

  }

}
