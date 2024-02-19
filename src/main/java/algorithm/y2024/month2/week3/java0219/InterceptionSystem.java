package algorithm.y2024.month2.week3.java0219;

import java.util.*;

public class InterceptionSystem {
    public int solution(int[][] targets){
        int answer = 0;

        Arrays.sort(targets, ((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        int end = targets[0][1];
        answer++;

        for(int[] tar : targets){
            if(tar[0] >= end){
                end = tar[1];
                answer++;
            }
        }


        return answer;
    }
}
