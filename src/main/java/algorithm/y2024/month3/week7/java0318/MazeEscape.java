package algorithm.y2024.month3.week7.java0318;

import java.util.LinkedList;
import java.util.Queue;

//미로탈출
class MazeEscape {
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int m;
    static int n;
    static int toLabor;
    static int toEnd;
    public int solution(String[] maps) {
        toLabor = -1;
        toEnd = -1;
        int[] start = new int[2];
        int[] labor = new int[2];
        m = maps.length;
        n = maps[0].length();
        map = new char[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char c = maps[i].charAt(j);
                map[i][j] = c;
                if(c == 'S'){
                    start[0] = i;
                    start[1] = j;
                }else if(c == 'L'){
                    labor[0] = i;
                    labor[1] = j;
                }
            }
        }

        toLabor = bfs(start, 'L');
        if(toLabor == -1)
            return -1;

        toEnd = bfs(labor, 'E');
        if(toEnd == -1)
            return -1;
        return toLabor + toEnd;
    }
    private static int bfs(int[] start, char target){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        //x, y, cnt
        q.add(new int[] {start[0], start[1], 0});

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];
            visited[x][y] = true;

            if(map[x][y] == target){
                return cnt;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || nx >=m || ny<0 || ny >=n)
                    continue;
                if(!visited[nx][ny] && map[nx][ny] != 'X'){
                    q.add(new int[] {nx, ny, cnt+1});
                    visited[nx][ny] = true;
                }
            }

        }
        return -1;
    }
}