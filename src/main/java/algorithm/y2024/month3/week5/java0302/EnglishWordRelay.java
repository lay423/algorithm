package algorithm.y2024.month3.week5.java0302;

import java.util.*;

class EnglishWordRelay {
    public int[] solution(int n, String[] words) {
        int round=1;
        int userNum=1;
        char startChar = words[0].charAt(0);
        Set<String> set = new HashSet<>();

        for(String word : words){
            if(userNum > n){
                round++;
                userNum = 1;
            }
            if(startChar != word.charAt(0) || set.contains(word))
                return new int[] {userNum, round};

            set.add(word);
            startChar = word.charAt(word.length()-1);
            userNum++;
        }

        return new int[] {0, 0};
    }
}