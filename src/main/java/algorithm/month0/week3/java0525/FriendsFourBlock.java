package algorithm.month0.week3.java0525;

import java.util.LinkedList;
import java.util.Queue;

class FriendsFourBlock {

  static char[][] boardChar;
  static boolean v[][];
  static boolean isErasePossible = true;

  public static void main(String[] args){
    FriendsFourBlock solution = new FriendsFourBlock();
    int solution1 = solution.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    System.out.println(solution1);
  }

  public int solution(int m, int n, String[] board) {
    int answer = 0;
    boardChar = new char[m][n];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length(); j++) {
        boardChar[i][j] = board[i].charAt(j);
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length(); j++) {
        System.out.print(boardChar[i][j]);
      }
      System.out.println();
    }

    while (isErasePossible) {
      isErasePossible = false;
      v = new boolean[m][n];

      for (int i = 0; i < boardChar.length - 1; i++) {
        for (int j = 0; j < boardChar[i].length - 1; j++) {
          if (boardChar[i][j] == '#') continue;
          char device = boardChar[i][j];
          if (check(i, j, boardChar)) {
            isErasePossible = true;
            v[i][j] = true;
            v[i][j+1] = true;
            v[i+1][j] = true;
            v[i+1][j+1] = true;
          }
        }
      }

      answer += erase(m, n, boardChar);
      v = new boolean[m][n];
    }

    return answer;
  }

  private static boolean check(int x, int y, char[][] board){
    char ch = board[x][y];
    if(ch == board[x][y+1] && ch== board[x+1][y] && ch == board[x+1][y+1]){
      return true;
    }
    return false;
  }

  public static int erase(int m, int n, char[][] board){
    int cnt = 0;
    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(v[i][j])
          board[i][j] = '.';
      }
    }

    /* 큐를 이용해 세로로 제거 작업 진행 */
    for(int i=0; i<n; i++){
      Queue<Character> q = new LinkedList<>();
      for(int j=m-1; j>=0; j--){
        if(board[j][i] == '.'){
          cnt++;  // 지우는 블록 카운트
        }else{
          q.add(board[j][i]);
        }
      }
      int idx=m-1;
      // 삭제한 블록 위의 블록들 내리기
      while(!q.isEmpty()){
        board[idx--][i] = q.poll();
      }
      // 빈칸 채우기
      for(int j=idx; j>=0; j--){
        board[j][i] = '#';
      }
    }

    return cnt;
  }

}
