package algorithm.y2024.month3.week5.java0304;

import java.util.*;
//전화번호 목록
class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : phone_book){
            map.put(str, 0);
        }

        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        return true;
    }
}