package algorithm.week16.java0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeArea {

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int N;
  static int[][] board;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    int height = 0;
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] > height) {
          height = board[i][j];
        }
      }
    }

    int max = 0;
    for (int h = 0; h < height + 1; h++) {
      visit = new boolean[N][N];
      int cnt = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visit[i][j] && board[i][j] > h) {
            cnt += dfs(i, j, h);
          }
        }
      }
      max = Math.max(max, cnt);
    }
    System.out.println(max);
  }

  static int dfs(int x, int y, int height) {
    visit[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int cx = x + dx[i];
      int cy = y + dy[i];

      if (cx < 0 || cy < 0 || cx > N - 1 || cy > N - 1) {
        continue;
      }
      if (visit[cx][cy]) {
        continue;
      }

      if (board[cx][cy] > height) {
        dfs(cx, cy, height);
      }
    }
    return 1;
  }
}
