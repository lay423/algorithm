package algorithm.month10.week24.java1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxDifference {

  static int[] nums;
  static int[] shuffle;
  static boolean[] visit;
  static int N;
  static int MAX = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    nums = new int[N];
    shuffle = new int[N];
    visit = new boolean[N];

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0);
    System.out.println(MAX);
  }

  private static void dfs(int count) {
    if(count == N){
      MAX = Math.max(MAX, calculate());
    }

    for(int i=0; i<N; i++){
      if(!visit[i]){
        visit[i]=true;
        shuffle[count] = nums[i];
        dfs(count+1);
        visit[i] = false;
      }
    }


  }

  private static int calculate() {
    int answer=0;
    for (int i = 0; i < N-1; i++) {
      answer += Math.abs(shuffle[i] - shuffle[i + 1]);
    }
    return answer;
  }

}
