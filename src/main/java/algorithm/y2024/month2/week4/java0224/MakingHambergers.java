package algorithm.y2024.month2.week4.java0224;

import java.util.*;

//햄버거 만들기
class MakingHambergers {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<ingredient.length; i++){
            list.add(ingredient[i]);
        }

        int[] burger = new int[] {1, 2, 3, 1};
        int idx = 0;
        int answer = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == burger[idx]){
                idx++;
            }else if(list.get(i) == 1){
                idx=1;
            }else{
                idx=0;
            }
            if(idx == 4){
                answer++;
                idx = 0;
                for(int j=0; j<4; j++){
                    list.remove(i-3);
                }
                i = i-6;
                if(i<0)
                    i=-1;
            }
        }

        return answer;
    }
}