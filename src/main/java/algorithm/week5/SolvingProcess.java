package algorithm.week5;

import java.util.HashMap;

public class SolvingProcess {
  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    double[] frate = new double[N];

    for(int i=0; i<N; i++){
      answer[i] = i+1;
    }

    HashMap<Integer, Integer> reach = new HashMap<>();
    HashMap<Integer, Integer> fail = new HashMap<>();

    for(int i=0; i<stages.length; i++){
      fail.put(stages[i], fail.getOrDefault(stages[i], 0)+1);
      for(int j=stages[i]; j>0; j--){
        reach.put(j, reach.getOrDefault(j, 0)+1);
      }
    }

    for(int k=0; k<stages.length; k++){
      int i = 0;
      int j = 0;
      i = fail.get(k);
      j = reach.get(k);
      frate[k] = (double)i / (double)j;
      if(j == 0 || i == 0)
        frate[k] = 0;
    }
    for(double f : frate){
      System.out.println(f);
    }

    for(int i=0; i<N; i++){
      for(int j=i; j<N; j++){
        if(frate[i]<frate[j]){
          double tmp = frate[i];
          frate[i] = frate[j];
          frate[j] = tmp;

          int tmp1 = answer[i];
          answer[i] = answer[j];
          answer[j] = tmp1;
        }
      }
    }

    return answer;
  }
}
