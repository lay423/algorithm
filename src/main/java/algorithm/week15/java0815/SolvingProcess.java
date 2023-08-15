package algorithm.week15.java0815;

import java.io.*;
import java.util.*;

//암호 만들기
public class SolvingProcess {

  static boolean[] visit;
  static char[] arr;
  static int L, C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new char[C];
    visit = new boolean[C];

    for (int i = 0; i < C; i++) {
      arr[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(arr);

    for(int i=0; i<C-L+1; i++){
      visit[i] = true;
      search(i, 1, L);
    }
  }

  private static void search(int now, int current, int depth) {

    if(current == depth){
      int lowerCnt=0, upperCnt=0;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < L; i++) {
        if(visit[i]){
          sb.append(arr[i]);
          if(arr[i]== 'a' || arr[i] == 'e' ||
              arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
            lowerCnt++;
          else
            upperCnt++;
        }
      }
      if (lowerCnt >= 1 && upperCnt >= 2) {
        System.out.println(sb);
      }
    }

    for(int i= now+1; i<C; i++){
      if(visit[i])
        continue;
      visit[i] = true;
      search(i, current+1, depth);
      visit[i] = false;
    }
  }
}
