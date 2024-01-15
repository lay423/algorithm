package algorithm.month10.week23.java1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Node {

  int idx;
  int cost;

  Node(int idx, int cost) {
    this.idx = idx;
    this.cost = cost;
  }
}

public class DijkstraRouting {

  static int N = 7;   //NodeCnt
  static ArrayList<ArrayList<Node>> graph;

  //idx:0 - 출발노드//idx:1 - 도착노드// idx:2 - 비용
  static int[][] sampleGraph = {{1, 2, 2}, {1, 4, 3}, {2, 3, 5},
      {2, 5, 4}, {3, 6, 4}, {3, 7, 3},
      {4, 5, 5}, {5, 6, 2}, {6, 7, 1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br
        = new BufferedReader(new InputStreamReader(System.in));

    int start = 0;
    //A~G이외의 값이 입력되면 루프를 돕니다.
    while (start < 1 || start > N) {
      System.out.print
          ("출력할 라우팅 테이블의 시작노드를 입력하세요(A~G)>>");
      char c = br.readLine().charAt(0);
      start = (int) c - 64;
    }

    graph = new ArrayList<>();
    for (int i = 0; i < N + 1; i++) {
      graph.add(new ArrayList<>());
    }

    setGraphWithSample();
    int[] dist = dijkstra(start);

    System.out.println((char) (start + 64) + " routing table");
    for (int i = 1; i < N + 1; i++) {
      System.out.println((char) (i + 64) + " " + dist[i]);
    }
  }

  /*
   * 배열 sampleGraph의 값을 graph에 넣는 기능을 합니다.
   * */
  private static void setGraphWithSample() {
    for (int i = 0; i < sampleGraph.length; i++) {
      int nodeA = sampleGraph[i][0];
      int nodeB = sampleGraph[i][1];
      int cost = sampleGraph[i][2];
      graph.get(nodeA).add(new Node(nodeB, cost));
      graph.get(nodeB).add(new Node(nodeA, cost));
    }
  }

  /*
   * 다익스트라 알고리즘을 이용하여 라우팅 테이블을 반환합니다.
   * */
  private static int[] dijkstra(int start) {
    boolean[] visited = new boolean[N + 1];
    int[] answer = new int[N + 1];

    Arrays.fill(answer, Integer.MAX_VALUE);
    answer[start] = 0;

    for (int i = 0; i < N; i++) {
      int value = Integer.MAX_VALUE;
      int nodeIdx = 0;

      for (int j = 1; j < N + 1; j++) {
        if (!visited[j] && answer[j] < value) {
          value = answer[j];
          nodeIdx = j;
        }
      }

      visited[nodeIdx] = true;

      for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
        Node adjNode = graph.get(nodeIdx).get(j);

        answer[adjNode.idx]
            = Math.min(answer[adjNode.idx],
            answer[nodeIdx] + adjNode.cost);
      }
    }
    return answer;
  }
}
