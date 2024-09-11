package algorithm.y2024.month9.week18.java0911;

class TemplarsWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int now = getDivisorNum(i);
            if(now > limit)
                now = power;
            answer += now;
        }
        return answer;
    }

    private static int getDivisorNum(int num){
        int cnt = 0;
        for(int i=1; i*i<=num; i++){
            if(i*i == num) cnt++;
            else if(num % i == 0){
                cnt += 2;
            }
        }
        return cnt;
    }
}