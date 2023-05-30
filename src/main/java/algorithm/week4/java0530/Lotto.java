package algorithm.week4.java0530;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

  public static void main(String[] args) {

  }
  public int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];
    int winCount = 0;
    int zCount = 0;
    List<Integer> list = new ArrayList<>();
    for(int num : lottos){
      if(num == 0)
        zCount++;
      list.add(num);
    }
    for(int i=0; i<win_nums.length; i++){
      if(list.contains(win_nums[i])){
        winCount++;
      }
    }
    answer[0] = 7 - (winCount + zCount);
    answer[1] = 7 - winCount;

    for(int i=0; i<2; i++){
      if(answer[i] >6)
        answer[i] = 6;
    }
    return answer;
  }
}
