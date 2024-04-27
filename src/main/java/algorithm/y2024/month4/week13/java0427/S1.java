package algorithm.y2024.month4.week13.java0427;

import java.util.*;

class S1 {
    public int solution(int[] levels) {
        Arrays.sort(levels);
        int n = levels.length;
        int idx = n / 4;
        if(n < 2)
            return levels[n-1];
        if(n == 3)
            return -1;

        return levels[n - idx];
    }
}
