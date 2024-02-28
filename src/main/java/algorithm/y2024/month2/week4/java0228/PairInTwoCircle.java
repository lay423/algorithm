package algorithm.y2024.month2.week4.java0228;

//두 원 사이의 정수 쌍
class PairInTwoCircle {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1x = (long) Math.pow(r1, 2);
        long r2x = (long) Math.pow(r2, 2);

        int side = 0;
        for(int i=0; i<=r2; i++)        {
            long y1 = (long) Math.sqrt(r1x - Math.pow(i, 2));

            long y2 = (long) Math.sqrt(r2x - Math.pow(i, 2));

            answer += (y2 - y1)*4;
            if(Math.sqrt(r1x - Math.pow(i, 2))%1 == 0)
                side++;
        }
        answer += side* 4L -4;

        return answer;
    }
}
