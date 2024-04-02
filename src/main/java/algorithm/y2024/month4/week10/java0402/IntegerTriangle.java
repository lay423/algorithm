package algorithm.y2024.month4.week10.java0402;

//정수 삼각형
class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                int i1 = j-1;
                int i2 = j;
                int val1 = 0, val2 = 0;
                if(0<= i1)
                    val1 = triangle[i-1][i1];
                if(i2 < triangle[i-1].length)
                    val2 = triangle[i-1][i2];
                triangle[i][j] += Math.max(val1, val2);
                if(i == triangle.length-1)
                    answer = Math.max(triangle[i][j], answer);
            }
        }
        return answer;
    }
}