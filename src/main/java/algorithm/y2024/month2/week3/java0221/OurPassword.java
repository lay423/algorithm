package algorithm.y2024.month2.week3.java0221;
import java.util.*;

//둘만의 암호
class OurPassword {
    List<Integer> list = new ArrayList<>();
    List<Integer> origin = new ArrayList<>();
    public String solution(String s, String skip, int index) {

        for(int i=0; i<skip.length(); i++){
            list.add((int)skip.charAt(i));
        }

        for(int i=0; i<s.length(); i++){
            origin.add((int)s.charAt(i));
        }

        for(int i=0; i<origin.size(); i++){
            int num = origin.get(i);
            for(int j=0; j<index; j++){
                num++;
                if(num>122)
                    num -=26;
                while(isSkip(num, index)){
                    num++;
                    if(num>122)
                        num -=26;
                }
                if(num>122)
                    num -=26;

            }
            origin.set(i, num);
        }
        StringBuilder sb = new StringBuilder();

        for(int num : origin){
            sb.append((char)num);
        }
        return sb.toString();
    }
    private boolean isSkip(int num, int index){
        for(int j=0; j<list.size(); j++){
            if(num == list.get(j))
                return true;
        }
        return false;
    }
}