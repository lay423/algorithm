package algorithm.month9.week19.java0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolvingProcess {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int page = Integer.parseInt(st.nextToken());
    int processCnt = Integer.parseInt(st.nextToken());
    int cacheSize = Integer.parseInt(st.nextToken());

    int[] pages = new int[page+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= page; i++) {
      pages[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < processCnt; i++) {
      st = new StringTokenizer(br.readLine());
      String process = st.nextToken();
      if (process.equals("B")) {        //뒤로가기

      } else if (process.equals("F")) { //앞으로가기

      } else if (process.equals("A")) { //접속하기
        int pageNum = Integer.parseInt(st.nextToken());

      } else if (process.equals("C")) { //압축하기

      }
    }
  }

}
