package algorithm.month0.week14.java0808;

import java.util.*;
import java.io.*;

//[HSAT 6회 정기 코딩 인증평가 기출] 출퇴근길
public class Commute
{
  static List<Integer> answer = new ArrayList<>();
  static List<Integer> answer2 = new ArrayList<>();
  static List<int[]> nodes = new ArrayList<>();
  static Queue<Integer> q = new LinkedList<>();

  public static void main(String args[]) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    boolean[] visit = new boolean[n+1];

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      nodes.add(new int[]{a, b});
    }

    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    q.add(s);
    visit[s] = true;
    bfs(t, visit);

    for(int i=0; i<answer.size(); i++){
      answer2.add(answer.get(i));
    }

    answer = new ArrayList<Integer>();
    q = new LinkedList<Integer>();
    visit = new boolean[n+1];

    q.add(t);
    visit[t] = true;
    bfs(s, visit);

    int cnt=0;
    for(int i=0; i<answer.size(); i++){
      int a = answer.get(i);
      if(answer2.contains(a))
        cnt++;
    }
    System.out.println(cnt);

  }

  private static void bfs(int goal, boolean[] visit){
    while (!q.isEmpty()) {
      int now = q.poll();
      if(now == goal) continue;
      for(int i=0; i<nodes.size(); i++){
        int[] node = nodes.get(i);
        int a = node[0];
        int b = node[1];
        if(now == a && visit[b] != true){
          visit[b] = true;
          q.add(b);
          answer.add(b);
        }
      }
    }
  }
}
