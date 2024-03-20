package algorithm.y2024.month3.week7.java0320;

//점찍기
class Dot {
    public long solution(int k, int d) {
        long answer = 0;
        long distance = (long)d*d;
        for(long i=0; i*k<=d; i++){
            long y = (i*k);
            long y2 = (long)y * y;
            long x = distance - y2;
            x = (long)Math.sqrt(x);
            answer += x/k + 1;
        }
        return answer;
    }
}
