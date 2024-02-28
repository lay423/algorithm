package algorithm.y2024.month2.week4.java0228;
import java.util.*;

//카카오프렌즈 컬러링북
class ColoringBook {
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int M;
    static int N;
    static int numArea;
    static int MAX;

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        M = m;
        N = n;
        numArea = 0;
        MAX = Integer.MIN_VALUE;
        dx  = new int[] {-1, 0, 1, 0};
        dy  = new int[] {0, -1, 0, 1};


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0)
                    dfs(i, j, picture[i][j], picture);

            }
        }

        return new int[] {numArea, MAX};
    }

    private static void dfs(int x, int y, int color, int[][] picture){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        numArea++;
        int size = 0;
        while(!q.isEmpty()){
            size++;
            int[] next = q.poll();
            visited[next[0]][next[1]] = true;
            for(int i=0; i<4; i++){
                int nx = next[0] + dx[i];
                int ny = next[1] + dy[i];

                if(nx <0 || nx >= M || ny <0 || ny >= N)
                    continue;
                if(picture[nx][ny] == color && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }
        MAX = Math.max(MAX, size);
    }
}