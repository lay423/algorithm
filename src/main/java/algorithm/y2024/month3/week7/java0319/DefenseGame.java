package algorithm.y2024.month3.week7.java0319;

import java.util.*;

//디펜스 게임
class DefenseGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);

            if(n <0){
                if(k>0 && !pq.isEmpty()){
                    n += pq.poll();
                    k--;
                }else{
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}