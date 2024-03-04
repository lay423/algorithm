package algorithm.y2024.month3.week5.java0305;

import java.util.*;
//오픈 채팅방
class OpenChat {
    public String[] solution(String[] record) {
        List<String[]> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(String str : record){
            String[] arr = str.split(" ");
            if(arr[0].equals("Enter")){
                list.add(new String[] {arr[1], "님이 들어왔습니다."});
            }else if(arr[0].equals("Leave")){
                list.add(new String[] {arr[1], "님이 나갔습니다."});
                continue;
            }
            map.put(arr[1], arr[2]);
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            String[] str = list.get(i);
            answer[i] = map.get(str[0])+str[1];
        }
        return answer;
    }
}