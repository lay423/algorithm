package algorithm.y2024.month2.week4.java0227;
import java.util.*;

class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int num : lost){
            list1.add(num);
        }
        for(int num : reserve){
            list2.add(num);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for(int i=0; i<list1.size(); i++){
            int num = list1.get(i);
            if(list2.contains(num)){
                list1.remove(i);
                list2.remove(list2.indexOf(num));
                i--;
            }
        }
        for(int i=0; i<list1.size(); i++){
            int num = list1.get(i);
            if(list2.contains(num-1)){
                list1.remove(i);
                list2.remove(list2.indexOf(num-1));
                i--;
            }else if(list2.contains(num+1)){
                list1.remove(i);
                list2.remove(list2.indexOf(num+1));
                i--;
            }
        }

        return n - list1.size();
    }
}