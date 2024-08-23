package algorithm.y2024.month8.week16.java0823;

class DeterminingNums {
    public int solution(int a, int b) {
        int answer = 0;
        int gcd = GCD(a, b);
        b /= gcd;
        for(int i=2; i<=b; i++){
            while(b%i == 0){
                if(i != 2 && i != 5)
                    return 2;
                b /= i;
            }
        }
        return 1;
    }
    public int GCD(int n1, int n2){
        if(n1 % n2 == 0)
            return n2;
        return GCD(n2, n1%n2);
    }
}