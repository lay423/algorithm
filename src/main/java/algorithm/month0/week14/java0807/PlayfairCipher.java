package algorithm.month0.week14.java0807;

import java.util.*;
import java.io.*;

public class PlayfairCipher {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String pri = br.readLine();
    char[][] arr = new char[5][5];
    List<Character> alphabet = new ArrayList<>();

    // 알파벳 리스트 만들기
    for (int i = 0; i < 26; i++) {
      if ((char) 'A' + i == 'J') {
        continue;
      }
      alphabet.add((char) ('A' + i));
    }
    int r = 0;
    int c = 0;

    // 배열에 넣기
    for (int i = 0; i < pri.length(); i++) {
      if (alphabet.contains(pri.charAt(i))) {
        arr[r][c] = pri.charAt(i);
        alphabet.remove(Character.valueOf(arr[r][c]));
        c++;
        if (c == 5) {
          c = 0;
          r++;
        }
      }
    }

    // 나머지 알파벳 넣기
    for (int i = 0; i < alphabet.size(); i++) {
      arr[r][c] = alphabet.get(i);
      c++;
      if (c == 5) {
        c = 0;
        r++;
      }
    }

    // 배열 출력해보기
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

    // 두 글자씩 이루어진 쌍 파괴하기
    StringBuilder sb = new StringBuilder();
    sb.append(str);
    int idx = 0;
    while (idx < sb.length() - 1) {
      if (sb.charAt(idx) == sb.charAt(idx + 1)) {
        // XXX가 될 경우
        if (sb.charAt(idx) == 'X') {
          sb.insert(idx + 1, 'Q');
        } else {
          sb.insert(idx + 1, 'X');
        }
      }
      idx += 2;
    }

    // 만든 String이 홀수 길이일 경우 맨 뒤에 X 추가
    if (sb.length() % 2 == 1) {
      sb.append('X');
    }
//		System.out.println(sb);

    idx = 0;
    while (idx < sb.length() - 1) {
      char c1 = sb.charAt(idx);
      char c2 = sb.charAt(idx + 1);
      int cx = 0, cy = 0, c2x = 0, c2y = 0;

      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (c1 == arr[i][j]) {
            cx = i;
            cy = j;
          }
          if (c2 == arr[i][j]) {
            c2x = i;
            c2y = j;
          }
        }
      }
      // 같은 행에 존재할 경우
      if (cx == c2x) {
        if (cy + 1 >= 5)
          cy = -1;
        if (c2y + 1 >= 5)
          c2y = -1;
        sb.setCharAt(idx, arr[cx][cy + 1]);
        sb.setCharAt(idx + 1, arr[c2x][c2y + 1]);
        idx += 2;
        continue;
      }

      // 같은 열에 존재할 경우
      if (cy == c2y) {
        if (cx + 1 >= 5)
          cx = -1;
        if (c2x + 1 >= 5)
          c2x = -1;
        sb.setCharAt(idx, arr[cx + 1][cy]);
        sb.setCharAt(idx + 1, arr[c2x + 1][cy]);
        idx += 2;
        continue;
      }

      // 서로 다른 행,열에 존재하면 열을 서로 교환한다.
      sb.setCharAt(idx, arr[cx][c2y]);
      sb.setCharAt(idx + 1, arr[c2x][cy]);
      idx += 2;
    }
    System.out.println(sb);
  }
}
