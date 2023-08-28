package algorithm.week17.java0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolvingProcess2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCnt = Integer.parseInt(br.readLine());

    for(int i=0; i<testCnt; i++){
      int fileCnt = Integer.parseInt(br.readLine());
      int min = Integer.MAX_VALUE;
      int[] files = new int[fileCnt];
      int[] dp = new int[fileCnt+1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < fileCnt; j++) {
        files[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(files);

//      for (int file : files) {
//        for(int j=0; j)
//      }


    }

  }
}
