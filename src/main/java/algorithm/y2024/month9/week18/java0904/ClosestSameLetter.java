package algorithm.y2024.month9.week18.java0904;

import java.util.*;

class ClosestSameLetter {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] locations = new int['z'+1];
        Arrays.fill(locations, -1);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(locations[c] == -1)
                answer[i] = -1;
            else
                answer[i] = i - locations[c];

            locations[c] = i;
        }
        return answer;
    }
}