package algorithm.y2024.month2.week4.java0224;

//콜라 문제
class ColaProblem {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            int temp = n/a;
            answer += temp*b;
            n = temp*b + n%a;
        }
        return answer;
    }
}
