package algorithm.month11.week29.java1129;
import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
코드트리 나무 타이쿤
 */
public class TreeTycoon {
    public static final int DIR_NUM = 8;
    public static final int MAX_N = 15;

    public static int n, m;

    public static int[][] height = new int[MAX_N][MAX_N];

    public static boolean[][] fertilizer = new boolean[MAX_N][MAX_N];
    public static boolean[][] nextFert = new boolean[MAX_N][MAX_N];

    // 문제에서 주어진 순서대로 → ↗ ↑ ↖ ← ↙ ↓ ↘
    public static int[] dx = new int[]{0, -1, -1, -1,  0,  1, 1, 1};
    public static int[] dy = new int[]{1,  1,  0, -1, -1, -1, 0, 1};

    public static void initFertilizer() {
        for(int i = n - 2; i < n; i++)
            for(int j = 0; j < 2; j++)
                fertilizer[i][j] = true;
    }

    public static Pair nextPos(int x, int y, int d, int p) {
        int nx = (x + dx[d] * p + n * p) % n;
        int ny = (y + dy[d] * p + n * p) % n;

        return new Pair(nx, ny);
    }

    public static void move(int d, int p) {
        // Step1. 그 다음 fert 위치를 저장할
        //        nextFert를 초기화합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                nextFert[i][j] = false;

        // Step2. 각 영양제를 이동합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(fertilizer[i][j]) {
                    Pair nPos = nextPos(i, j, d, p);
                    int nx = nPos.x, ny = nPos.y;
                    nextFert[nx][ny] = true;
                }

        // Step3. nextFert 값을 fert로 옮겨줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                fertilizer[i][j] = nextFert[i][j];
    }

    public static void grow() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(fertilizer[i][j])
                    height[i][j]++;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int getDiagCnt(int x, int y) {
        int cnt = 0;
        for(int i = 1; i < DIR_NUM; i += 2) {
            int nx = x + dx[i], ny = y + dy[i];
            if(inRange(nx, ny) && height[nx][ny] >= 1)
                cnt++;
        }

        return cnt;
    }

    public static void diagonalGrow() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(fertilizer[i][j]) {
                    int cnt = getDiagCnt(i, j);
                    height[i][j] += cnt;
                }
    }

    public static void determineFert() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                // 기존 특수 영양제는 없애주고
                if(fertilizer[i][j])
                    fertilizer[i][j] = false;

                    // 새로운 특수 영양제는 추가해줍니다.
                else if(height[i][j] >= 2) {
                    fertilizer[i][j] = true;
                    height[i][j] -= 2;
                }
            }
    }

    public static void simulate(int d, int p) {
        // Step 1. 특수 영양제를 이동시킵니다.
        move(d, p);

        // Step 2. 특수 영양제 위치에 있던 리브로수가 성장합니다.
        grow();

        // Step 3. 대각선 방향의 높이가 1이상인 리브로수 만큼
        //         더 성장합니다.
        diagonalGrow();

        // Step 4. 새로운 특수 영양제를 추가하고,
        //         기존 영양제를 없애줍니다.
        determineFert();
    }

    public static int getScore() {
        int sum = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                sum += height[i][j];

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                height[i][j] = sc.nextInt();

        initFertilizer();

        // m번에 걸쳐 시뮬레이션을 진행합니다.
        while(m-- > 0) {
            int d = sc.nextInt();
            int p = sc.nextInt();

            simulate(d - 1, p);
        }

        int ans = getScore();
        System.out.print(ans);

    }
}
