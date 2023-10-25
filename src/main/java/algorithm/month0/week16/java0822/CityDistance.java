package algorithm.month0.week16.java0822;

import java.io.*;
import java.util.*;

public class CityDistance {
  static int cityCnt, roadCnt, target, start;
  static List<Integer> answer = new ArrayList<>();
  static List<Integer>[] list;
  static int[] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    cityCnt = Integer.parseInt(st.nextToken());
    roadCnt = Integer.parseInt(st.nextToken());
    target = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    list = new List[cityCnt+1];
    for (int i = 1; i <= cityCnt; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < roadCnt; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
    }

    distance = new int[cityCnt+1];
    Arrays.fill(distance, -1);

    dfs();

    Collections.sort(answer);
    StringBuilder sb = new StringBuilder();
    for (int cur : answer) {
      sb.append(cur).append('\n');
    }

    System.out.print(answer.isEmpty() ? -1 : sb);
  }

  private static void dfs(){
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    distance[start] = 0;


    while (!q.isEmpty()) {
      int cur = q.poll();
      if (distance[cur] > target) {
        break;
      }
      if (distance[cur] == target) {
        answer.add(cur);
      }

      for (int next : list[cur]) {
        if (distance[next] != -1) {
          continue;
        }
        distance[next] = distance[cur]+1;
        q.add(next);
      }
    }
  }
}
