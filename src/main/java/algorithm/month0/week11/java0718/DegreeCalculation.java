package algorithm.month0.week11.java0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DegreeCalculation {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean visited[];

  static int N;

  static int two;

  static int soluton = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i <= N ; i++) {
      graph.add(new ArrayList<>());
    }
    st = new StringTokenizer(br.readLine());
    visited = new boolean[N+1];

    int first = Integer.parseInt(st.nextToken());
    two = Integer.parseInt(st.nextToken());

    int roop = Integer.parseInt(br.readLine());

    for (int i = 0; i < roop ; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    int count = 0;
    dfs(first,count);

    System.out.println(soluton != 0 ? soluton : -1);
  }


  static void dfs(int index,int count){

    visited[index] = true;
    for (int temp : graph.get(index)){
      if(!visited[temp]){
        if(two == temp){
          soluton = count+1;
          return;
        }

        dfs(temp,count+1);
      }
    }
  }
}
