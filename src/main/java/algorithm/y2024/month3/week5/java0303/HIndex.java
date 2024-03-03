package algorithm.y2024.month3.week5.java0303;

import java.util.*;

//H-index
class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int num = citations.length - i;
            if(citations[i] >= num)
                return num;
        }
        return answer;
    }
}