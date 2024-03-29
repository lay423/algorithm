package algorithm.month11.week27.java1118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SuperVirus
{
  // k * p^10n
  public static void main(String args[]) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long k = Long.parseLong(st.nextToken());
    long p = Long.parseLong(st.nextToken());
    long n = Long.parseLong(st.nextToken());

    n *= 10;

    long result = recursion(p, n);

    System.out.println(k * result % 1000000007);
  }

  static long recursion(long p, long n) {
    if (n == 1)
      return p;

    long cur = recursion(p, n/2);
    if (n % 2 == 1) {
      return (cur * cur % 1000000007) * p % 1000000007;
    }
    else {
      return cur * cur % 1000000007;
    }
  }
}
