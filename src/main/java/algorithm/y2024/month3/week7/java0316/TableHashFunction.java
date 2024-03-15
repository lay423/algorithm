package algorithm.y2024.month3.week7.java0316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//테이블 해시 함수
class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int tar = col - 1;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[tar]>o2[tar]){
                return 1;
            }else if(o1[tar]<o2[tar])
                return -1;
            else{
                if(o1[0] > o2[0]){
                    return -1;
                }else
                    return 1;
            }
        });
        List<Integer> list = new ArrayList<>();
        for(int i = row_begin-1; i<row_end; i++){
            int si=0;
            for(int j=0; j<data[0].length; j++){
                si += data[i][j] % (i+1);
            }
            list.add(si);
        }
        int answer=list.get(0);
        for(int i=1; i<list.size(); i++){
            answer = answer ^ list.get(i);
        }
        return answer;
    }
}
