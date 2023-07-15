package algorithm.week10.java0715;

import java.io.*;
import java.util.*;

public class DFSnBFS {

  static StringBuilder sb = new StringBuilder();
  static boolean[] visit;
  static int[][] arr;
  static int start, node, line;
  static Queue<Integer> q = new LinkedList<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    node = Integer.parseInt(st.nextToken());
    line = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    visit = new boolean[node + 1];
    arr = new int[node + 1][node + 1];

    for (int i = 0; i < line; i++) {
      StringTokenizer str = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(str.nextToken());
      int b = Integer.parseInt(str.nextToken());

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    dfs(start);
    sb.append("\n");
    visit = new boolean[node + 1];

    bfs(start);
    System.out.println(sb);
  }


  private static void dfs(int start) {
    visit[start] = true;
    sb.append(start + " ");
    for (int i = 0; i <= node; i++) {
      if (arr[start][i] == 1 && !visit[i]) {
        dfs(i);
      }
    }
  }

  private static void bfs(int start) {
    q.add(start);
    visit[start] = true;

    while (!q.isEmpty()) {

      start = q.poll();
      sb.append(start + " ");

      for (int i = 1; i <= node; i++) {
        if (arr[start][i] == 1 && !visit[i]) {
          q.add(i);
          visit[i] = true;
        }
      }
    }//while
  }//bfs

}
