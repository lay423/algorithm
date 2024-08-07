package algorithm.y2024.month8.week15.java0807;

import java.util.Arrays;

public class CreateMin {
    public static void main(String[] args) {

        //1, 4, 2  5, 4, 4
    }

    public int solution(int[] A, int[] B) {
        int sum = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<A.length; i++){
            sum += A[i] * B[B.length-i-1];
        }

        return sum;
    }
}
