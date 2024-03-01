package algorithm.y2024.month3.week5.java0302;

import java.util.*;

//연속 부분 수열 합의 개수
class ContinuousSubsequence {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<elements.length; i++){
            for(int j=0; j<elements.length; j++){
                int sum=0;
                sum += elements[j];
                for(int k=1; k<i; k++){
                    int idx = j+k;
                    if(idx >= elements.length)
                        idx -= elements.length;
                    sum += elements[idx];
                }
                set.add(sum);
            }
        }

        return set.size()+1;
    }
}