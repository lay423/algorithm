package algorithm.y2024.month8.week16.java0820;

import java.util.*;

class CutAndSortString {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        String[] arr = myString.split("x");
        for(String s : arr){
            if(!s.isEmpty())
                list.add(s);
        }

        String[] answer = new String[list.size()];
        list.toArray(answer);
        Arrays.sort(answer);

        return answer;
    }
}