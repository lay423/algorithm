package algorithm.y2024.month8.week17.java0830;

import java.util.*;

class SortNumber {
    public static void main(String[] args) {
        SortNumber s = new SortNumber();
        long solution = s.solution(118372);
        System.out.println(solution);

    }
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String s = ""+n;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }
        return Long.parseLong(sb.toString());
    }
}
