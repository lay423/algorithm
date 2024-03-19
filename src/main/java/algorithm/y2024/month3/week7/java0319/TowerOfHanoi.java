package algorithm.y2024.month3.week7.java0319;


import java.util.*;

//하노이의 탑
class TowerOfHanoi {
    private static List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        move(n, 1, 2, 3);
        int[][] answer = list.stream().toArray(int[][]::new);

        return answer;
    }
    private static void move(int cnt, int start, int mid, int end){
        if(cnt == 0)
            return;
        move(cnt-1, start, end, mid);
        list.add(new int[]{start, end});
        move(cnt-1, mid, start, end);
    }

}