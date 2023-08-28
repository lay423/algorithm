package algorithm.week17.java0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//동전2
public class SolvingProcess {

  static int min = Integer.MAX_VALUE;
  static int k;
  static int[] coin;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    coin = new int[n];
    for (int i = 0; i < n; i++) {
      coin[i] = Integer.parseInt(br.readLine());
    }
    for (int i = n - 1; i >= 0; i--) {
      search(i, 0, k);
    }
    System.out.println(min);
  }

  private static void search(int current, int cnt, int target) {
    if(target>coin[current]){
      cnt += target/coin[current];
      target = target%coin[current];
    }
    if (target == 0) {
      min = Math.min(cnt, min);
      return;
    }
    for (int i = current - 1; i >= 0; i--) {
      search(i, cnt, target);
    }
  }

}
