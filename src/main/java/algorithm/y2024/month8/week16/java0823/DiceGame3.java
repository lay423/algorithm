package algorithm.y2024.month8.week16.java0823;

import java.util.*;

class DiceGame3 {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, 1);
        map.put(b, map.getOrDefault(b, 0)+1);
        map.put(c, map.getOrDefault(c, 0)+1);
        map.put(d, map.getOrDefault(d, 0)+1);

        if(map.size() == 1){
            return 1111 * a;
        }
        else if(map.size() == 2){
            if(map.containsValue(3)){
                int answer = 0;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                    answer += entry.getKey() * (entry.getValue() == 3 ? 10 : 1);
                }
                return answer * answer;
            }
            int x = (a + b + c + d - 2*a)/2;
            return (a + x) * Math.abs(a - x);
        }
        else if(map.size() == 3){
            int answer = 1;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == 1)
                    answer *= entry.getKey();
            }
            return answer;
        }
        return Math.min(a, Math.min(b, Math.min(c, d)));

    }
}