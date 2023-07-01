package algorithm.week8.java0630;

import java.util.LinkedList;
import java.util.Queue;

public class DividePowerGrid {

  static boolean[][] connected;
  static int N;

  public int solution(int n, int[][] wires) {
    N = n;
    connected = new boolean[N + 1][N + 1];

    for (int i = 0; i < wires.length; i++) {
      connected[wires[i][0]][wires[i][1]] = true;
      connected[wires[i][1]][wires[i][0]] = true;
    }

    int answer = Integer.MAX_VALUE;

    for (int i = 0; i < wires.length; i++) {
      connected[wires[i][0]][wires[i][1]] = false;
      connected[wires[i][1]][wires[i][0]] = false;

      answer = Math.min(answer, bfs());

      connected[wires[i][0]][wires[i][1]] = true;
      connected[wires[i][1]][wires[i][0]] = true;
    }

    return answer;
  }

  static int bfs() {
    boolean[] visited = new boolean[N + 1];
    int cnt = 1;

    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    while (!q.isEmpty()) {
      int wire = q.remove();
      visited[wire] = true;

      for (int i = 1; i <= N; i++) {
        // if already visited -> skip
        if (visited[i]) {
          continue;
        }
        // if connected to wire -> cnt++, and add to queue
        if (connected[wire][i]) {
          q.add(i);
          cnt++;
        }
      }
    }
    return Math.abs(2*cnt - N);
  }
}
