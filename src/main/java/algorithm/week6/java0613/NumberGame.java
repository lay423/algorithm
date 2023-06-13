package algorithm.week6.java0613;

public class NumberGame {
  public String solution(int n, int t, int m, int p) {

    int gameTime = t*m;
    StringBuilder answer = new StringBuilder();
    StringBuilder sFull = new StringBuilder();

    for(int i=0; i<gameTime; i++){
      sFull.append(Integer.toString(i, n));
    }
    sFull = new StringBuilder(sFull.toString().toUpperCase());
    int i = p-1;
    while(i<t*m){
      answer.append(sFull.charAt(i));
      i+=m;
    }

    return answer.toString();
  }
}
