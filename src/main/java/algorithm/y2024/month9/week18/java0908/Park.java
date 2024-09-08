package algorithm.y2024.month9.week18.java0908;

import java.util.*;

class Park {
    public int solution(int[] mats, String[][] park) {
        int N = park.length;
        int M = park[0].length;

        int MAX = 0;
        Arrays.sort(mats);
        int[][] dp = new int[N][M];

        for(int i=0; i<N; i++){
            if(park[i][0].equals("-1")){
                dp[i][0] = 1;
                MAX = 1;
            }

        }
        for(int i=0; i<M; i++){
            if(park[0][i].equals("-1")){
                dp[0][i] = 1;
                MAX = 1;
            }

        }

        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                if(!park[i][j].equals("-1"))
                    continue;
                int now = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                MAX = Math.max(MAX, now);
                dp[i][j] = now;
            }
        }
        for(int i=mats.length-1; i>=0; i--){
            if(mats[i] <= MAX)
                return mats[i];
        }

        return -1;
    }
}