package algorithm.month0.week9.java0706;

import java.util.HashMap;
import java.util.Map;

//7분48초 소요
public class RunningRace {
  public String[] solution(String[] players, String[] callings) {
    String[] answer = {};
    Map<String, Integer> map = new HashMap<>();
    String[] race = new String[players.length];
    for(int i=0; i<players.length; i++){
      map.put(players[i], i);
      race[i] = players[i];
    }
    for(int i=0; i<callings.length; i++){
      int current = map.get(callings[i]);
      race[current] = race[current-1];
      race[current-1] = callings[i];

      map.put(callings[i], current-1);
      map.put(race[current], current);
    }
    return race;
  }
}
