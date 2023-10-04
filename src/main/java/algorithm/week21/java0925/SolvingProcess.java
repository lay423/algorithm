package algorithm.week21.java0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//감시
public class SolvingProcess {

  static int n, m;
  static int[][] board;
  static int MIN = Integer.MAX_VALUE;
  static List<int[]> cctv = new ArrayList<>();
  static int cctvCnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        board[i][j] = tmp;
        if (tmp >= 1 && tmp < 6) {
          cctv.add(new int[]{i, j, tmp});
        }
      }
    }
    cctvCnt = cctv.size();

    search();

  }

  private static void search() {
    int[][] arr = resetList();
    Queue<int[]> q = new LinkedList<>();




    int cnt = countingBlindSpot(arr);
    MIN = Math.min(MIN, cnt);
  }

  private static int countingBlindSpot(int[][] arr) {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  private static int[][] resetList() {
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = board[i][j];
      }
    }
    return arr;

  }
}
