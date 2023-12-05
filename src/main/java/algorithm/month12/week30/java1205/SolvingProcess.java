package algorithm.month12.week30.java1205;

import java.util.HashMap;
import java.util.Map;

//프로그래머스 시소 짝꿍
public class SolvingProcess {
    public static void main(String[] args) {
        SolvingProcess main = new SolvingProcess();
        int[] weights = new int[]{100, 180, 360, 100, 270};
        long answer = main.solution(weights);
        System.out.println(answer);
    }

    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            int a = weight;
            int b = weight * 2;
            int c = weight * 3;
            int d = weight * 4;

            if (map.containsKey(a)) {
                map.put(a, map.getOrDefault(map.get(a), 0)+1);
                answer += map.get(a);
            }
            if (map.containsKey(b)) {
                map.put(a, map.getOrDefault(map.get(a), 0)+1);
                answer += map.get(a);
            }
            if (map.containsKey(c)) {
                map.put(a, map.getOrDefault(map.get(a), 0)+1);
                answer += map.get(a);
            }
            if (map.containsKey(d)) {
                map.put(a, map.getOrDefault(map.get(a), 0)+1);
                answer += map.get(a);
            }

            //map.put(a, map.getOrDefault(map.get(a), 0));
            map.put(b, 0);
            map.put(c, 0);
            map.put(d, 0);

        }
        return answer/2;
    }
}
