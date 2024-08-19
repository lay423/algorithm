package algorithm.y2024.month8.week16.java0819;

import java.util.*;

class Sorting {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();

        char[] chArr = my_string.toCharArray();
        Arrays.sort(chArr);

        return new String(chArr);
    }
}