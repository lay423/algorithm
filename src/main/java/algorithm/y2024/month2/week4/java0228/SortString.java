package algorithm.y2024.month2.week4.java0228;

import java.util.*;

//문자열 내 마음대로 정렬하기
class SortString {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if(o1.charAt(n) > o2.charAt(n)) {
                return 50;
            }else if(o1.charAt(n) < o2.charAt(n)){
                return -50;
            }else if(o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            }
            return 0;
        });
        return strings;
    }
}
