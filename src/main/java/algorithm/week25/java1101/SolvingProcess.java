package algorithm.week25.java1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BJ18111
public class SolvingProcess {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int[][] board = new int[N][M];
    double sum = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        sum += board[i][j];
      }
    }

    double tmp = sum / (N * M);
    int target = (int) Math.round(tmp);
    int targetSum = target * N * M;

    //System.out.println("sum: " + sum);
    //System.out.println("target: " + target);
    //System.out.println("targetSum: "+ targetSum);

    if(targetSum > (sum + b))
      target--;

    int time = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int ground = board[i][j];
        if (ground > target) {
          time += (ground - target) * 2;
        } else if (ground < target) {
          time += target - ground;
        }
      }
    }
    System.out.println(time + " " + target);



  }

}
