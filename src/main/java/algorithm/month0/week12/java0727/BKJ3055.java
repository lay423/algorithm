package algorithm.month0.week12.java0727;

import java.io.*;
import java.util.*;

public class BKJ3055 {

  private static int R, C;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  private static Queue<int[]> q = new LinkedList<>();
  private static Queue<int[]> water = new LinkedList<>();
  private static int answer = Integer.MAX_VALUE;
  private static int[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new int[R][C];

    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = str.charAt(j);
        if (map[i][j] == 'S') {
          q.add(new int[]{i, j});
        } else if (map[i][j] == '*') {
          water.add(new int[]{i, j});
        }
      }
    }

    bfs();

    System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);

  }
  private static void bfs() {
    int time=0;
    while (!q.isEmpty()) {
      time++;
      int len = water.size();
      for (int i = 0; i < len; i++) {
        int[] waterC = water.poll();
        int x = waterC[0];
        int y = waterC[1];
        for (int j = 0; j < 4; j++) {
          int nx = x+dx[j];
          int ny = y+dy[j];
          if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
            map[nx][ny]='*';
            water.add(new int[]{nx, ny});
          }
        }
      }

      len = q.size();
      for (int i = 0; i < len; i++) {
        int[] moveC = q.poll();
        int x = moveC[0];
        int y = moveC[1];
        for (int j = 0; j < 4; j++) {
          int nx = x+dx[j];
          int ny = y+dy[j];
          if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
            if (map[nx][ny] == 'D') {
              answer = Math.min(answer, time);
              return;
            }else if(map[nx][ny]=='.'){
              map[nx][ny] = 'S';
              q.add(new int[]{nx, ny});
            }
          }
        }
      }

    }//while
  }

}
