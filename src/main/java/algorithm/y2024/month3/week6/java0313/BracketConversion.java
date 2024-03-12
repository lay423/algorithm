package algorithm.y2024.month3.week6.java0313;

import java.util.*;

//괄호 변환
class BracketConversion {
    public String solution(String p) {
        return convert(p);
    }
    private static String convert(String s){
        if(s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        int lCnt=0, rCnt=0;
        int idx=s.length();
        boolean isCorrect = false;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') {
                lCnt++;
                stack.add(c);
            }
            else{
                rCnt++;
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.add(c);
            }
            if(lCnt == rCnt){
                idx = i;
                if(stack.isEmpty())
                    //올바른 괄호 문자열
                    isCorrect = true;
                break;
            }
        }
        if(isCorrect){
            return s.substring(0, idx+1) + convert(s.substring(idx+1));
        }

        String s1 = s.substring(0, idx+1);
        StringBuilder sb = new StringBuilder();
        s1 = s1.substring(1);
        s1 = s1.substring(0, s1.length()-1);
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if(c == '(')
                sb.append(")");
            else
                sb.append("(");
        }

        return "("+convert(s.substring(idx+1))+")"+ sb;
    }
}

