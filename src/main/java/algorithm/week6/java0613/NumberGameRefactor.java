package algorithm.week6.java0613;

public class NumberGameRefactor {
  public String solution(int n, int t, int m, int p) {

    StringBuilder answer = new StringBuilder();
    StringBuilder sFull = new StringBuilder();

    for(int i=0; i<t*m; i++){
      sFull.append(Integer.toString(i, n));
    }

    for(int i=p-1; answer.length()<t; i+=m){
      answer.append(sFull.charAt(i));
    }

    return answer.toString().toUpperCase();
  }
}
