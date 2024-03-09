package algorithm.y2024.month3.week6.java0309;

import java.util.LinkedList;
import java.util.Queue;

//두 큐 합 같게 만들기
class SumOfTwoQueues {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1=0;
        long sum2=0;
        int answer = 0;
        for(int num : queue1){
            q1.add(num);
            sum1 += num;
        }
        for(int num : queue2){
            q2.add(num);
            sum2 += num;
        }
        while(sum1 != sum2){
            if(answer > (queue1.length + queue2.length) *2){
                return -1;
            }
            int val = 0;
            if(sum1 > sum2){
                val = q1.poll();
                q2.add(val);
                sum1 -= val;
                sum2 += val;
            }else{
                val = q2.poll();
                q1.add(val);
                sum1 += val;
                sum2 -= val;
            }
            answer++;
        }
        return answer;
    }
}