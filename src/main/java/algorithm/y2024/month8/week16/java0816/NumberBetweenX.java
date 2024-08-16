package algorithm.y2024.month8.week16.java0816;

import java.util.*;

class NumberBetweenX {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        String[] arr = myString.split("x", -1);
        for(String s : arr){
            list.add(s.length());
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}