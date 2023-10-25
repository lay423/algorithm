package algorithm.month0.week2.java0515;

import java.util.Arrays;

public class SortByFileName {

  public static void main(String[] args) {
    SortByFileName solution = new SortByFileName();
    String[] answer = solution.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01000000.GIF",
        "img2.JPG"});
    for (int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }
  }

  public String[] solution(String[] files) {
    Arrays.sort(files, ((o1, o2) -> {
      String head1 = o1.split("[0-9]")[0].toLowerCase();
      String head2 = o2.split("[0-9]")[0].toLowerCase();
      if (head1.compareTo(head2) == 0) {
        String numTail1 = o1.substring(head1.length());
        String numTail2 = o2.substring(head2.length());
        return Integer.parseInt(calNumber(numTail1)) - Integer.parseInt(calNumber(numTail2));
      } else {
        return head1.compareTo(head2);
      }
    }));
    return files;
  }

  public static String calNumber(String numTail2) {
    StringBuilder sb2 = new StringBuilder();
    for (char c : numTail2.toCharArray()) {
      if (Character.isDigit(c) && sb2.length() <= 5) {
        sb2.append(c);
      } else {
        return sb2.toString();
      }
    }
    return sb2.toString();
  }
}
