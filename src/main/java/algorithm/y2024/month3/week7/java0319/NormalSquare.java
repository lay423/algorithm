package algorithm.y2024.month3.week7.java0319;

//멀쩡한 사각형
class NormalSquare {
    public long solution(int w, int h) {
        long ref = gcd(w, h);

        return (long)w*h - (w/ref + h/ref -1)*ref;
    }
    private static int gcd(int n, int m){
        while(m!=0){
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}