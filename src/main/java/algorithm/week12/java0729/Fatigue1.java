package algorithm.week12.java0729;

public class Fatigue1 {

  static int answer = 0;
  static boolean[] visit;

  public int solution(int k, int[][] dungeons) {
    visit = new boolean[dungeons.length];

    dfs(0, k, dungeons);
    return answer;
  }

  private static void dfs(int depth, int k, int[][] dungeons) {
    for (int i = 0; i < dungeons.length; i++) {
      if (visit[i] || dungeons[i][0] > k) {
        continue;
      }

      visit[i] = true;
      dfs(depth + 1, k - dungeons[i][1], dungeons);
      visit[i] = false;
    }
    answer = Math.max(answer, depth);

  }

}
