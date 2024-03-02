package algorithm.y2024.month3.week5.java0302;

import java.util.*;

//할인 행사
class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }

        for(int i=0; i<10; i++){
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i])-1);
            }
        }

        if(checkCondition(map))
            answer++;

        for(int i=0; i<discount.length-10; i++){
            if(map.containsKey(discount[i]))
                map.put(discount[i], map.get(discount[i])+1);
            if(map.containsKey(discount[i+10])){
                map.put(discount[i+10], map.get(discount[i+10])-1);
            }
            if(checkCondition(map))
                answer++;
        }
        return answer;
    }
    private static boolean checkCondition(Map<String, Integer> map){
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()>0)
                return false;
        }
        return true;
    }
}