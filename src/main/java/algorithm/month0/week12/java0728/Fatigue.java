package algorithm.month0.week12.java0728;

public class Fatigue {

  static int answer = 0;
  static boolean[] visit;

  public int solution(int k, int[][] dungeons) {

    for (int i = 0; i < dungeons.length; i++) {
      visit = new boolean[dungeons.length];

      dfs(i, k, dungeons, 1);
    }
    return answer;
  }

  private static void dfs(int current, int k, int[][] dungeons, int cnt) {
    if (!visit[current] && dungeons[current][0] <= k) {
      visit[current] = true;
      answer = Math.max(answer, cnt);

      for (int i = 0; i < dungeons.length; i++) {
        dfs(i, k-dungeons[current][1], dungeons, cnt+1);
        visit[i] = false;
      }
    }
  }

}
