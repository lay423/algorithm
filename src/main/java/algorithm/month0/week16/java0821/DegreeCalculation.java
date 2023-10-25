package algorithm.month0.week16.java0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DegreeCalculation {

  static List<ArrayList<Integer>> list = new ArrayList<>();
  static boolean[] visit;
  static int answer;
  static int[] target = new int[2];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    visit = new boolean[n+1];
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    target[0] = Integer.parseInt(st.nextToken());
    target[1] = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);
    }

    dfs(target[0], 0);
    System.out.println(answer != 0 ? answer : -1);
  }

  private static void dfs(int idx, int cnt) {
    visit[idx] = true;
    for(int j : list.get(idx)){
      if(!visit[j]){
        if(j == target[1]){
          answer = cnt+1;
          return;
        }
        dfs(j, cnt+1);

      }
    }
  }
}
