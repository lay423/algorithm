package algorithm.month11.week29.java1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BJ2812 크게 만들기
 */
public class MakeItBigger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int numOfDigit = Integer.parseInt(st.nextToken());
        int numOfErased = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        Stack stack = new Stack(numOfDigit);
        int count = 0;
        for (int i = 0; i < numOfDigit; i++) {
            int num = input.charAt(i) - '0';

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && count < numOfErased) {
                    if (stack.peek() < num) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
            }

            stack.push(num);

            if (count == numOfErased) {
                sb.append(input.substring(i+1));
                break;
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (count < numOfErased) {
                count++;
                continue;
            }
            sb.insert(0, num);
        }

        System.out.println(sb);

        br.close();
    }
    public static class Stack {
        int[] arr;
        int idx;

        public Stack(int size) {
            this.arr = new int[size];
        }

        public void push(int num) {
            arr[idx++] = num;
        }

        public boolean isEmpty() {
            return idx == 0;
        }

        public int peek() {
            return arr[idx -1];
        }

        public int pop() {
            return arr[--idx];
        }
    }
}
