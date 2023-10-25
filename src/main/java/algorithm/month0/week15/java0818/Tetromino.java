package algorithm.month0.week15.java0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int n, m, max = Integer.MIN_VALUE;
  static int[][] board;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    visit = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        visit[i][j] = true;
        setMax(i, j, board[i][j], 1);
        visit[i][j] = false;
      }
    }

    System.out.println(max);
  }

  static void setMax(int r, int c, int sum, int count) {
    if (count == 4) {
      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int cr = r + dx[i];
      int cc = c + dy[i];

      if (cr < 0 || cr >= n || cc < 0 || cc >= m) {
        continue;
      }

      if (!visit[cr][cc]) {
        if (count == 2) {
          visit[cr][cc] = true;
          setMax(r, c, sum + board[cr][cc], count + 1);
          visit[cr][cc] = false;
        }

        visit[cr][cc] = true;
        setMax(cr, cc, sum + board[cr][cc], count + 1);
        visit[cr][cc] = false;

      }
    }
  }
}
