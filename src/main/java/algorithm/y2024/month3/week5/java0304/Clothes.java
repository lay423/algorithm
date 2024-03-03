package algorithm.y2024.month3.week5.java0304;

import java.util.*;

//의상
class Clothes {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String[] str : clothes){
            map.put(str[1], map.getOrDefault(str[1], 0)+1);
        }

        int sum = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            sum *= entry.getValue()+1;
        }
        answer += sum-1;
        return answer;
    }
}