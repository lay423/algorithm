package algorithm.week5.java0605;

import java.util.HashMap;

public class PersonalityTypeTest {

  public static void main(String[] args) {
    PersonalityTypeTest typeTest = new PersonalityTypeTest();
    String solution = typeTest.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},
        new int[]{5, 3, 2, 7, 5});
    System.out.println(solution);
  }
  static HashMap<Character, Integer> map = new HashMap<>();
  public String solution(String[] survey, int[] choices) {
    String answer = "";
    map.put('R', 0);
    map.put('T', 0);
    map.put('C', 0);
    map.put('F', 0);
    map.put('J', 0);
    map.put('M', 0);
    map.put('A', 0);
    map.put('N', 0);
    for(int i=0; i<survey.length; i++){
      int ch = choices[i];
      if(ch==4)
        continue;
      else if(ch<4){
        char sur1 = survey[i].charAt(0);
        map.put(sur1, map.getOrDefault(sur1, 0)+4-ch);
      }else if(ch>4){
        char sur1 = survey[i].charAt(1);
        map.put(sur1, map.getOrDefault(sur1, 0)-4+ch);
      }
    }

    answer += getChar('R', 'T');
    answer += getChar('C', 'F');
    answer += getChar('J', 'M');
    answer += getChar('A', 'N');


    return answer;
  }
  private static char getChar(char a, char b){
    if(map.get(a) >= map.get(b)){
      return a;
    }else{
      return b;
    }
  }
}
