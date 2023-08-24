package algorithm.week16.java0824;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
  static int N, K, result;

  static int[] visit = new int[100001];
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    bfs(N);
    System.out.println(result);
  }

  private static void  bfs(int node)
  {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(node);
    int n;
    visit[node] = 1;
    while (!queue.isEmpty())
    {
      n = queue.remove();

      if (n == K)
      {
        result = visit[n]-1;
        return;
      }

      if (n-1>=0 && visit[n-1] == 0)
      {
        visit[n-1] = visit[n]+1;
        queue.add(n-1);
      }
      if (n+1 <= 100000 && visit[n+1] == 0)
      {
        visit[n+1] = visit[n]+1;
        queue.add(n+1);
      }
      if (2*n <= 100000 && visit[2*n] == 0)
      {
        visit[2*n] = visit[n] + 1;
        queue.add(2*n);
      }
    }
    result = -1;
  }
}
