package algorithm.y2024.month3.week5.java0304;

import java.util.*;

//[3차] 압축
class Compression {
    public int[] solution(String msg) {
        List<String> dic = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<26; i++){
            dic.add(String.valueOf((char)('A'+i)));
        }

        for(int i=0; i<msg.length(); i++){
            for(int j=dic.size()-1; j>=0; j--){
                if(msg.substring(i).startsWith(dic.get(j))){
                    i += dic.get(j).length()-1;
                    answer.add(j+1);
                    if(i+1 < msg.length())
                        dic.add(dic.get(j)+msg.charAt(i+1));
                    break;
                }
            }
        }
        int[] answerArr = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            answerArr[i] = answer.get(i);
        }
        return answerArr;
    }
}