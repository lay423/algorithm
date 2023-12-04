package algorithm.month11.week26.java1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//우물안 개구리
public class SolvingProcess {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int answer = N;
    int[] weight = new int[N+1];
    boolean[] isThink = new boolean[N + 1];
    Arrays.fill(isThink, true);

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      weight[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (a > b) {
        if(!isThink[a])
          answer++;
        if(isThink[b])
          answer--;
        isThink[a] = true;
        isThink[b] = false;
      } else if (a < b) {
        if(!isThink[b])
          answer++;
        if(isThink[a])
          answer--;
        isThink[b] = true;
        isThink[a] = false;
      } else {
        if(isThink[a])
          answer--;
        if(isThink[b])
          answer--;
        isThink[a] = false;
        isThink[b] = false;
      }
    }
    System.out.println(answer);
  }

}
