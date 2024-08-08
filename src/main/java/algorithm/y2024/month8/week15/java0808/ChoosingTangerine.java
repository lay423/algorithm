package algorithm.y2024.month8.week15.java0808;

import java.util.*;

class ChoosingTangerine {
    public static void main(String[] args) {
        ChoosingTangerine s = new ChoosingTangerine();
        s.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int tan : tangerine){
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            sum += val;
            answer++;
            if(k <= sum)
                break;
        }

        return answer;
    }
}
