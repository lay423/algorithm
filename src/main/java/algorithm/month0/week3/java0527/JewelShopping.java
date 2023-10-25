package algorithm.month0.week3.java0527;

import java.util.HashMap;
import java.util.HashSet;

class JewelShopping {
  public int[] solution(String[] gems) {
    int[] answer = new int[2];
    HashSet<String> set = new HashSet<>();

    for(String gem : gems){
      set.add(gem);
    }
    int n = gems.length;
    int distance = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    int start = 0;
    int end = 0;

    HashMap<String, Integer> map = new HashMap<>();
    while(true){
      //left 인덱스를 증감시키며 map에서 gems[left] 제거
      if(set.size() == map.size()){
        map.put(gems[left], map.get(gems[left])-1);

        if(map.get(gems[left]) == 0){
          map.remove(gems[left]);
        }
        left++;
      }
      else if(right == n){
        break;
      }
      //right 인덱스를 증감시키며 map에서 gems[right] 추가
      else{
        map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
        right++;
      }

      if(set.size() == map.size()){
        if(right - left < distance){
          distance = right - left;
          start = left + 1;
          end = right;
        }
      }
    }//while

    answer[0] = start;
    answer[1] = end;
    return answer;
  }
}