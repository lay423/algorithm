package algorithm.month0.week9.java0704;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
  public int solution(int[][] maps) {
    int answer = 0;
    int[][] visited = new int[maps.length][maps[0].length];
    bfs(maps, visited);

    answer = visited[maps.length-1][maps[0].length-1];
    if(answer == 0 ){
      answer = -1;
    }
    return answer;
  }
  private void bfs(int[][] maps, int[][] visited){
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    visited[0][0] = 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    while(!queue.isEmpty()){
      int[] current = queue.remove();
      int cx = current[0];
      int cy = current[1];
      for(int i=0; i<dx.length; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if(nx < 0 || nx >= maps.length || ny <0 || ny >= maps[0].length)
          continue;

        if(visited[nx][ny] == 0 && maps[nx][ny] ==1){
          visited[nx][ny] = visited[cx][cy]+1;
          queue.add(new int[]{nx, ny});
        }
      }
    }
  }

}
