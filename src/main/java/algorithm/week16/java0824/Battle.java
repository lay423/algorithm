package algorithm.week16.java0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Battle {

  private static int dx[] = {0, 0, 1, -1};
  private static int dy[] = {1, -1, 0, 0};
  private static boolean[][] visited;
  private static char[][] map;
  private static int N;
  private static int M;
  private static int count;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    visited = new boolean[N][M];
    int BA = 0;
    int WA = 0;

    for (int i = 0; i < N; i++) {
      char[] chArr = br.readLine().toCharArray();
      for (int j = 0; j < chArr.length; j++) {
        map[i][j] = chArr[j];
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          count = 0;
          dfs(i, j, map[i][j]);
          if (map[i][j] == 'B') {
            BA += count * count;
          } else if(map[i][j] == 'W'){
            WA += count * count;
          }
        }
      }
    }
    System.out.println(WA + " " + BA);

  }

  private static void dfs(int x, int y, char type) {
    visited[x][y] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
        if (!visited[nx][ny] && map[nx][ny] == type) {
          dfs(nx, ny, type);
        }
      }
    }
  }
}
