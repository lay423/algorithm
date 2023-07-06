package algorithm.week9.java0706;

import java.util.*;

//5분58초 소요
class MemoryScore {
  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    int[] answer = new int[photo.length];
    Map<String, Integer> map = new HashMap<>();
    for(int i=0; i<name.length; i++){
      map.put(name[i], yearning[i]);
    }
    for(int i=0; i<photo.length; i++){
      int sum=0;
      for(int j=0; j<photo[i].length; j++){
        sum += map.getOrDefault(photo[i][j], 0);
      }
      answer[i] = sum;
    }
    return answer;
  }
}
