package algorithm.y2024.month9.week18.java0903;

import java.util.*;

class SortCharacter {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        arr = convertCase(arr);
        Arrays.sort(arr);
        arr = convertCase(arr);
        return String.valueOf(arr);
    }

    private static char[] convertCase(char[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='a')
                arr[i] = Character.toUpperCase(arr[i]);
            else
                arr[i] = Character.toLowerCase(arr[i]);
        }
        return arr;
    }
}