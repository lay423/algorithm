package algorithm.week11.java0717;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateKey {

  List<String> candi = new ArrayList<>();

  public static void main(String[] args) {
    CandidateKey candidateKey = new CandidateKey();
    candidateKey.solution(new String[][]{
        {"100","ryan","music","2"},
        {"200","apeach","math","2"},
        {"300","tube","computer","3"},
        {"400","con","computer","4"},
        {"500","muzi","music","3"},
        {"600","apeach","music","2"}
    });
  }


  public int solution(String[][] relation) {
    int answer = 0;

    for (int i = 0; i < relation[0].length; i++) {
      boolean[] visited = new boolean[relation[0].length];
      dfs(visited, 0, 0, i + 1, relation);
    }
    answer = candi.size();
    return answer;
  }

  public void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
    if (depth == end) {
      List<Integer> list = new ArrayList<>();
      String key = "";

      for (int i = 0; i < visited.length; i++) {
        if (visited[i]) {
          key += String.valueOf(i);
          list.add(i);
        }
      }
      Map<String, Integer> map = new HashMap<>();

      for (int i = 0; i < relation.length; i++) {
        String s = "";
        for (Integer j : list) {
          s += relation[i][j];
        }

        if (map.containsKey(s)) {
          return;
        } else {
          map.put(s, 0);
        }
      }// for

      for (String s : candi) {
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
          String subS = String.valueOf(key.charAt(i));
          if (s.contains(subS)) {
            count++;
          }
        }
        if (count == s.length()) {
          return;
        }
      }

      candi.add(key);

      return;
    } //if(depth == end)

    for (int i = start; i < visited.length; i++) {
      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      dfs(visited, i, depth + 1, end, relation);
      visited[i] = false;
    }
  }

}
