package algorithm.month0.week13.java0804;

import java.util.*;

class BigNumber {
  public String solution(String number, int k) {
    char[] result = new char[number.length() - k];
    Stack<Character> stack = new Stack<>();

    for (int i=0; i<number.length(); i++) {
      char c = number.charAt(i);
      while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
        stack.pop();
      }
      stack.push(c);
    }
    for (int i=0; i<result.length; i++) {
      result[i] = stack.get(i);
    }
    return new String(result);
  }
}
