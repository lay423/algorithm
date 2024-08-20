package algorithm.y2024.month8.week16.java0821;

import java.util.*;

class PrimeFactorization {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        for(int i=2; i<=n; i++){
            while(n%i == 0){
                set.add(i);
                n /= i;
            }
        }
        int[] answer = new int[set.size()];
        Iterator<Integer> inter = set.iterator();
        int i=0;
        while(inter.hasNext()){
            answer[i] = (int) inter.next();
            i++;
        }
        Arrays.sort(answer);
        return answer;
    }
}