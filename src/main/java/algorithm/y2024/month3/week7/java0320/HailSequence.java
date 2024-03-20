package algorithm.y2024.month3.week7.java0320;

import java.util.*;

//우박수열 정적분
class HailSequence {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();

        while(1 != k){
            list.add(k);
            if(k%2 == 0)
                k /= 2;
            else
                k = k*3 + 1;
        }
        list.add(1);
        int sum=0;
        for(int j=0; j<ranges.length; j++){
            sum=0;
            int start = ranges[j][0];
            int end = list.size()-1 + ranges[j][1];
            for(int i=start; i<end; i++){
                sum += list.get(i) + list.get(i+1);
            }
            answer[j] = sum / 2.0;
            if(end < start)
                answer[j] = -1;
        }
        return answer;
    }
}