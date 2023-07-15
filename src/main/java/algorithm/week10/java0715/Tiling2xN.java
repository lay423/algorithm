package algorithm.week10.java0715;

public class Tiling2xN {
  public int solution(int n) {
    int answer = 0;

    int[] arr = new int[n];
    arr[0] = 1;
    arr[1] = 2;

    for (int i = 2; i < n; i++) {
      int num = arr[i - 1] + arr[i - 2];
      arr[i] = num % 1000000007;
    }

    return arr[n-1];
  }
}