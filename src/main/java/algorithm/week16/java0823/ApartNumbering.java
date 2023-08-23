package algorithm.week16.java0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ApartNumbering {
  private static int dx[] = {0,0,1,-1};
  private static int dy[] = {1,-1,0,0};
  private static int[] aparts = new int[25*25];
  private static int n;
  private static int apartNum = 0; //아파트 단지 번호의 수
  private static boolean[][] visit = new boolean[25][25]; //방문여부
  private static int[][] board = new int[25][25]; //지도

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    visit = new boolean[n][n];

    for(int i=0; i<n; i++){
      String input = br.readLine();
      for(int j=0; j<n; j++){
        board[i][j] = input.charAt(j)-'0';
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(board[i][j] == 1 && !visit[i][j]){
          apartNum++;
          dfs(i,j);
        }
      }
    }

    Arrays.sort(aparts);
    System.out.println(apartNum);

    for(int i=0; i<aparts.length; i++){
      if(aparts[i] == 0){
      }else{
        System.out.println(aparts[i]);
      }
    }
  }

  private static void dfs(int x, int y) {
    visit[x][y] = true;
    aparts[apartNum]++;

    for(int i=0; i<4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx >=0 && ny >=0 && nx < n && ny < n){
        if(board[nx][ny] == 1 && !visit[nx][ny]){
          dfs(nx,ny);
        }
      }
    }
  }
}
