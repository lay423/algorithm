package algorithm.y2024.month2.week4.java0227;

import java.util.*;

//2018 KAKAO BLIND RECRUITMENT
// [1차] 다트게임
class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int top=-1;
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(c == '1' && dartResult.charAt(i+1)=='0'){
                list.add(10);
                top++;
                i++;
            }else if('0'<=c && c<='9'){
                list.add(c-'0');
                top++;
            }else if(c == 'D'){
                list.set(top, (int)Math.pow(list.get(top), 2));
            }else if(c == 'T'){
                list.set(top, (int)Math.pow(list.get(top), 3));
            }else if(c == '*'){
                if(top!=0){
                    list.set(top-1, list.get(top-1)*2);
                }
                list.set(top, list.get(top)*2);
            }else if(c == '#'){
                list.set(top, list.get(top)*(-1));
            }

        }

        for(int num : list){
            answer += num;
        }
        return answer;
    }
}
