package algorithm.month0.week6.java0612;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalInformation {

  static Map<String, Integer> map = new HashMap<>();

  public List<Integer> solution(String today, String[] terms, String[] privacies) {
    for (String term : terms) {
      String[] temp = term.split(" ");
      map.put(temp[0], Integer.valueOf(temp[1]));
    }

    List<Integer> answer = new ArrayList<>();

    int idx = 1;
    for (int i = 0; i < privacies.length; i++) {
      String[] temp = privacies[i].split(" ");
      if (!isValid(today, temp[0], temp[1])) {
        answer.add(i + 1);
      }
    }
    return answer;
  }

  private boolean isValid(String today, String prevDate, String type) {
    String[] arr1 = today.split("[.]");
    int todayInDays = Integer.parseInt(arr1[2]) +
            (Integer.parseInt(arr1[1]) * 28) +
            (Integer.parseInt(arr1[0]) * 28 * 12);

    String[] arr2 = prevDate.split("[.]");
    int prevDateInDays = Integer.parseInt(arr2[2]) +
        (Integer.parseInt(arr2[1]) * 28) +
        (Integer.parseInt(arr2[0]) * 28 * 12);
    return todayInDays - prevDateInDays < map.get(type) * 28;
  }
}
