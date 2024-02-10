package algorithm.y2024.month2.week2.java0210;

import java.util.*;

//2024 KAKAO WINTER INTERNSHIP 도넛과 막대 그래프
class DonutAndBarGraph {

    public static void main(String[] args) {
        DonutAndBarGraph s = new DonutAndBarGraph();
//        int[][] edges = new int[][] {{2, 3},{4, 3},{1, 1},{2, 1}};
//        int[][] edges = new int[][] {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},
//                {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
//        int[][] edges = new int[][] {{2, 1}, {2, 5}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 3}, {3, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 3}};
        int[][] edges = new int[][] {{2, 1}, {1, 3}, {2, 4}, {4, 5}, {2, 6}, {6, 7}};
        System.out.println(Arrays.toString(s.solution(edges)));
    }
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] isVisited;
    int Max=0;
    int donutCnt=0;//도넛
    int stickCnt=0;//막대
    int eightCnt=0;//8자
    int createdVertex=0;

    public int[] solution(int[][] edges) {
        for (int[] edge : edges) {
            graph.put(edge[0], getListByEdge(edge));
            Max = Math.max(edge[0], Max);
            Max = Math.max(edge[1], Max);
        }
        isVisited = new boolean[Max+1];

        //생성된 점 찾기 - 자신으로 향하는 간선이 없고 자신에서 나가는 간선이 2개 이상
        List<Integer> findedVertices = findVertexByMap();

        //자신에서 나가는 간선이 2개이상인지 확인
        for(int vertex : findedVertices){
            if(graph.containsKey(vertex)){
                if(graph.get(vertex).size()>=2)
                    createdVertex = vertex;
            }

        }

        //제거
        isVisited[createdVertex] = true;
        graph.remove(createdVertex);

        //그래프 탐색
        searchGraphs();

        return new int[]{createdVertex, donutCnt, stickCnt, eightCnt};
    }

    private void searchGraphs(){
        //막대 그래프 탐색
        List<Integer> foundVertices = findVertexByMap();
        stickCnt = foundVertices.size();
        for(int vertex : foundVertices){
            isVisited[vertex] = true;
            while(graph.containsKey(vertex)){
                vertex = graph.get(vertex).get(0);
                isVisited[vertex] = true;
            }
        }

        //8자 그래프 탐색
        for(int i=1; i<=Max; i++){
            if(isVisited[i])
                continue;
            if(graph.get(i).size() ==2){
                eightCnt++;
                List<Integer> vertices = graph.get(i);
                for(Integer vertex : vertices){
                    while(!isVisited[vertex]){
                        isVisited[vertex] = true;
                        vertex = graph.get(vertex).get(0);
                    }
                }
            }
        }

        //도넛 그래프 탐색
        for(int i=1; i<=Max; i++){
            if(isVisited[i])
                continue;
            donutCnt++;
            int vertex = graph.get(i).get(0);
            while(!isVisited[vertex]){
                isVisited[vertex] = true;
                vertex = graph.get(vertex).get(0);
            }
        }
    }

    //find_vertex_by_map
    //map에서 자신으로 향하는 간선이 없는 정점 반환
    private List<Integer> findVertexByMap(){
        List<Integer> targetVertices = new ArrayList<>();

        boolean[] isTargetVertex = new boolean[Max+1];
        Arrays.fill(isTargetVertex, true);

        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            for (int vertex : entry.getValue()) {
                isTargetVertex[vertex] = false;
            }
        }
        isTargetVertex[createdVertex] = false;
        for(int vertex=1; vertex<=Max; vertex++){
            if(isTargetVertex[vertex]){
                targetVertices.add(vertex);
            }
        }

        return targetVertices;
    }

    //get_list_by_edge
    //간선으로 list에 정점 추가하여 반환/ 없으면 새로 초기화
    private List<Integer> getListByEdge(int[] edge){
        List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
        list.add(edge[1]);
        return list;
    }
}
