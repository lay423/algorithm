package algorithm.y2024.month7.week15.java0701;

import java.io.*;
import java.util.*;

//소프티어
public class TrenDelFinDelMundo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int x = 0;
        int MIN = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            String[] arr = s.split(" ");
            int num1 = Integer.parseInt(arr[0]);
            int num2 = Integer.parseInt(arr[1]);
            if(num2 < MIN){
                x = num1;
                MIN = num2;
            }
        }
        System.out.println(x + " " + MIN);
    }
}
