package algorithm.week15.java0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDelivery {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] board = new int[N][N];
    List<int[]> home = new ArrayList<>();
    List<int[]> chicken = new ArrayList<>();

    //집, 치킨집 초기화
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int type = Integer.parseInt(st.nextToken());
        if(type == 1)
          home.add(new int[] {i, j});
        else if (type == 2) {
          chicken.add(new int[]{i, j});
        }
      }
    }

    boolean[] array = new boolean[chicken.size()];




  }
}
