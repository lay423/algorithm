package algorithm.month0.week15.java0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PWCreation {

  static int pwLength, letterCnt;
  static char[] letters;
  static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
  static boolean[] visit;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    pwLength = Integer.parseInt(st.nextToken());
    letterCnt = Integer.parseInt(st.nextToken());
    letters = new char[letterCnt];
    visit = new boolean[letterCnt];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < letterCnt; i++) {
      letters[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(letters);

    dfs("", 0);
    System.out.println(sb.toString());
  }

  private static void dfs(String str, int idx) {
    if (pwLength == str.length() && isPW(str)) {
        sb.append(str).append("\n");
        return;
    }

    for (int i = idx; i < letters.length; i++) {
      if (visit[i]) {
        continue;
      }
      visit[i] = true;
      dfs(str + letters[i], i + 1);
      visit[i] = false;
    }
  }

  private static boolean isPW(String str) {
    int vowelCnt = 0;
    for (char c : str.toCharArray()) {
      for (char vowel : vowels) {
        if (c == vowel){
          vowelCnt++;
          break;
        }
      }
    }

    if (vowelCnt > 0 && (pwLength - vowelCnt) >= 2) {
      return true;
    }
    return false;
  }

}
