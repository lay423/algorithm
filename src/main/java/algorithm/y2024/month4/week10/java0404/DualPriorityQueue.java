package algorithm.y2024.month4.week10.java0404;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//이중 우선순위 큐
class DualPriorityQueue {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for(String oper : operations){
            String[] split = oper.split(" ");
            if(split[0].equals("I")){
                int num = Integer.parseInt(split[1]);
                list.add(num);
                Collections.sort(list);
                continue;
            }
            if(list.isEmpty())
                continue;
            if(split[1].charAt(0) == '-'){
                list.remove(0);
            }else{
                list.remove(list.size()-1);
            }
        }
        if(list.isEmpty())
            return new int[]{0, 0};

        return new int[]{list.get(list.size()-1), list.get(0)};
    }
}