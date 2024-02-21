package algorithm.y2024.month2.week3.java0222;

import java.util.ArrayList;
import java.util.List;

class SmallSubstring {
    public int solution(String t, String p) {
        List<Long> list = new ArrayList<>();
        int n = p.length();
        int answer = 0;

        for(int i=0; i<=t.length()-n; i++){
            list.add(Long.parseLong(t.substring(i, i+n)));
        }


        for(Long num : list){
            if(num<= Long.parseLong(p)){
                answer++;
            }

        }

        return answer;
    }
}