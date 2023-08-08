package algorithm.week14.java0808;

import java.util.*;
import java.io.*;

//[HSAT 6회 정기 코딩 인증평가 기출] 염기서열 커버
public class SequencingCover
{
  static int N, M;
  static List<String> list = new ArrayList<>();
  public static void main(String args[]) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i=0; i<N; i++){
      String s = br.readLine();
      compare(s);
    }

    System.out.println(list.size());
  }

  private static void compare(String s1){
    //list에 포함하는 염기서열 존재하는지 탐색
    for(int i=0; i<list.size(); i++){
      String s2 = list.get(i);

      //존재하면 두개를 합쳐서 list에 추가
      if(isInclude(s1, s2)){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<M; j++){
          if(s1.charAt(j)=='.' && s2.charAt(j)=='.'){
            sb.append('.');
          }else if(s1.charAt(j)=='.'){
            sb.append(s2.charAt(j));
          }else{
            sb.append(s1.charAt(j));
          }
        }
        list.set(i, sb.toString());
        return;
      }
    }//for

    //없으면 list에 추가
    list.add(s1);
  }

  private static boolean isInclude(String s1, String s2){
    for(int i=0; i<M; i++){
      if (s1.charAt(i) == '.' || s2.charAt(i) == '.') {
        continue;
      }
      if(s1.charAt(i)!=s2.charAt(i))
        return false;
    }
    return true;
  }
}