package algorithm.y2024.month4.week11.java0409;

import java.util.*;

//등굣길

class WayToSchool {

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++)
            Arrays.fill(map[i], -1);

        for(int[] puddle : puddles)
            map[puddle[1]-1][puddle[0]-1] = 0;

        int val = 1;
        for(int i=1; i<n; i++){
            if(map[i][0] == 0)
                val = 0;
            map[i][0] = val;
        }
        val = 1;
        for(int i=0; i<m; i++){
            if(map[0][i] == 0)
                val = 0;
            map[0][i] = val;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(map[i][j] == 0)
                    continue;
                int MOD = 1000000007;
                map[i][j] = (map[i-1][j] + map[i][j-1]) % MOD;
            }
        }

        return map[n-1][m-1];
    }
}