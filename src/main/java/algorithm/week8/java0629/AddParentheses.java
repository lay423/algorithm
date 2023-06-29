package algorithm.week8.java0629;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class AddParentheses {

  static int ans;
  static ArrayList<Character> ops;
  static ArrayList<Integer> nums;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    String form = br.readLine();

    ops = new ArrayList<>();
    nums = new ArrayList<>();

    for(int i=0; i<N; i++){
      char c = form.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        ops.add(c);
        continue;
      }
      nums.add(Character.getNumericValue(c));
    }

    ans = Integer.MIN_VALUE;
    DFS(nums.get(0), 0);

    bw.write(ans+"\n");
    bw.flush();
    bw.close();
    br.close();
  }

  public static int calc(char op, int n1, int n2) {
    switch (op) {
      case '+':
        return n1+n2;
      case '-':
        return n1 - n2;
      case '*':
        return n1 * n2;
    }
    return -1;
  }

  public static void DFS(int result, int opIdx) {
    if (opIdx >= ops.size()) {
      ans = Math.max(ans, result);
      return;
    }

    int res1 = calc(ops.get(opIdx), result, nums.get(opIdx + 1));
    DFS(res1, opIdx + 1);

    if (opIdx + 1 < ops.size()) {
      int res2 = calc(ops.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));

      DFS(calc(ops.get(opIdx), result, res2), opIdx + 2);
    }
  }


}
