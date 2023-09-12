package algorithm.week19.java0912;

import java.util.Scanner;

//삼성 SW 역량테스트 2020 상반기 오전 1번문제
//2차원 테트리스
public class Main {
  public static final int TILE_NUM = 3;
  public static final int MAX_M = 4;
  public static final int MAX_N = 6;
  public static final int BOARD_NUM = 2;

  // 3가지 타일 모양을 지정합니다.
  public static int[][][] shapes = new int[][][]{
      {},

      {{1, 0},
          {0, 0}},

      {{1, 1},
          {0, 0}},

      {{1, 0},
          {1, 0}},
  };

  public static int n = 6, m = 4, k;
  public static int[][][] board = new int[BOARD_NUM][MAX_N][MAX_M];

  public static int score;

  public static boolean inRange(int x, int y) {
    return 0 <= x && x < n && 0 <= y && y < m;
  }

  public static boolean canGo(int bNum, int tileType, int x, int y) {
    // 바닥에 부딪히거나, 벽돌이 존재하는 경우에는
    // 진행이 불가합니다.
    for(int dx = 0; dx < 2; dx++)
      for(int dy = 0; dy < 2; dy++)
        if(shapes[tileType][dx][dy] == 1) {
          int nx = x + dx, ny = y + dy;

          if(!inRange(nx, ny) ||
              board[bNum][nx][ny] > 0)
            return false;
        }

    return true;
  }

  public static void put(int bNum, int tileType, int x, int y) {
    for(int dx = 0; dx < 2; dx++)
      for(int dy = 0; dy < 2; dy++)
        if(shapes[tileType][dx][dy] == 1) {
          int nx = x + dx, ny = y + dy;
          board[bNum][nx][ny] = 1;
        }
  }

  public static boolean allFilled(int bNum, int row) {
    for(int col = 0; col < m; col++)
      if(board[bNum][row][col] == 0)
        return false;

    return true;
  }

  public static void downOneLine(int bNum, int endRow) {
    for(int row = endRow; row >= 1; row--)
      for(int col = 0; col < m; col++) {
        board[bNum][row][col] = board[bNum][row - 1][col];
        board[bNum][row - 1][col] = 0;
      }
  }

  public static void processDark(int bNum) {
    // 아래에서 위 방향으로 줄 마다
    // 가득 채워져 있는지 확인하여
    // 그 경우에는 점수에 1을 더해주고
    // 한 줄씩 당겨줍니다.
    int row = n - 1;
    while(row >= 2) {
      if(allFilled(bNum, row)) {
        score++;
        downOneLine(bNum, row);
      }
      else
        row--;
    }
  }

  public static boolean blockExist(int bNum, int row) {
    for(int col = 0; col < m; col++)
      if(board[bNum][row][col] == 1)
        return true;

    return false;
  }

  public static void processLight(int bNum) {
    // Step1. 첫 번째 행, 두 번째 행 중
    // 블럭이 한 개라도 놓여있는 행의 수를 셉니다.

    int dropCnt = 0;
    if(blockExist(bNum, 0))
      dropCnt++;
    if(blockExist(bNum, 1))
      dropCnt++;

    // Step2.
    // 해당 수 만큼 타일을 한 줄씩 내려줍니다.
    while(dropCnt-- > 0)
      downOneLine(bNum, n - 1);
  }

  public static void drop(int bNum, int tileType, int col) {
    // Step1. 블럭을 떨어뜨립니다.
    for(int row = 0; row < n; row++) {
      // 그 다음 행으로 진행할 수 없다면
      // 블럭을 안착시킵니다.
      if(!canGo(bNum, tileType, row + 1, col)) {
        put(bNum, tileType, row, col);
        break;
      }
    }

    // Step2. 진한 부분에 대한 처리를 진행합니다.
    processDark(bNum);

    // Step3. 연한 부분에 대한 처리를 진행합니다.
    processLight(bNum);
  }

  public static void simulate(int t, int x, int y) {
    // Step1. 노란색 영역에서 진행합니다.
    drop(0, t, y);

    // Step2. 빨간색 영역에서 진행합니다.
    // 이는 그림에서 빨간색 영역을
    // 시계방향으로 90' 회전하여
    // 노란색 영역에서와 같이 진행하면 됩니다.
    // 각각의 블럭 type에 대해
    // 떨어지는 위치 선정이 중요합니다.
    if(t == 1)
      drop(1, 1, m - 1 - x);
    else if(t == 2)
      drop(1, 3, m - 1 - x);
    else
      drop(1, 2, m - 1 - (x + 1));
  }

  public static int remainingNum() {
    int cnt = 0;

    for(int l = 0; l < 2; l++)
      for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
          cnt += board[l][i][j];

    return cnt;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    k = sc.nextInt();

    // k번 시뮬레이션을 반복합니다.
    while(k-- > 0) {
      int t = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      simulate(t, x, y);
    }

    System.out.println(score);
    System.out.println(remainingNum());
  }
}
