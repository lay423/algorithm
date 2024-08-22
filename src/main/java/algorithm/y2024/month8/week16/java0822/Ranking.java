import java.util.*;

class Ranking {

    public int[] solution(int[][] score) {
        double[] rank = new double[score.length];
        for(int i=0; i<score.length; i++){
            rank[i] = (score[i][0] + score[i][1])/2.0;
        }
        double[] score_clone = rank.clone();
        int[] answer = new int[score.length];
        Arrays.sort(rank);
        int num = 1;
        for(int i=rank.length-1; i>=0; i--){
            int cnt=0;
            if(i != 0 && rank[i] == rank[i-1])
                continue;
            for(int j=0; j<score_clone.length; j++){
                if(rank[i] == score_clone[j]){
                    answer[j] = num;
                    cnt++;
                }
            }
            num += cnt;
        }
        return answer;
    }
}