package algorithm.y2024.month8.week16.java0822;

import java.util.*;

class RandomlyDrawKNumbers {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(list.size() == k) break;
            if(!list.contains(arr[i])) list.add(arr[i]);
        }

        while(list.size() < k)
            list.add(-1);

        return list.stream().mapToInt(x->x).toArray();
    }
}
