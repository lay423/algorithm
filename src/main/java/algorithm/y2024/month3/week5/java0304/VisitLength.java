package algorithm.y2024.month3.week5.java0304;

import java.util.*;

//방문 길이
class VisitLength {

    public int solution(String dirs) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        Set<String> set = new HashSet<>();
        int answer = 0;
        int y = 0;
        int x = 0;
        for(int i=0; i<dirs.length(); i++){
            int idx = getIdx(dirs.charAt(i));
            int ny = y+dy[idx];
            int nx = x+dx[idx];
            if(nx<-5 || nx >5 || ny <-5 || ny >5)
                continue;
            set.add(idxToString(new int[][] {{x, y}, {nx, ny}}));

            y = ny;
            x = nx;
        }
        return set.size();
    }
    private static String idxToString(int[][] nums){
        StringBuilder sb = new StringBuilder();

        Arrays.sort(nums, (o1, o2) -> {
            if(o1[0] < o2[0])
                return 50;
            else if (o1[0] > o2[0]) {
                return -50;
            }else {
                if(o1[1] < o2[1])
                    return 50;
                else if (o1[1] > o2[1]) {
                    return -50;
                }
            }
            return 0;
        });



        for(int[] num : nums){
            for(int n : num){
                if(n<0)
                    sb.append("-").append(n);
                else
                    sb.append(n);
            }
        }
        return sb.toString();
    }
    private static int getIdx(char c){
        int idx=3;
        if(c == 'U')
            idx=0;
        else if(c == 'D')
            idx = 1;
        else if(c == 'R')
            idx = 2;
        return idx;
    }
}