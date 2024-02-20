package algorithm.y2024.month2.week3.java0220;

class NeighboringBlock {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, 0};

        for(int i=0; i<4; i++){
            int nx = dx[i] + h;
            int ny = dy[i] + w;
            if(0<= nx && nx <n && 0<= ny && ny < n){
                if(board[h][w].equals(board[nx][ny])){
                    answer++;
                }
            }
        }
        return answer;
    }
}