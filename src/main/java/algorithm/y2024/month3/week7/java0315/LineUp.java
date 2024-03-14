package algorithm.y2024.month3.week7.java0315;

import java.util.*;

//줄서는 방법
class LineUp {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long f = 1;
        for(int i=1; i<=n; i++){
            list.add(i);
            f *= i;
        }

        k--;
        int idx = 0;
        while(idx < n){
            f /= n - idx;
            answer[idx++] = list.remove((int) (k / f));
            k %= f;
        }
        return answer;
    }
}