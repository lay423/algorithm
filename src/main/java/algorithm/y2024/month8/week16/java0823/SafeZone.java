package algorithm.y2024.month8.week16.java0823;

class SafeZone {
    static int[][] area;
    static int[] dx;
    static int[] dy;
    static int n;
    public int solution(int[][] board) {
        int answer = 0;
        area = board.clone();
        dx = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
        dy = new int[] {1, 1, 1, 0, -1, -1, -1, 0};
        n = board.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    fillDangerZone(i, j);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(area[i][j] == 0)
                    answer++;
            }
        }
        return answer;
    }
    private void fillDangerZone(int a, int b){
        for(int i=0; i<dx.length; i++){
            int nx = a+dx[i];
            int ny = b+dy[i];

            if(0 > nx || nx >= n || 0> ny || ny >= n){
                continue;
            }
            if(area[nx][ny] == 1)
                continue;
            area[nx][ny] = 2;
        }
    }
}