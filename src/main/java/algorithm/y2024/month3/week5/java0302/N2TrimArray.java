package algorithm.y2024.month3.week5.java0302;

//n^2 배열 자르기
class N2TrimArray {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int)(right-left+1)];
        long lIdx1 = left/n;
        long lIdx2 = left%n;
        long idx=0;

        while(true){
            answer[(int)idx] = (long)Math.max(lIdx1, lIdx2)+1;
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