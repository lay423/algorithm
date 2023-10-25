package algorithm.month0.week13.java0803;

import java.util.*;

class StringCompression {
  public int solution(String s) {
    int answer = s.length();
    int size = s.length();
    for(int i=1; i<s.length()/2+1; i++){
      int value = cntStringByValue(s, i);
      if(value < answer){
        answer = value;
      }
    }

    return answer;
  }

  private int cntStringByValue(String s, int value){
    StringBuilder sb = new StringBuilder();
    int cnt=1;
    while(true){
      if(s.length() < value*2){
        if(cnt>1)
          sb.append(cnt);
        sb.append(s);
        break;
      }

      String s1 = s.substring(0, value);
      String s2 = s.substring(value, value*2);
      if(s1.equals(s2)){
        cnt++;
      }else if(!s1.equals(s2)){
        if(cnt > 1){
          sb.append(cnt).append(s1);
          cnt = 1;
        }else
          sb.append(s1);
      }
      s = s.substring(value);
    }
    return sb.toString().length();
  }
}
