package algorithm.week13.java0803;

import java.util.*;

public class Failure {

  public static int[] solution(int N, int[] stages){

    Map<Integer, Double> map = new HashMap<>();
    int[] fail = new int[N+2];
    int[] reach = new int[N+1];

    for (int stage : stages) {
      fail[stage]++;
    }

    reach[N] = fail[N] + fail[N+1];
    for (int i = N - 1; i >= 1; i--) {
      reach[i] = fail[i] + reach[i+1];
    }

    for (int i = 1; i < reach.length; i++) {
      if (fail[i] == 0 || reach[i] == 0) {
        map.put(i, 0.0);
      } else {
        map.put(i, (double) fail[i] / (double) reach[i]);
      }
    }

    List<Integer> list = new ArrayList<>(map.keySet());
    Collections.sort(list, ((o1, o2) -> Double.compare(map.get(o2), map.get(o1))));

    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
