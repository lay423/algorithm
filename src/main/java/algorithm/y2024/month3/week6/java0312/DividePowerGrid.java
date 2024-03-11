package algorithm.y2024.month3.week6.java0312;

import java.util.*;

//전력망 둘로 나누기
class DividePowerGrid {
    static List<Integer>[] list;
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            list[v1].add(v2);
            list[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            boolean[] visited = new boolean[n + 1];

            list[v1].remove(Integer.valueOf(v2));
            list[v2].remove(Integer.valueOf(v1));

            int cnt = dfs(1, visited);

            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            list[v1].add(v2);
            list[v2].add(v1);
        }
        return min;
    }
    private static int dfs(int v, boolean[] visited){
        visited[v] = true;
        int cnt = 1;

        for(int next : list[v]){
            if(!visited[next]){
                cnt += dfs(next, visited);
            }
        }


        return cnt;
    }
}