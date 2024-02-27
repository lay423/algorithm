package algorithm.y2024.month2.week4.java0228;
class GcmAndLcm {
    public int[] solution(int n, int m) {
        int LCM;
        int GCM;

        int a = Math.max(n, m);
        int b = Math.min(n, m);


        //유클리드 호재법
        //a를 b로 나눈 나머지로 b를 나누어떨어질떄까지 반복하면 최대공약수가 나온다
        int r;
        while(b!=0){
            r = a % b;
            a = b;
            b = r;
        }
        GCM = a;

        //a 와 b의 곱을 최대공약수로 나누면 최소공배수가 나온다.
        LCM = (n * m) / GCM;

        return new int[] {GCM, LCM};
    }
}