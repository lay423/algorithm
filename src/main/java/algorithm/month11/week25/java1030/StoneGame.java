package algorithm.month11.week25.java1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoneGame {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    if (N % 2 == 0) {
      System.out.println("CY");
    } else {
      System.out.println("SK");
    }
  }
}
