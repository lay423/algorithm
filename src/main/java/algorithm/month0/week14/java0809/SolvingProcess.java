package algorithm.month0.week14.java0809;

import java.util.*;
import java.io.*;

//[HSAT 5회 정기 코딩 인증평가 기출] 성적 평가
public class SolvingProcess {


  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Map<Integer, Integer> sum = new HashMap<>();
    Map<Integer, Integer> cur = new HashMap<>();
    Map<Integer, Integer> award = new HashMap<>();
    for(int i=0; i<N; i++){
      sum.put(i, 0);
    }

    for(int i=0; i<3; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; j++){
        int value = Integer.parseInt(st.nextToken());
        cur.put(j, value);
        sum.put(j, sum.getOrDefault(j, 0) + value);
      }

      //정렬
      List<Integer> keySet = new ArrayList<>(cur.keySet());
      keySet.sort((o1, o2) -> cur.get(o2).compareTo(cur.get(o1)));
      for(int k=0; k< keySet.size(); k++){
        if(k>0 && cur.get(keySet.get(k)).equals(cur.get(keySet.get(k-1))))
          award.put(keySet.get(k), award.get(keySet.get(k-1)));
        else
          award.put(keySet.get(k), k+1);
      }

      //출력
      for(int j=1; j<=N; j++){
        System.out.print(award.get(j)+" ");
      }
      System.out.println();
    }//for

    List<Integer> keySet = new ArrayList<>(sum.keySet());
    keySet.sort((o1, o2) -> sum.get(o2).compareTo(sum.get(o1)));
    for(int k=0; k< keySet.size(); k++){
      if(k>0 && cur.get(keySet.get(k)).equals(cur.get(keySet.get(k-1))))
        award.put(keySet.get(k), award.get(keySet.get(k-1)));
      else
        award.put(keySet.get(k), k+1);
    }
    for(int j=1; j<=N; j++){
      System.out.print(award.get(j)+" ");
    }

  }
}
