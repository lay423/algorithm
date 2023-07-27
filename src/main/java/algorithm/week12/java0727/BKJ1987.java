package algorithm.week12.java0727;

import java.io.*;
import java.util.*;

public class BKJ1987 {

  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  private static int R;
  private static int C;
  private static int MAX = 0;
  private static boolean[] visit = new boolean[26];
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new int[R][C];

    for (int i = 0; i < R; i++) {
      char[] str = br.readLine().toCharArray();
      for (int j = 0; j < C; j++) {
        map[i][j] = str[j] - 'A';
      }
    }

    dfs(0, 0, 0);
    System.out.println(MAX);
  }

  private static void dfs(int x, int y, int cost) {
    if (visit[map[x][y]]) {
      MAX = Math.max(MAX, cost);
      return;
    } else {
      visit[map[x][y]] = true;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
          dfs(nx, ny, cost + 1);
        }
      }
      visit[map[x][y]] = false;
    }
  }
}
