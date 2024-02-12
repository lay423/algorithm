package algorithm.y2024.month2.week2.java0212;

import java.util.*;

//2024 KAKAO WINTER INTERNSHIP 도넛과 막대 그래프
//다시풀기:3
class DonutAndBarGraph {
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] isVisited;

    int Max = 0;
    int createdVertex = 0;
    int donutCnt = 0;
    int barCnt = 0;
    int eightCnt = 0;

    public int[] solution(int[][] edges) {
        //Map에 간선값 넣기
        for(int[] edge : edges){
            map.put(edge[0], getListWithEdge(edge));
            Max = Math.max(edge[0], Max);
            Max = Math.max(edge[1], Max);
        }
        isVisited = new boolean[Max+1];

        //생성된 점 찾기
        //자신을 향하는 간선이 없고(생성된 점, 막대그래프 시작점)
        //자신에게서 나가는 간선이 2개 이상
        List<Integer> foundVertices = findTargetVertices();
        for(int vertex : foundVertices){
            if(map.get(vertex).size()>=2){
                createdVertex = vertex;
                break;
            }
        }
        //제거
        isVisited[createdVertex] = true;
        map.remove(createdVertex);

        searchBar();
        search();

        return new int[] {createdVertex, donutCnt, barCnt, eightCnt};
    }

    private void search(){
        //8자 그래프 탐색
        //중심 정점(자신에서 나가는 간선이 2개)
        for(int i=1; i<=Max; i++){
            if(isVisited[i]){
                continue;
            }
            if(map.get(i).size() == 2){
                eightCnt++;
                isVisited[i] = true;
                for(int vertex : map.get(i)){
                    while(!isVisited[vertex]){
                        isVisited[vertex] = true;
                        vertex = map.get(vertex).get(0);
                    }
                }
            }
        }

        //도넛 그래프 탐색
        for(int i=1; i<=Max; i++){
            if(isVisited[i])
                continue;
            donutCnt++;
            int vertex = i;
            while(!isVisited[vertex]){
                isVisited[vertex] = true;
                vertex = map.get(vertex).get(0);
            }
        }


    }


    //막대 그래프 탐색
    private void searchBar() {
        List<Integer> foundVertices = findTargetVertices();
        barCnt = foundVertices.size();
        for(int vertex : foundVertices){
            isVisited[vertex] = true;
            while(map.containsKey(vertex)){
                vertex = map.get(vertex).get(0);
                isVisited[vertex] = true;
            }
        }
    }


    //자신을 향하는 간선이 없고(생성된 점, 막대그래프 시작점)
    //자신에게서 나가는 간선이 2개 이상
    private List<Integer> findTargetVertices(){
        List<Integer> list = new ArrayList<>();
        boolean[] isTarget = new boolean[Max+1];
        Arrays.fill(isTarget, true);
        isTarget[createdVertex] = false;

        //check
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            //자신으로 향하는 간선이 있으면 제외
            for(int vertex : entry.getValue()){
                isTarget[vertex] = false;
            }
        }

        for(int i=1; i<=Max; i++){
            if(isTarget[i])
                list.add(i);
        }

        return list;
    }

    //List가 없는 경우 vertex 추가해서 반환
    private List<Integer> getListWithEdge(int[] edge){
        List<Integer> list = new ArrayList<>();
        list = map.getOrDefault(edge[0], list);
        list.add(edge[1]);
        return list;
    }
}