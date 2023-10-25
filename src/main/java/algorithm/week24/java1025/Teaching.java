package algorithm.week24.java1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Teaching {

  static int N, K, MAX=0;
  static boolean[] learn = new boolean[26];
  static String[] words;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    words = new String[N];
    for(int i=0; i<N; i++){
      String s = br.readLine();
      s = s.replace("anta", "");
      s = s.replace("tica", "");
      words[i] = s;
    }

    printAnswer();
  }

  private static void printAnswer() {
    //K가 5보다 작으면 anta, tica도 읽지 못하므로 0출력
    if(K<5){
      System.out.println(0);
      return;
    }else if(K == 26) { //모든 알파벳을 다 읽을 수 있다.
      System.out.println(N);
      return;
    }

    //5와 같거나 크면 탐색 시작
    learn[(int)'a'-'a'] = true;
    learn[(int)'n'-'a'] = true;
    learn[(int)'t'-'a'] = true;
    learn[(int)'i'-'a'] = true;
    learn[(int)'c'-'a'] = true;
    K -= 5;

    dfs(0, 0);

    System.out.println(MAX);
  }

  private static void dfs(int alpha, int cnt){

    if(cnt == K) {
      calculate();
      return;
    }
    for(int i=alpha; i<26; i++){
      if(learn[i])
        continue;

      learn[i] = true;
      dfs(i, cnt+1);
      learn[i] = false;
    }//for

  }

  //현재 배운 글자로 몇개의 단어를 읽을 수 있는지 계산
  private static void calculate() {
    int cnt=0;
    for(int i=0; i<N; i++){
      int L = words[i].length();
      boolean read = true;
      for(int j=0; j<L; j++){
        char c = words[i].charAt(j);
        if(!learn[c-'a']) {
          read = false;
          break;
        }
      }
      if(read)
        cnt++;
    }//for

    MAX = Math.max(MAX, cnt);
  }
}
