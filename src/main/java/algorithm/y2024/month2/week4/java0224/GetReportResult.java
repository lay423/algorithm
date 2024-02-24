package algorithm.y2024.month2.week4.java0224;

import java.util.*;

//신고 받기 결과
class GetReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> declare = new HashMap<>();
        int[] answer = new int[id_list.length];

        for(String id : id_list){
            map.put(id, new HashSet<>());
            declare.put(id, 0);
        }

        for(String detail : report){
            String[] split = detail.split(" ");
            Set<String> list = map.get(split[1]);
            list.add(split[0]);
            map.put(split[1], list);
        }

        for(Map.Entry<String, Set<String>> entry : map.entrySet()){
            Set<String> list = entry.getValue();
            if(list.size() >= k){
                for(String id : list){
                    declare.put(id, declare.get(id)+1);
                }
            }

        }

        for(int i=0; i<id_list.length; i++){
            answer[i] = declare.get(id_list[i]);
        }

        return answer;
    }

}
