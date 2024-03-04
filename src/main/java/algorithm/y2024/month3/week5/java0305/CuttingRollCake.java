package algorithm.y2024.month3.week5.java0305;

import java.util.*;
//롤케이크 자르기
class CuttingRollCake {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> dpSet = new HashSet<>();
        int[] dp = new int[topping.length];

        for(int i=topping.length-1; i>0; i--){
            dpSet.add(topping[i]);
            dp[i] = dpSet.size();
        }

        for(int i=0; i<topping.length-1; i++){
            set.add(topping[i]);
            if(set.size() == dp[i+1])
                answer++;
        }
        return answer;
    }
}