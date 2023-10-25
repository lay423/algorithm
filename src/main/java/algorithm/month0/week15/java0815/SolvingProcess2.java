package algorithm.month0.week15.java0815;

import java.io.*;
import java.util.*;

//리모컨
public class SolvingProcess2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String target = br.readLine();
    int brokeCnt = Integer.parseInt(br.readLine());
    int MIN = Math.abs(Integer.parseInt(target) - 100);

    boolean[] brokeArr = new boolean[10];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < brokeCnt; i++) {
      brokeArr[Integer.parseInt(st.nextToken())] = true;
    }

    String possibleNum = "";
    for (int i = 0; i < target.length(); i++) {
      int targetNum = (int) target.charAt(i) - 48;
      possibleNum += getPossibleNum(targetNum, brokeArr);
    }
    if (possibleNum.contains("*")) {
      System.out.println(MIN);
    } else {
      int possibleNumInteger = Integer.parseInt(possibleNum);

      System.out.println("possibleNum="+possibleNumInteger);
      System.out.println(Math.min(MIN, possibleNumInteger - Integer.parseInt(target)+target.length()));
    }
  }

  private static String getPossibleNum(int targetNum, boolean[] brokeArr) {
    if(!brokeArr[targetNum])
      return String.valueOf(targetNum);
    for (int i = 1; i < 10; i++) {
      int[] num = new int[]{targetNum - 1, targetNum + 1};
      for (int j = 0; j < 2; j++) {
        if (num[j] >= 0 && num[j] < 10 && !brokeArr[num[j]]) {
          return String.valueOf(num[j]);
        }
      }
    }
    return "*";
  }


}
