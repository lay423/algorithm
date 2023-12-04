package algorithm.month11.week25.java1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//수퍼 바이러스
public class SolvingProcess {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    BigInteger first = BigInteger.valueOf(Long.parseLong(st.nextToken()));
    BigInteger mod = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
    BigInteger time = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
    time = time.multiply(BigInteger.valueOf(10));

    BigInteger idx = BigInteger.valueOf(0);
    while (true) {
      idx = idx.add(BigInteger.ONE);
      first = first.multiply(mod);
      System.out.println(" idx: "+idx+" first: "+first);
      if (idx.equals(time)) {
        break;
      }
    }

    System.out.println(first.mod(BigInteger.valueOf(1000000007)));
  }

}
