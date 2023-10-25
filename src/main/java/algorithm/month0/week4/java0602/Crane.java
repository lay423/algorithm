package algorithm.month0.week4.java0602;

import java.util.Stack;

public class Crane {

  public static void main(String[] args) {
    Crane crane = new Crane();
    int[][] borad = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    int[] moves = {1,5,3,5,1,2,1,4};
    crane.solution(borad, moves);
  }
  public int solution(int[][] board, int[] moves) {
    Stack<Integer> st = new Stack<>();
    int answer = 0;
    for(int i=0; i<moves.length; i++){
      int j=moves[i]-1;
      for(int k=0; k<board.length; k++){
        if(board[k][j]!=0)
        {
          if(!st.empty() && st.peek() == board[k][j]){
            st.pop();
            answer++;
          }else{
            st.push(board[k][j]);
          }
          board[k][j] = 0;
          break;
        }
      }

    }

    return answer*2;
  }
}
