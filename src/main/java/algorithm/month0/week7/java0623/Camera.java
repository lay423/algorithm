package algorithm.month0.week7.java0623;

import java.util.Arrays;

public class Camera {

  public static void main(String[] args) {
    Camera camera = new Camera();
    camera.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});
  }

  public int solution(int[][] routes) {
    Arrays.sort(routes, (a,b)-> Integer.compare(a[1], b[1]));
    int cnt = 0;

    int min = Integer.MIN_VALUE;
    for(int[] route : routes) {
      if(min <  route[0] ) {
        min = route[1];
        ++cnt;
      }
    }
    return cnt;
  }
}
