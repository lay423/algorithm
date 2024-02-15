package algorithm.y2024.month2.week2.java0215;

import java.util.*;


//2024 KAKAO WINTER INTERNSHIP
//n+1 카드게임
class NPlusOneCardGame {
    static int n;
    static int coinCnt;
    static Set<Integer> origin;
    static Set<Integer> keep;


    public static void main(String[] args) {
        NPlusOneCardGame s = new NPlusOneCardGame();
        s.solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4});
    }
    public int solution(int coin, int[] cards) {
        n = cards.length;
        int target = n+1;
        int round = 0;
        int index=n/3;

        coinCnt = coin;

        int keepCnt = n/3*2;
        keep = new HashSet<>();
        origin = new HashSet<>();

        //처음 카드 뽑기
        for(int i=0; i<index; i++){
            origin.add(cards[i]);
        }

        while(true){
            round++;

            if(index==n){
                break;
            }

            //카드 두개를 기억해놓기
            for(int i=0; i<2; i++){
                keep.add(cards[index+i]);
            }

            //합이 n+1인 카드 두장 내기
            boolean flag = false;
            for(int i : origin){
                if(origin.contains(target-i)){
                    origin.remove(i);
                    origin.remove(target-i);
                    flag = true;
                    break;
                }
            }

            //없다면 기억한 카드와 조합해서 n+1을 만들수 있는지 체크
            if(!flag) {
                if(coin>0){
                    for(int i : origin){
                        if(keep.contains(target-i)){
                            keep.remove(target-i);
                            origin.remove(i);
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }

            //동전 두개 쓰기
            if(!flag){
                if(coin>1){
                    for(int i : keep){
                        if(keep.contains(target - i)){
                            keep.remove(target - i);
                            keep.remove(i);
                            coin-=2;
                            flag=true;
                            break;
                        }
                    }
                }
            }

            if(!flag)
                break;


            //카드 뭉치가 0이어도 break (index == cards.length)
            index+=2;
        }


        return round;
    }

}
