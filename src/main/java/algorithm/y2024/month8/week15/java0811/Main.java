package algorithm.y2024.month8.week15.java0811;

class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int)(right-left+1)];
        long lIdx1 = left/n;
        long lIdx2 = left%n;
        long idx=0;

        while(true){
            answer[(int)idx] = Math.max(lIdx1, lIdx2)+1;
            idx++;
            if(idx == answer.length)
                break;
            lIdx2++;
            if(lIdx2==n){
                lIdx1++;
                lIdx2=0;
            }

        }


        return answer;
    }
}
