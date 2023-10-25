package algorithm.month0.week4.java0602;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SolvingProcess {
  public int solution(String str1, String str2) {
    int answer = 0;
    str1 = str1.toLowerCase();
    str1 = str1.replaceAll("[^a-z]", "");
    str2 = str2.toLowerCase();
    str2 = str2.replaceAll("[^a-z]", "");
    List<String> list1 = new ArrayList<>();
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    List<String> list2 = new ArrayList<>();

    for(int i=0; i<str1.length()-1; i++){
      String ss = str1.substring(i, i+1);
      map1.put(ss, map1.getOrDefault(ss, 0)+1);
      list1.add(ss);
    }

    for(int i=0; i<str2.length()-1; i++){
      String ss = str2.substring(i, i+1);
      map2.put(ss, map2.getOrDefault(ss, 0)+1);
      list2.add(ss);
    }

    int min=0;
    int max=0;
    for(int i=0; i<map1.size(); i++){
      String ss = list1.get(i);
      if(map1.containsKey(ss) && map2.containsKey(ss)){
        if(map1.get(ss) < map2.get(ss))
          min += map1.get(ss);
        else
          min = map2.get(ss);
      }
    }

    for(Entry<String, Integer> entry : map1.entrySet()){
      max+=entry.getValue();
    }

    for(Entry<String, Integer> entry : map2.entrySet()){
      max+=entry.getValue();
    }

    System.out.println(min +" L "+ max);
    double d = min/(double)max;
    d *= 65536;
    return (int)d;
  }
}
