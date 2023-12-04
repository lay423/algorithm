package algorithm.month11.week29.java1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BJ14891 톱니바퀴
 */
public class Gear {
    static int[][] gearInfo = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                gearInfo[i][j] = input.charAt(j) - '0'; //0:N극, 1:S극
            }
        }

        StringTokenizer st;
        int numOfRotations = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfRotations; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()); //1:시계방향, -1:반시계방향
            operateTrigger(idx, dir);
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Math.pow(2, i) * gearInfo[i][0];
        }
        System.out.println(sum);
    }

    /*
    callFunc, makeBothGearRotate
     */
    private static void operateTrigger(int idx, int dir) {
        judgeLeftSide(idx - 1, -dir);
        judeRightSide(idx + 1, -dir);
        rotateGear(idx, dir);
    }

    private static void judgeLeftSide(int idx, int dir) {
        if (idx < 0) return;
        if (gearInfo[idx][2] == gearInfo[idx + 1][6]) return;
        judgeLeftSide(idx - 1, -dir);
        rotateGear(idx, dir);
    }

    private static void judeRightSide(int idx, int dir) {
        if (idx > 3) return;
        if (gearInfo[idx][6] == gearInfo[idx - 1][2]) return;
        judeRightSide(idx + 1, -dir);
        rotateGear(idx, dir);
    }

    private static void rotateGear(int idx, int dir) {//1:시계방향, -1:반시계방향
        if (dir == 1) {
            int tmp = gearInfo[idx][7];
            for (int i = 7; i > 0; i--) {
                gearInfo[idx][i] = gearInfo[idx][i - 1];
            }
            gearInfo[idx][0] = tmp;
        } else {
            int tmp = gearInfo[idx][0];
            for (int i = 0; i < 7; i++) {
                gearInfo[idx][i] = gearInfo[idx][i + 1];
            }
            gearInfo[idx][7] = tmp;
        }
    }
}
