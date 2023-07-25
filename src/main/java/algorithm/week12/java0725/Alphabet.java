package algorithm.week12.java0725;

import java.io.*;
import java.util.*;

public class Alphabet {
  private static int dx[] = {0, 0, 1, -1};
  private static int dy[] = {1, -1, 0, 0};
  private static char[][] map;
  private static int N;
  private static int M;
  private static int MAX = 1;
  private static Set<Character> fp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strArr = br.readLine().split(" ");
    N = Integer.parseInt(strArr[0]);
    M = Integer.parseInt(strArr[1]);
    map = new char[N][M];
    fp = new HashSet<>();

    for (int i = 0; i < N; i++) {
      char[] chArr = br.readLine().toCharArray();
      for (int j = 0; j < chArr.length; j++) {
        map[i][j] = chArr[j];
      }
    }
    dfs(0, 0, 0);
    System.out.println(MAX);
  }

  private static void dfs(int x, int y, int count) {
    if (fp.contains(map[x][y])) {
      MAX = Math.max(MAX, count);
      return;
    } else {
      fp.add(map[x][y]);
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          dfs(nx, ny, count + 1);
        }
      }
    }
    fp.remove(map[x][y]);


  }
}
