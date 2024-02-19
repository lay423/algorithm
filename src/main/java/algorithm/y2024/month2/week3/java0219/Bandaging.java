package algorithm.y2024.month2.week3.java0219;

class Bandaging {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int idx=0;
        int round=0;
        int plusHealCnt=0;
        int maxHealth = health;
        int n = attacks.length;
        while(idx<n){
            //몬스터 공격시 넘기기
            if(round == attacks[idx][0]){
                health -= attacks[idx][1];
                plusHealCnt=0;
                if(health<=0){
                    return -1;
                }
                idx++;
            }else{
                //몬스터 공격 없을시
                //연속성공찼을시 추가회복, 연속성공 0으로 초기화
                plusHealCnt++;
                if(plusHealCnt == bandage[0]){
                    health += bandage[2];
                    plusHealCnt = 0;
                }
                //체력회복
                health += bandage[1];
                //최대체력을 넘겼을시 초기화
                if(health>maxHealth){
                    health = maxHealth;
                }
            }
            round++;
        }//while

        return health;
    }
}
