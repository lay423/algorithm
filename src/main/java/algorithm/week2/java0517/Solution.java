package algorithm.week2.java0517;

import java.util.ArrayList;
import java.util.List;

//시간초과
class Solution {

  public int[] solution(String[] info, String[] query) {

    List<Developer> list = new ArrayList<>();
    List<Developer> query1 = new ArrayList<>();
    int[] answer = new int[query.length];
    for (int i = 0; i < info.length; i++) {
      list.add(new Developer(info[i].split(" ")[0], info[i].split(" ")[1], info[i].split(" ")[2],
          info[i].split(" ")[3], Integer.parseInt(info[i].split(" ")[4])));
    }

    for (int i = 0; i < query.length; i++) {
      query1.add(
          new Developer(query[i].split(" ")[0], query[i].split(" ")[2], query[i].split(" ")[4],
              query[i].split(" ")[6], Integer.parseInt(query[i].split(" ")[7])));
    }

    for (int i = 0; i < query.length; i++) {
      int cnt = 0;
      Developer tarDeveloper = query1.get(i);
      for (int j = 0; j < list.size(); j++) {
        Developer testDeveloper = list.get(j);
        if (testDeveloper.getLan().contentEquals(tarDeveloper.getLan()) || tarDeveloper.getLan()
            .contentEquals("-")) {
          if (testDeveloper.getGroup().contentEquals(tarDeveloper.getGroup()) || tarDeveloper.getGroup()
              .contentEquals("-")) {
            if (testDeveloper.getCareer().contentEquals(tarDeveloper.getCareer()) || tarDeveloper.getCareer()
                .contentEquals("-")) {
              if (testDeveloper.getFood().contentEquals(tarDeveloper.getFood()) || tarDeveloper.getFood()
                  .contentEquals("-")) {
                if (testDeveloper.getScore() >= tarDeveloper.getScore()) {
                  cnt++;
                }
              }
            }
          }
        }
      }
      System.out.println(cnt);
      answer[i] = cnt;
    }

    for (int i = 0; i < query.length; i++) {
      query1.get(i).print();
    }


    return answer;
  }

  public static void main(String[] args) {
    String[] info = {
        "java backend junior pizza 150", "python frontend senior chicken 210",
        "python frontend senior chicken 150", "cpp backend senior pizza 260",
        "java backend junior chicken 80", "python backend senior chicken 50"};
    String[] query = {
        "java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150", "- and - and - and chicken 100",
        "- and - and - and - 150"};

    Solution sol = new Solution();
    sol.solution(info, query);
  }
}

class Developer {

  String lan;
  String group;
  String career;
  String food;
  int score;

  public String getLan() {
    return lan;
  }

  public String getGroup() {
    return group;
  }

  public String getCareer() {
    return career;
  }

  public String getFood() {
    return food;
  }

  public int getScore() {
    return score;
  }

  public Developer(String lan, String group, String career, String food, int score) {
    this.lan = lan;
    this.group = group;
    this.career = career;
    this.food = food;
    this.score = score;
  }

  public void print() {
    System.out.printf("lan = %s, group=%s, career=%s, food=%s, score=%s", lan, group, career, food,
        score);
    System.out.println();
  }
}