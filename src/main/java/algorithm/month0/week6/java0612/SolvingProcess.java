package algorithm.month0.week6.java0612;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolvingProcess {
  public List<Integer> solution(String today, String[] terms, String[] privacies) {
    int[] answer = {};


    int[] nDate = dateParse(today);
    List<Integer> list = new ArrayList<>();

    Map<String, Integer> map = new HashMap<>();
    for(int i=0; i<terms.length; i++){
      String[] s = terms[i].split(" ");
      map.put(s[0], Integer.parseInt(s[1]));
    }

    for(int i=0; i<privacies.length; i++){
      String[] s = privacies[i].split(" ");
      int[] pDate = dateParse(s[0]);
      int month = map.get(s[1]);
      pDate[1] += month;

      if(pDate[1] > 12){
        pDate[0] = pDate[0] + (pDate[1] / 12);
        pDate[1] = pDate[1] % 12;
        pDate[2] -= 1;
      }

      if(pDate[0] < nDate[0] ||
          (pDate[0] == nDate[0] && pDate[1] < nDate[1]) ||
          (pDate[0] == nDate[0] && pDate[1] == nDate[1] && pDate[2] < nDate[2]) ||
          (pDate[0] == nDate[0] && pDate[1] == nDate[1] && pDate[2] == nDate[2]))
        list.add(i+1);

    }

    return list;
  }

  private int[] dateParse(String s){
    String[] sArr = s.split("[.]");
    int[] date = new int[sArr.length];
    for(int i=0; i<sArr.length; i++){


      date[i] = Integer.parseInt(sArr[i]);
    }
    return date;
  }

}
