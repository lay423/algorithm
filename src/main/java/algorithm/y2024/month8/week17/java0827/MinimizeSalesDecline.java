package algorithm.y2024.month8.week17.java0827;

import java.util.ArrayList;
import java.util.List;

public class MinimizeSalesDecline {
    static List<List<Integer>> list;
    static int[][] dp = new int[300001][2];

    public static void main(String[] args) {
        int a = solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17},
                new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}}
        );

        System.out.println(a);
    }

    public static int solution(int[] sales, int[][] links){
        list = new ArrayList<>();

        for(int i=0; i<sales.length+1; i++){
            list.add(new ArrayList<>());
        }

        for (int[] link : links) {
            int a = link[0];
            int b = link[1];
            list.get(a).add(b);
        }

        dfs(sales, 1);
        return Math.min(dp[1][0], dp[1][1]);
    }

    private static void dfs(int[] sales, int idx){
        dp[idx][0] = 0;
        dp[idx][1] = sales[idx-1];

        if(list.get(idx).isEmpty()) return;
        int extra = (int) 1e9;
        for(int child : list.get(idx)){
            dfs(sales, child);

            if(dp[child][0] < dp[child][1]){
                dp[idx][0] += dp[child][0];
                dp[idx][1] += dp[child][0];

                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            }else{
                dp[idx][0] += dp[child][1];
                dp[idx][1] += dp[child][1];

                extra = 0;
            }
        }

        dp[idx][0] += extra;
    }
}
