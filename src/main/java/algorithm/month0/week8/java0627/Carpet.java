package algorithm.month0.week8.java0627;

public class Carpet {
  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];

    int sum = brown + yellow; //가로와 세로의 최대 길이
    for(int i=1; i<=sum; i++) {
      if(sum%i == 0) { //세로의 약수가 되는 수 이어야 하기 때문에 나머지 0인 경우
        int j = sum / i; //세로의 나눈 몫이 세로가 됨
        if((i-2)*(j-2) == yellow) {
          answer[0] = j;
          answer[1] = i;
          break;
        }
      }
    }

    return answer;
  }
}
