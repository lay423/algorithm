package algorithm.y2024.month2.week3.java0221;

import java.util.*;

class RoughlyMadeKeyBoard {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Arrays.fill(answer, 0);
        Map<Character, Integer> map = new HashMap<>();

        for(String key : keymap){
            for(int i=0; i<key.length(); i++){
                map.put((char)key.charAt(i),
                        Math.min(map.getOrDefault(key.charAt(i), Integer.MAX_VALUE), i+1));
            }
        }

        for(int j=0; j<targets.length; j++){
            for(int i=0; i<targets[j].length(); i++){
                if(!map.containsKey(targets[j].charAt(i))){
                    answer[j] = -1;
                    break;
                }
                answer[j] += map.get(targets[j].charAt(i));
            }
        }

        return answer;
    }
}