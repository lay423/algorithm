package algorithm.y2024.month3.week7.java0319;

import java.util.*;

//리코쳇 로봇
class RicochetRobot {
    static int m;
    static int n;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static char[][] map;

    public int solution(String[] board) {
        int answer = 0;
        int[] start = new int[]{0,0};
        m = board.length;
        n = board[0].length();
        map = new char[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char c = board[i].charAt(j);
                map[i][j] = c;
                if(c == 'R')
                    start = new int[] {i, j};
            }
        }

        answer = bfs(start);

        return answer;
    }
    private static int bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] idx = q.poll();
            int x = idx[0];
            int y = idx[1];
            int cnt = idx[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //벽에 닿으면 종료(다음번이 외곽or 다음번이 D)
                while((nx>=0 && nx<m && ny>=0 && ny<n)){
                    if(map[nx][ny] == 'D')
                        break;
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if(map[nx][ny] == 'G')
                    return cnt+1;
                if(!visited[nx][ny]){
                    q.add(new int[]{nx, ny, cnt+1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}