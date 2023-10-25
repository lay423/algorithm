package algorithm.month9.week20.java0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//삼성 SW 역량테스트 2021 상반기 오후 1번 문제
public class TreeTycoon {

  static int n;
  static int[] dy = {1, 1, -1, -1};
  static int[] dx = {1, -1, 1, -1};
  static int[][] board;
  static List<int[]> nutrients;
  static boolean[][] isNutrient;


  public static void main(String[] args) throws IOException {
    // 여기에 코드를 작성해주세요.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    isNutrient = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    nutrients = new ArrayList<>();
    nutrients.add(new int[]{n - 1, 0});
    nutrients.add(new int[]{n - 2, 0});
    nutrients.add(new int[]{n - 1, 1});
    nutrients.add(new int[]{n - 2, 1});

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int direction = Integer.parseInt(st.nextToken());
      int amount = Integer.parseInt(st.nextToken());
      growTree(direction, amount);
      //printBoard();
    }

    int sum = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sum += board[i][j];
      }
    }
    System.out.println(sum);
  }

  private static void printBoard() {
    for (int[] b : board) {
      for (int j = 0; j < b.length; j++) {
        System.out.print(b[j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void growTree(int direction, int amount) {

    moveNutrients(direction, amount);
    injectNutrients();
    cutTree();
  }

  private static void cutTree() {
    for (int[] nutrient : nutrients) {
      isNutrient[nutrient[0]][nutrient[1]] = true;
    }

    nutrients = new ArrayList<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (!isNutrient[i][j] && board[i][j] >= 2){
          board[i][j] -=2;
          nutrients.add(new int[]{i, j});
        }

      }
    }

  }

  private static void injectNutrients() {
    for (int[] nutrient : nutrients) {
      board[nutrient[0]][nutrient[1]]++;
    }
    for (int[] nutrient : nutrients) {
      int sum = 0;
      for (int j = 0; j < 4; j++) {
        int ny = nutrient[0] + dy[j];
        int nx = nutrient[1] + dx[j];

        if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
          if (board[ny][nx] >= 1) {
            sum++;
          }
        }
      }
      board[nutrient[0]][nutrient[1]] += sum;
    }
  }

  private static void moveNutrients(int direction, int amount) {
    int x = 0, y = 0;
    if (direction == 1) {
      x = 1;
    } else if (direction == 2) {
      y = -1;
      x = 1;
    } else if (direction == 3) {
      y = -1;
    } else if (direction == 4) {
      y = -1;
      x = -1;
    } else if (direction == 5) {
      x = -1;
    } else if (direction == 6) {
      y = 1;
      x = -1;
    } else if (direction == 7) {
      y = 1;
    } else if (direction == 8) {
      y = 1;
      x = 1;
    }
    y *= amount;
    x *= amount;

    for (int i = 0; i < nutrients.size(); i++) {
      int[] nutrient = nutrients.get(i);
      int ny = nutrient[0] + y;
      int nx = nutrient[1] + x;

      if (ny >= n) {
        ny -= n;
      } else if (ny < 0) {
        ny += n;
      }

      if (nx >= n) {
        nx -= n;
      } else if (nx < 0) {
        nx += n;
      }

      nutrients.set(i, new int[]{ny, nx});
    }
  }
}
