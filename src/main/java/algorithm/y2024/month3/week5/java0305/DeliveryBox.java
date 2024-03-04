package algorithm.y2024.month3.week5.java0305;

import java.util.*;

//택배상자
class DeliveryBox {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx=0;
        for(int i=1; i<=order.length; i++){
            if(order[idx] == i){
                idx++;
            }else{
                stack.push(i);
            }
            while(!stack.isEmpty() && stack.peek() == order[idx]){
                idx++;
                stack.pop();
            }
        }
        return idx;
    }
}