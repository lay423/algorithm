package algorithm.y2024.month2.week4.java0225;
import java.util.*;

//숫자 짝꿍
class NumberPartner {
    public String solution(String X, String Y) {
        Map<Integer, Integer> mapx = new HashMap<>();
        Map<Integer, Integer> mapy = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<X.length(); i++){
            int target = X.charAt(i)-'0';
            mapx.put(target, mapx.getOrDefault(target, 0)+1);
        }

        for(int i=0; i<Y.length(); i++){
            int target = Y.charAt(i)-'0';
            mapy.put(target, mapy.getOrDefault(target, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : mapx.entrySet()){
            int key = entry.getKey();
            if(mapy.containsKey(key)){
                int min = Math.min(mapy.get(key), entry.getValue());
                for(int i=0; i<min; i++){
                    list.add(key);
                }
            }
        }
        Collections.sort(list);
        if(list.size()==0)
            return "-1";
        if(list.get(list.size()-1)==0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(String.valueOf(list.get(i)));
        }
        return sb.toString();
    }
}