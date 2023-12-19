package algorithm.month12.week31.java1218;

import java.util.Arrays;

class NumberGame {
  public int solution(int[] A, int[] B) {
    int answer = 0;

    Arrays.sort(A);
    Arrays.sort(B);
    for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
      if(A[i] < B[j]) {
        answer++;
        j--;
      }
    }

    return answer;
  }
}
