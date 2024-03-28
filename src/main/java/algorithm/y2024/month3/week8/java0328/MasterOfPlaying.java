package algorithm.y2024.month3.week8.java0328;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//혼자 놀기의 달인
class MasterOfPlaying {
    static boolean[] visited;
    public int solution(int[] cards) {

        int answer = 0;
        visited = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<cards.length; i++){
            cards[i] = cards[i] - 1;
        }

        for(int i=0; i<cards.length; i++){
            int j = cards[i];
            int cnt=0;
            while(!visited[j]){
                cnt++;
                visited[j] = true;
                j = cards[j];
            }
            if(cnt != 0)
                list.add(cnt);
        }
        if(list.size() == 1)
            return 0;
        Collections.sort(list);
        return list.get(list.size()-1) * list.get(list.size()-2);
    }

}