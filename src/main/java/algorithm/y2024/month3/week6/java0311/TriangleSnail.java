package algorithm.y2024.month3.week6.java0311;

//삼각달팽이
class TriangleSnail {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3 == 0){
                    x++;
                }else if(i%3 == 1){
                    y++;
                }else if(i%3 == 2){
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }

        int k=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0)
                    break;
                answer[k++] = matrix[i][j];
            }
        }
        return answer;
    }
}