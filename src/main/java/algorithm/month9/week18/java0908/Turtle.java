package algorithm.month9.week18.java0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Turtle {

  static int dx[] = {0, 1, 0, -1};
  static int dy[] = {1, 0, -1, 0};
  static int maxX, maxY, minX, minY, dir, x, y;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[] answer = new int[T];

    String now;
    char order;

    for (int i = 0; i < T; i++) {
      now = br.readLine();
      maxX = 0;
      maxY = 0;
      minX = 0;
      minY = 0;
      dir = 0;
      x = 0;
      y = 0;
      for (int j = 0; j < now.length(); j++) {
        order = now.charAt(j);
        if (order == 'F') {
          x += dx[dir];
          y += dy[dir];
          setMaxAndMin();
        } else if (order == 'B') {
          x -= dx[dir];
          y -= dy[dir];
          setMaxAndMin();
        } else if (order == 'L') {
          if (dir == 0) {
            dir = 4;
          }
          dir--;
        } else if (order == 'R') {
          dir++;
          if (dir == 4) {
            dir = 0;
          }
        }
      }
      int width=maxX-minX;
      int height=maxY-minY;
      answer[i] = width*height;
    }
    for (int i : answer) {
      System.out.println(i);
    }
  }

  private static void setMaxAndMin() {
    maxX=Math.max(x, maxX);
    maxY=Math.max(y, maxY);
    minX=Math.min(x, minX);
    minY=Math.min(y, minY);
  }
}

