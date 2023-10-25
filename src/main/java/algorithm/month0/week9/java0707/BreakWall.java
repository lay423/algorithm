package algorithm.month0.week9.java0707;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakWall {
  static int n, m;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    //출발지와 목적지가 같을 경우
    if(n==1&&m==1) {
      System.out.println(1);
      System.exit(0);
    }
    // NxM 맵 행렬 생성 (1과 0이 값으로 들어옴)
    map = new int[n][m];
    for (int i = 0; i < map.length; i++) {
      String str = br.readLine();
      for (int j = 0; j < map[i].length; j++) {
        int num = str.charAt(j) - '0';
        if (num == 1) {
          map[i][j] = num;
        }
      }
    }
    System.out.println(bfs());

  }

  private static int bfs() {
    // 방문을 체크하는 3차원 배열
    int[][][] check = new int[2][n][m];
    // [0, n, m] : 벽 안부수고 지나가는 방문노드 경로
    // [1, n, m] : 벽 부수고 지나가는 방문노드 경로

    // 동서남북
    int[] ax = { 0, 0, -1, 1 };
    int[] ay = { -1, 1, 0, 0 };

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { 0, 0, 0 });
    check[0][0][0] = 1;

    while (true) {

      int[] node = q.poll();
      if (node == null) {
        return -1;
      }
      int w = node[0];// broken wall or unbroken wall
      int x = node[1];
      int y = node[2];

      for (int i = 0; i < 4; i++) {
        int nx = x + ax[i];
        int ny = y + ay[i];
        if (nx >= n || nx < 0 || ny >= m || ny < 0) {
          continue;
        }

        if (w == 0) {// 지금 노드가 벽이 아닐 때
          if (map[nx][ny] == 0 && check[0][nx][ny]==0) { // 다음 노드가 벽이 아닐 때

            q.offer(new int[] { 0, nx, ny });
            check[0][nx][ny] = check[0][x][y] + 1;
          } else if(map[nx][ny] == 1 && check[0][nx][ny]==0){ // 다음 노드가 벽일 때
            if (check[1][nx][ny] == 0) {// 다음 노드가 이전에 방문한 적이 있다면 pass

              q.offer(new int[] { 1, nx, ny });
              check[1][nx][ny] = check[0][x][y] + 1;
            }
          }
        } else {
          if (map[nx][ny] == 0) { // 다음 노드가 벽이 아닐 때
            if (check[1][nx][ny] == 0) {

              q.offer(new int[] { 1, nx, ny });
              check[1][nx][ny] = check[1][x][y] + 1;
            }
          }
        }
        if (nx == n - 1 && ny == m - 1) {
          return Math.max(check[0][nx][ny], check[1][nx][ny]);
        }

      }

    }

  }

}