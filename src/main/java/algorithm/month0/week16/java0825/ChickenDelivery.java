package algorithm.month0.week16.java0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDelivery {

  static int N, M;
  static List<int[]> home = new ArrayList<>();
  static List<int[]> chicken = new ArrayList<>();
  static boolean[] open;
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());//가장 수익을 많이 낼 수 있는  치킨집의 개수

    //집, 치킨집 초기화
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int type = Integer.parseInt(st.nextToken());
        if (type == 1) {
          home.add(new int[]{i, j});
        } else if (type == 2) {
          chicken.add(new int[]{i, j});
        }
      }
    }
    open = new boolean[chicken.size()];

    dfs(0, 0);
    System.out.println(answer);
  }
  private static void dfs(int idx, int cnt) {
    if (cnt == M) {
      int distanceSum = 0;

      for (int i = 0; i < home.size(); i++) {
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < chicken.size(); j++) {
          if (open[j]) {
            int[] homeXY = home.get(i);
            int[] chickenXY = chicken.get(j);
            int distance = Math.abs(homeXY[0] - chickenXY[0]) +
                           Math.abs(homeXY[1] - chickenXY[1]);

            min = Math.min(min, distance);
          }
        }
        distanceSum += min;
      }
      answer = Math.min(answer, distanceSum);
      return;
    }//if(cnt == M)

    for (int i = idx; i < chicken.size(); i++) {
      open[i] = true;
      dfs(i + 1, cnt + 1);
      open[i] = false;
    }
  }
}
