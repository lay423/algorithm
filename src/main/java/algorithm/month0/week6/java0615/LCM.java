package algorithm.month0.week6.java0615;

public class LCM {

  public int solution(int[] arr) {
    int answer = 1;

    if (arr.length == 1) {
      return arr[0];
    }

    int i = arr[0];
    while (true) {
      int cnt = 0;
      for (int j = 0; j < arr.length; j++) {
        if (i % arr[j] == 0) {
          cnt++;
        }
      }
      if (cnt == arr.length) {
        answer = i;
        break;
      }
      i++;

    }
    return answer;
  }
}
