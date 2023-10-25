package algorithm.month0.week12.java0729;

import java.util.Collections;
import java.util.List;

public class TravelRoute {

  private static boolean[] visit;
  private static List<String> answer;
  public String[] solution(String[][] tickets) {
    String[] route;
    visit = new boolean[tickets.length];
    dfs("ICN", "ICN", tickets, 0);

    Collections.sort(answer);
    route = answer.get(0).split(" ");
    return route;
  }
  private static void dfs(String start, String route, String[][] tickets, int cnt) {
    if (cnt == tickets.length) {
      answer.add(route);
      return;
    }
    for (int i = 0; i < tickets.length; i++) {
      if (start.equals(tickets[i][0]) && !visit[i]) {
        visit[i] = true;
        dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
        visit[i] = false;
      }
    }
  }
}
