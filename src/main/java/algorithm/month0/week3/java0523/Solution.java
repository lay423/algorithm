package algorithm.month0.week3.java0523;

import java.util.HashSet;

class Solution {

  public int[] solution(String[] gems) {
    int[] answer = {};
    HashSet<String> set = new HashSet<String>();

    for (int i = 0; i < gems.length; i++) {
      set.add(gems[i]);
    }
    int size = set.size();

    int r = gems.length;
    answer = new int[]{1, r};

    int min = gems.length;
    for (int i = 0; i < gems.length - size; i++) {
      HashSet<String> set1 = new HashSet<String>();
      System.out.println("i:"+i);

      for (int j = i; j < gems.length; j++) {
        set1.add(gems[j]);
        if (set1.size() == size) {
          int mount = j - i + 1;
          if (min > mount) {
            min = mount;
            int r1 = i + 1;
            int r2 = j + 1;
            answer = new int[]{r1, r2};
          }
          System.out.println("break");
          break;
        }
        if (min == size) {
          break;
        }
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] gems = new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
    int[] solution1 = solution.solution(gems);
    System.out.println(solution1.toString());
  }
}
