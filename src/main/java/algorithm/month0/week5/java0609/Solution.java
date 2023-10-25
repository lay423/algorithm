package algorithm.month0.week5.java0609;

import java.util.*;

class Solution {
  List<String> candi = new ArrayList<>(); // 후보 키를 저장하는 리스트

  public int solution(String[][] relation) {
    int answer = 0; // 후보 키의 개수를 저장하는 변수

    for (int i = 0; i < relation[0].length; i++) { // 서로 다른 길이의 후보 키를 찾기 위한 반복문
      boolean[] visited = new boolean[relation[0].length]; // 방문한 열을 추적하는 배열
      dfs(visited, 0, 0, i + 1, relation); // 깊이 우선 탐색 수행
    }

    answer = candi.size(); // 후보 키 개수로 answer를 업데이트
    return answer; // answer 반환
  }

  public void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
    if (depth == end) { // 목표 깊이에 도달한 경우
      List<Integer> list = new ArrayList<>(); // 방문한 열의 인덱스를 저장하는 리스트
      String key = ""; // 방문한 열에서 생성된 키를 저장하는 문자열

      for (int i = 0; i < visited.length; i++) {
        if (visited[i]) {
          key += String.valueOf(i); // 인덱스를 키 문자열에 추가
          list.add(i); // 인덱스를 리스트에 추가
        }
      }

      Map<String, Integer> map = new HashMap<>(); // 생성된 키의 고유성을 확인하기 위한 맵

      for (int i = 0; i < relation.length; i++) { // 각 행에 대해 반복
        String s = "";
        for (Integer j : list) {
          s += relation[i][j]; // 방문한 열의 값을 연결하여 고유한 문자열 생성
        }

        if (map.containsKey(s)) {
          return; // 문자열이 맵에 이미 존재하는 경우, 고유하지 않으므로 탐색 중단
        } else {
          map.put(s, 0); // 문자열을 맵에 추가
        }

      }

      // 생성된 키가 기존 후보 키의 부분집합인지 확인
      for (String s : candi) {
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
          String subS = String.valueOf(key.charAt(i));
          if (s.contains(subS)) count++;
        }
        if (count == s.length()) return; // 키가 부분집합인 경우, 후보 키로 추가하지 않고 탐색 중단
      }

      candi.add(key); // 키를 candi에 추가 (유효한 후보 키)
      return;
    }

    // 열의 가능한 조합을 재귀적으로 탐색
    for (int i = start; i < visited.length; i++) {
      if (visited[i]) continue; // 열이 이미 방문한 경우, 다음 열로 건너뛰기

      visited[i] = true; // 열을 방문한 것으로 표시
      dfs(visited, i, depth + 1, end, relation); // 깊이와 시작 인덱스를 업데이트하여 재귀 호출
      visited[i] = false; // 백트래킹을 위해 방문 플래그 초기화
    }
  }
}