package algorithm.month0.week8.java0628;

public class SolvingProcess {

  public static void main(String[] args) {
    SolvingProcess atoB = new SolvingProcess();
    String s = "A";
    String t = "BABA";
    int solution = atoB.solution(s, t);
    System.out.println("answer="+solution);
  }
  static boolean[] aVisited;
  static String tBase;
  static int answer = 0;
  public int solution(String s, String t){
    int sL = s.length();
    int tL = t.length();
    tBase = t;
    aVisited = new boolean[tL-sL];
    for(int i=0; i<tL-sL; i++){
      bfs(i, s, tL);
    }
    return answer;
  }
  public String aCal(String s){
    return s+='a';
  }
  public String bCal(String s){
    s += 'a';
    String answer="";
    for(int i=s.length()-1; i>=0; i--){
      answer += s.charAt(i);
    }
    return answer;
  }
  public void bfs(int depth, String s, int tLength){
    if(s.length() == tLength && tBase.equals(s)){
      answer = 1;
    }

    for(int i=0; i<tLength; i++){
      if(aVisited[i]){
        //s = aCal(s);
      }else{
        //s = bCal(s);
      }
      aVisited[i] = true;
      bfs(i+1, s, tLength);
      aVisited[i] = false;

    }
  }
}
