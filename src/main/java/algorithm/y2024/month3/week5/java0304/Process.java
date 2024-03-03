package algorithm.y2024.month3.week5.java0304;

import java.util.*;

class Process {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities){
            pq.offer(i);
        }
        int answer = 0;
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    if(location == i)
                        return answer;
                }
            }
        }
        return answer;
    }
}