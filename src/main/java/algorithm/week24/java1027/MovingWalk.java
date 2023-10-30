package algorithm.week24.java1027;

import java.util.Scanner;

class Plate {
  int stability;
  boolean occupied;

  public Plate(int stability, boolean occupied) {
    this.stability = stability;
    this.occupied = occupied;
  }
}

public class MovingWalk {
  public static final int MAX_N = 100;

  public static int n, k;

  public static Plate[] u = new Plate[MAX_N];
  public static Plate[] d = new Plate[MAX_N];

  public static void shift() {
    Plate temp = u[n - 1];
    for(int i = n - 1; i >= 1; i--)
      u[i] = u[i - 1];
    u[0] = d[n - 1];

    for(int i = n - 1; i >= 1; i--)
      d[i] = d[i - 1];
    d[0] = temp;
  }

  public static boolean canGo(int idx) {
    // 밖으로 나가는 것은 항상 가능합니다.
    if(idx == n)
      return true;

    // 안정성이 0보다 크면서 사람이 없는 경우에만
    // 이동이 가능합니다.
    int stability = u[idx].stability;
    boolean occupied = u[idx].occupied;
    return stability > 0 && !occupied;
  }

  public static void move(int idx) {
    // 현재 위치에 있던 사람은 사라집니다.
    int currStability = u[idx].stability;
    u[idx] = new Plate(currStability, false);

    // 밖으로 나가는 것이 아니라면,
    // 안정성이 1 감소하며, 사람이 추가됩니다.
    if(idx + 1 < n) {
      int nextStability = u[idx + 1].stability;
      u[idx + 1] = new Plate(nextStability - 1, true);
    }
  }

  public static void moveAll() {
    // 현재 위치에 사람이 있고, 그 다음 위치로 이동이
    // 가능한 경우에만 움직입니다.
    for(int i = n - 1; i >= 0; i--) {
      boolean occupied = u[i].occupied;
      if(occupied && canGo(i + 1))
        move(i);
    }
  }

  public static void add() {
    // 안정성이 0보다 크고 사람이 없는 경우에만
    // 첫 번째 위치에 사람을 올려놓습니다.
    int stability = u[0].stability;
    boolean occupied = u[0].occupied;
    if(stability > 0 && !occupied)
      u[0] = new Plate(stability - 1, true);
  }

  public static void simulate() {
    // Step1. 무빙워크를 한 칸 회전시킵니다.
    shift();

    // Step2. 사람들을 한 칸씩 앞으로 이동시킵니다.
    moveAll();

    // Step3. 사람을 새로 올립니다.
    add();

    // Step4. n번 칸 위치에 사람이 있다면, 즉시 내려줍니다.
    boolean occupied = u[n - 1].occupied;
    if(occupied)
      move(n - 1);
  }

  public static boolean done() {
    int unstableCnt = 0;
    for(int i = 0; i < n; i++) {
      int stability = u[i].stability;
      if(stability == 0) unstableCnt++;
    }
    for(int i = 0; i < n; i++) {
      int stability = d[i].stability;
      if(stability == 0) unstableCnt++;
    }

    return unstableCnt >= k;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();

    for(int i = 0; i < n; i++) {
      int stability = sc.nextInt();
      u[i] = new Plate(stability, false);
    }
    for(int i = 0; i < n; i++) {
      int stability = sc.nextInt();
      d[i] = new Plate(stability, false);
    }

    int trial = 0;
    while(!done()) {
      simulate();
      trial++;
    }

    System.out.print(trial);
  }
}
