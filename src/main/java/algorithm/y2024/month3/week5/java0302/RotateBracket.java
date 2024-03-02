package algorithm.y2024.month3.week5.java0302;

import java.util.*;

//괄호 회전하기
class RotateBracket {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack;
        int n = s.length();

        for(int i=0; i<n; i++){
            stack = new Stack<>();
            for(int j=0; j<n; j++){
                int idx = (i+j) % n;
                if(!stack.isEmpty() && isMatched(stack.peek(), s.charAt(idx)))
                    stack.pop();
                else
                    stack.push(s.charAt(idx));
            }
            if(stack.isEmpty())
                answer++;

        }
        return answer;
    }
    private static boolean isMatched(char a, char b){
        if(a == '[' && b == ']')
            return true;
        else if(a == '{' && b == '}')
            return true;
        else if(a == '(' && b == ')')
            return true;
        else
            return false;
    }
}