package algorithm.month0.week2.java0519;

import java.util.*;

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
