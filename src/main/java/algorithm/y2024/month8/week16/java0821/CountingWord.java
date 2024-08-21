package algorithm.y2024.month8.week16.java0821;

import java.util.Arrays;

class CountingWord {
    public static void main(String[] args) {
        CountingWord s = new CountingWord();
        int[] solution = s.solution("ABCDEFZGabcdefg");
        System.out.println(Arrays.toString(solution));

    }
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c < 'a')
                answer[c-'A']++;
            else
                answer[c-'A'-6]++;
        }
        return answer;
    }
}