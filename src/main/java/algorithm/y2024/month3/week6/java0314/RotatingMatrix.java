package algorithm.y2024.month3.week6.java0314;

import java.util.Arrays;

//행렬 테두리 회전하기
class RotatingMatrix {
    public static void main(String[] args) {
        RotatingMatrix s = new RotatingMatrix();
        System.out.println(Arrays.toString(s.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int[][] map = new int[rows+1][columns+1];
        int num=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = ++num;
            }
        }
        for(int i=0; i<n; i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int tmp = map[x1][y1];
            int min = tmp;
            for(int j=x1; j<x2; j++){
                map[j][y1] = map[j+1][y1];
                min = Math.min(min, map[j+1][y1]);
            }

            for(int j=y1; j<y2; j++){
                map[x2][j] = map[x2][j+1];
                min = Math.min(min, map[x2][j+1]);

            }

            for(int j=x2; j>x1; j--){
                map[j][y2] = map[j-1][y2];
                min = Math.min(min, map[j-1][y2]);
            }
            for(int j=y2; j>y1; j--){
                map[x1][j] = map[x1][j-1];
                min = Math.min(min, map[x1][j-1]);
            }
            map[x1][y1+1] = tmp;
            answer[i] = min;
        }
        return answer;
    }
}