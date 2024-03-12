package algorithm.y2024.month3.week6.java0312;

import java.util.*;

//시소 짝꿍
class SeesawPartner {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for(int i=0; i<weights.length; i++){
            double w = weights[i];
            double a = w / 2;
            double b = w * 2 / 3;
            double c = w * 3 / 4;
            if(map.containsKey(w)) answer += map.get(w);
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        return answer;
    }
}