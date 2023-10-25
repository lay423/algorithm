package algorithm.month0.week5.java0605;

import java.util.HashMap;

public class PersonalityTypeTestRefactor {

  public static void main(String[] args) {
    PersonalityTypeTestRefactor typeTest = new PersonalityTypeTestRefactor();
    String solution = typeTest.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},
        new int[]{5, 3, 2, 7, 5});
    System.out.println(solution);
  }
  static HashMap<Character, Integer> map = new HashMap<>();
  public String solution(String[] survey, int[] choices) {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<survey.length; i++){
      int value = choices[i];
      if(value==4)
        continue;
      else if(value<4){
        char ch = survey[i].charAt(0);
        map.put(ch, map.getOrDefault(ch, 0)+4-value);
      }else{
        char ch = survey[i].charAt(1);
        map.put(ch, map.getOrDefault(ch, 0)-4+value);
      }
    }

    return sb.append(getChar('R', 'T'))
        .append(getChar('C', 'F'))
        .append(getChar('J', 'M'))
        .append(getChar('A', 'N'))
        .toString();
  }
  private static char getChar(char a, char b){
    if(map.getOrDefault(a, 0) >= map.getOrDefault(b, 0)){
      return a;
    }else{
      return b;
    }
  }
}
