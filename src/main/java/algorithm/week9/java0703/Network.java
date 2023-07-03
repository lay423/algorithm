package algorithm.week9.java0703;

public class Network {
  static boolean[] visited;
  public int solution(int n, int[][] computers) {
    int answer = 0;
    visited = new boolean[n];
    for(int i=0; i<computers.length; i++){
      if(!visited[i]){
        dfs(computers, i);
        answer++;
      }

    }
    return answer;
  }
  private static void dfs(int[][] computers, int depth){
    visited[depth] = true;

    for(int j=0; j<computers.length; j++){
      if(depth!=j && computers[depth][j] == 1 && visited[j]==false)
        dfs(computers, j);
    }
  }
}
