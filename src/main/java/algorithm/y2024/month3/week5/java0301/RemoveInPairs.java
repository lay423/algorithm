package algorithm.y2024.month3.week5.java0301;

import java.util.Stack;

public class RemoveInPairs {
    public int solution(String s ){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
