package algorithm.y2024.month3.week6.java0308;

import java.util.LinkedList;
import java.util.Queue;

//다리를 지나는 트럭
class TruckPassingBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;
        for(int truck : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }else if(q.size() == bridge_length){
                    sum -= q.poll();
                }else{
                    if(sum + truck <= weight){
                        q.add(truck);
                        sum+= truck;
                        time++;
                        break;
                    }else{
                        q.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}
