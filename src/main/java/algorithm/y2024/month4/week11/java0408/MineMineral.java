package algorithm.y2024.month4.week11.java0408;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//광물 캐기
class MineMineral {
    static class Mineral{
        int dia;
        int iron;
        int stone;
        public Mineral(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = 0;
        List<Mineral> list = new ArrayList<>();
        int[][] score = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        for(int pick : picks)
            sum += pick;
        for(int i=0; i<minerals.length; i+=5){
            if(sum == 0)
                break;
            int dia=0;
            int iron=0;
            int stone=0;

            for(int j=i; j<i+5; j++){
                if(j == minerals.length)
                    break;
                int val = 2;
                if(minerals[j].equals("diamond")){
                    val = 0;
                }else if(minerals[j].equals("iron")){
                    val = 1;
                }

                dia += score[0][val];
                iron += score[1][val];
                stone += score[2][val];
            }
            list.add(new Mineral(dia, iron, stone));
            sum--;
        }
        Collections.sort(list, (o1, o2) -> o2.stone - o1.stone);

        for(Mineral obj : list){
            int dia = obj.dia;
            int iron = obj.iron;
            int stone = obj.stone;

            if(picks[0]>0){
                answer += dia;
                picks[0]--;
            }else if(picks[1]>0){
                answer += iron;
                picks[1]--;
            }else if(picks[2]>0){
                answer += stone;
                picks[2]--;
            }
        }

        return answer;
    }
}