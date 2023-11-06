package algorithm.month10.week23.java1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//코드트리 루돌프의 반란
public class SolvingProcess {

  static int N, M, P, C, D;
  static int[] deer = new int[2];
  static int[][] santa;
  static int[] score;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());   //게임판의 크기
    M = Integer.parseInt(st.nextToken());   //게임 턴 수
    P = Integer.parseInt(st.nextToken());   //산타의 수
    C = Integer.parseInt(st.nextToken());   //루돌프의 힘
    D = Integer.parseInt(st.nextToken());   //산타의 힘

    st = new StringTokenizer(br.readLine());
    deer[0] = Integer.parseInt(st.nextToken());
    deer[1] = Integer.parseInt(st.nextToken());

    santa = new int[P + 1][3];    //3번째 인덱스는 산타의 상태 0:정상 1:기절 2:탈락
    score = new int[P+1];
    Arrays.fill(score, 0);

    for (int i = 0; i < P; i++) {
      st = new StringTokenizer(br.readLine());
      int j = Integer.parseInt(st.nextToken());
      santa[j][0] = Integer.parseInt(st.nextToken());
      santa[j][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      deerMove();
      santaMove();
    }

  }

  private static void santaMove() {

  }

  private static void deerMove() {
    int closeSantaIdx = getCloseSanta();
    int[] deerDirection = getDeerDirection(closeSantaIdx);
    deer[0] += deerDirection[0];
    deer[1] += deerDirection[1];

    if(deer[0] == santa[closeSantaIdx][0] && deer[0] == santa[closeSantaIdx][1]){
      santaGetScore(C, closeSantaIdx);
      santaFly(C, deerDirection, closeSantaIdx);
    }
  }

  private static void santaFly(int mount, int[] direction, int idx) {
    santa[idx][0] += mount * direction[0];
    santa[idx][1] += mount * direction[1];
    judgeSantaOut(idx);

  }

  private static void judgeSantaOut(int idx){
    if(isSantaOut(idx)){
      santa[idx][2] = 2;
    }else
      santa[idx][2] = 1;
  }
  private static boolean isSantaOut(int idx) {
    int y = santa[idx][0];
    int x = santa[idx][1];

    if(y<1 || y>N || x<1 || x>N)
      return true;
    return false;
  }

  private static void santaGetScore(int mount, int idx) {
    score[idx] += mount;
  }

  private static int[] getDeerDirection(int closeSanta) {
    int[] direction = new int[2];
    if(deer[0] < santa[closeSanta][0]){
      direction[0] = 1;
    } else if (deer[0] > santa[closeSanta][0]) {
      direction[0] = -1;
    }
    int d = deer[1];
    int s = santa[closeSanta][1];
    if (d < s) {
      direction[1] = 1;
    } else if (d > s) {
      direction[1] = -1;
    }
    return direction;
  }

  private static int getCloseSanta() {
    int[] distances = new int[P + 1];
    int MIN = Integer.MAX_VALUE;
    int MINIdx = 0;
    for (int i = 1; i <= P; i++) {
      int dis = (santa[i][0] - deer[0]) ^ 2 + (santa[i][1] - deer[1]) ^ 2;
      if (MIN > dis) {
        MIN = dis;
        MINIdx = i;
      } else if (MIN == dis) {
        if (santa[MINIdx][0] < santa[i][0]) {
          MIN = dis;
          MINIdx = i;
        } else if (santa[MINIdx][1] < santa[i][1]) {
          MIN = dis;
          MINIdx = i;
        }
      }
    }//for
    return MINIdx;

  }
}
