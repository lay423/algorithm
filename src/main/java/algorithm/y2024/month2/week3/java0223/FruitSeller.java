package algorithm.y2024.month2.week3.java0223;
import java.util.*;

class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(score);
        for(int i=score.length-1; i>=m-1; i-=m){
            answer += score[i-(m-1)] * m;
        }

        return answer;
    }
}