package algorithm.week3.java0522;

class GetDecimalNum {

  public int solution(int n, int k) {
    int answer = 0;
    String s;
    if (k != 10) {
      s = Integer.toString(n, k);
    } else {
      s = String.valueOf(n);
    }
    String[] str = s.split("0");

    for (int i = 0; i < str.length; i++) {
      if (str[i].equals("")) {
        str[i] = "1";
      }
    }

    for (int i = 0; i < str.length; i++) {
      long num = Long.parseLong(str[i]);
      if (isPrime(num)) {
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {

  }

  public static boolean isPrime(long n) {
    boolean isPrime = true;
    if (n == 1) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        isPrime = false;
        break;
      }
    }

    return isPrime;
  }
}
