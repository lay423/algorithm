package algorithm.y2024.month2.week3.java0222;
import java.util.*;

class NearestLetter {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                map.put(entry.getKey(), map.get(entry.getKey())+1);
            }
            if(!map.containsKey(c)){
                answer[i] = -1;
                map.put(c, 0);
                continue;
            }
            answer[i] = map.get(c);
            map.put(c, 0);
        }

        return answer;
    }
}