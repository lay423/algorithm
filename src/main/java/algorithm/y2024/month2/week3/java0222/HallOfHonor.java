package algorithm.y2024.month2.week3.java0222;
import java.util.*;

class HallOfHonor {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> hall = new ArrayList<>();

        for(int i=0; i<score.length; i++){
            if(i<k)
                hall.add(score[i]);
            else
                hall.set(0, Math.max(hall.get(0), score[i]));
            Collections.sort(hall);
            answer[i] = hall.get(0);
        }

        return answer;
    }
}