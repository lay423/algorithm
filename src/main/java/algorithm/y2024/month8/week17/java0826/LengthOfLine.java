package algorithm.y2024.month8.week17.java0826;

class LengthOfLine {
    public int solution(int[][] lines) {
        int answer = 0;

        int[] cnt = new int[201];

        for(int[] i : lines){
            int start = i[0] + 100;
            int end = i[1] + 100;

            for(int k=start; k<end; k++){
                cnt[k]++;
            }
        }

        for(int i : cnt){
            if(i>1) answer++;
        }
        return answer;
    }
}