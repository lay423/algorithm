package algorithm.y2024.month3.week5.java0305;

import java.util.*;

//주식 가격
class StockPrice {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
}