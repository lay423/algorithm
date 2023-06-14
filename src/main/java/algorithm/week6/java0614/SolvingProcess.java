package algorithm.week6.java0614;

import java.util.*;

//test case 1, 2번 오류
class SolvingProcess {

  public static void main(String[] args) {
    SolvingProcess solution = new SolvingProcess();
    List<String> solution1 = solution.solution(
        new String[][]{{"ICN", "A"}, {"A", "B"},{"A", "C"},{"C", "A"},{"B", "D"}});

   for (String s : solution1) {
      System.out.print(s+", ");
    }
    //return ["ICN", "A", "C", "A", "B", "D"] but ICN, A, B, D, a, a
  }
  Map<Integer, Integer> visited = new HashMap<>();
  List<String> list = new ArrayList<>();
  String visit = "ICN";

  public List<String> solution(String[][] tickets) {
    String[] answer = {};
    for(int i=0; i<tickets.length; i++){
      visited.put(i, i);
    }
    list.add("ICN");
    for(int i=0; i<tickets.length; i++){
      bfs(tickets);
    }
    return list;
  }
  private void bfs(String[][] tickets){
    int idx=0;
    String next="a";
    for(Map.Entry<Integer, Integer> entry : visited.entrySet()){
      int i = entry.getValue();
      if(tickets[i][0].equals(visit)){
        if(tickets[i][1].charAt(0)<next.charAt(0)){
          idx = i;
          next = tickets[i][1];
        }
      }
    }
    visit = next;
    list.add(next);
    visited.remove(idx);
  }
}