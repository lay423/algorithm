package algorithm.y2024.month3.week5.java0302;

import java.util.*;

class ChoosingTangerines {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list);

        for(int i=list.size()-1; i>=0; i--){
            k -= list.get(i);
            answer++;
            if(k<=0)
                break;
        }

        return answer;
    }
}