package algorithm.month12.week30.java1207;

import java.util.Scanner;
/*
코드트리 놀이기구 탑승
 */
class Cell {
    int friendCnt, blankCnt, x, y;

    public Cell(int friendCnt, int blankCnt, int x, int y) {
        this.friendCnt = friendCnt;
        this.blankCnt = blankCnt;
        this.x = x;
        this.y = y;
    }

    // this가 c보다 우선순위가 더 높은지 판단합니다.
    public boolean isHigher(Cell c) {
        // 좋아하는 친구 수는 많을수록 좋습니다.
        if(this.friendCnt != c.friendCnt)
            return this.friendCnt > c.friendCnt;
        // 빈 칸의 수는 많을수록 좋습니다.
        if(this.blankCnt != c.blankCnt)
            return this.blankCnt > c.blankCnt;
        // 행은 작을수록 좋습니다.
        if(this.x != c.x)
            return this.x < c.x;
        // 열은 작을수록 좋습니다.
        return this.y < c.y;
    }
}

public class RideTheRide {
    public static final int EMPTY = 0;
    public static final int DIR_NUM = 4;
    public static final int MAX_NUM = 400;
    public static final int MAX_N = 20;

    public static int n;

    public static int[] targetNum = new int[MAX_NUM + 1];
    public static boolean[][] friends = new boolean[MAX_NUM + 1][MAX_NUM + 1];

    // 놀이 기구 탑승 번호
    public static int[][] rides = new int[MAX_N + 1][MAX_N + 1];

    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    // num2가 num1이 좋아하는 친구인지 판단합니다.
    public static boolean isFriend(int num1, int num2) {
        return friends[num1][num2];
    }

    // 우선순위에 따라 쉽게 계산하기 위해
    // (좋아하는 친구 수, 빈 칸의 수, -행 번호, -열 번호)
    // 순서대로 값을 넣어줍니다.
    public static Cell getCurrCell(int num, int x, int y) {
        int friendCnt = 0, blankCnt = 0;
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(!inRange(nx, ny))
                continue;

            if(rides[nx][ny] == EMPTY)
                blankCnt++;
            else if(isFriend(num, rides[nx][ny]))
                friendCnt++;
        }

        return new Cell(friendCnt, blankCnt, x, y);
    }

    public static void move(int num) {
        // Step1. 가장 우선순위가 높은 칸을 선택합니다.
        Cell bestCell = new Cell(0, 0, n + 1, n + 1);
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (rides[i][j] != EMPTY)
                    continue;
                Cell curr = getCurrCell(num, i, j);
                if (curr.isHigher(bestCell))
                    bestCell = curr;
            }
        }

        // Step2. 해당 위치에 탑승합니다.
        int x = bestCell.x, y = bestCell.y;
        rides[x][y] = num;
    }

    // (x, y) 위치에 있는 학생의 점수를 계산합니다.
    public static int getScore(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(inRange(nx, ny) &&
                    isFriend(rides[x][y], rides[nx][ny]))
                cnt++;
        }

        return (int)Math.pow(10, cnt - 1);
    }

    // 총 점수를 계산합니다.
    public static int getTotalScore() {
        int score = 0;

        for(int i = 1; i <= n; i++)
            for(int j =

                1; j <= n; j++)
                score += getScore(i, j);

        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n * n; i++) {
            targetNum[i] = sc.nextInt();

            for(int j = 1; j <= 4; j++) {
                int friendNum = sc.nextInt();

                // 현재 번호에 친구 번호를 표시해줍니다.
                friends[targetNum[i]][friendNum] = true;
            }
        }

        // 순서대로 학생들을 놀이기구에 탑승시킵니다.
        for(int i = 1; i <= n * n; i++)
            move(targetNum[i]);

        // 총 점수를 계산합니다.
        int ans = getTotalScore();
        System.out.print(ans);
    }
}
