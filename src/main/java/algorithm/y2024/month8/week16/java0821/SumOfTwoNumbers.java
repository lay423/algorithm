package algorithm.y2024.month8.week16.java0821;

import java.math.BigInteger;

class SumOfTwoNumbers {
    public static void main(String[] args) {
        SumOfTwoNumbers s = new SumOfTwoNumbers();
        String solution = s.solution("18446744073709551615", "287346502836570928366");
        System.out.println(solution);
    }
    public String solution(String a, String b) {

        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);

        BigInteger result = num1.add(num2);

        return result.toString();
    }
}