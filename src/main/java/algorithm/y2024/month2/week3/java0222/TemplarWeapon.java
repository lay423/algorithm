package algorithm.y2024.month2.week3.java0222;
class TemplarWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=2; i<=number; i++){
            int count = 0;
            for(int j=1; j*j<=i; j++){
                if (j * j == i) count++;
                else if (i % j == 0) count += 2;
            }

            if(count>limit){
                answer += power;
            }else
                answer += count;
        }

        return answer+1;
    }

}