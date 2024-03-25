package algorithm.y2024.month3.week8.java0325;

//혼자서 하는 틱택토
class TicTacToeAlone {
    static char[][] map;
    static boolean[][] visited;
    public int solution(String[] board) {
        map = new char[3][3];
        visited = new boolean[3][3];
        int oCnt=0;
        int xCnt=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                char c = board[i].charAt(j);
                map[i][j] = c;
                if(c == 'O')
                    oCnt++;
                else if(c == 'X')
                    xCnt++;

            }
        }

        if(!((oCnt - xCnt) == 1 || oCnt == xCnt))
            return 0;
        if(win('O')){
            if(oCnt == xCnt)
                return 0;
        }
        if(win('X')){
            if((oCnt - xCnt) == 1)
                return 0;
        }

        return 1;
    }
    private static boolean win(char c){
        for(int i=0; i<3; i++){
            if(map[i][0] == c &&
                    map[i][1] == c &&
                    map[i][2] == c)
                return true;
        }
        for(int i=0; i<3; i++){
            if(map[0][i] == c &&
                    map[1][i] == c &&
                    map[2][i] == c)
                return true;
        }
        if(map[0][0] == c &&
                map[1][1] == c &&
                map[2][2] == c)
            return true;
        if(map[0][2] == c &&
                map[1][1] == c &&
                map[2][0] == c)
            return true;
        return false;
    }
}