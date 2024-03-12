package algorithm.y2024.month3.week6.java0312;

import java.util.*;

//무인도 여행
class IslandTrip {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx;
    static int[] dy;
    static int n;
    static int m;
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        visited = new boolean[n][m];
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, -1, 0, 1};

        for(int i=0; i<n; i++){
            String str = maps[i];
            for(int j=0; j<m; j++){
                int num = 0;
                char c = str.charAt(j);
                if(c == 'X')
                    num = 0;
                else
                    num = c - '0';
                map[i][j] = num;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    int sum = dfs(i, j);
                    list.add(sum);
                }
            }
        }

        if(list.isEmpty())
            return new int[]{-1};
        Collections.sort(list);
        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    private static int dfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = 0;

        while(!q.isEmpty()){
            int[] idx = q.poll();
            int cx = idx[0];
            int cy = idx[1];
            sum += map[cx][cy];

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    int nx = dx[i] + cx;
                    int ny = dy[i] + cy;

                    if(0 > nx || nx >= n || 0 > ny || ny >= m)
                        continue;

                    if(map[nx][ny] != 0 && !visited[nx][ny]){
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

        }
        return sum;
    }
}