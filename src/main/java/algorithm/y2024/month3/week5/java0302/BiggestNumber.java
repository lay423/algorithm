package algorithm.y2024.month3.week5.java0302;
import java.util.*;

class BiggestNumber {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();

        if(str[0].equals("0"))
            return "0";

        for(int i=0; i<str.length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}