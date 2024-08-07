package algorithm.y2024.month8.week15.java0807;

import java.util.LinkedList;
import java.util.List;

class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0){
            return cities.length * 5;
        }

        List<String> cache = new LinkedList<>();
        for(String s : cities){
            String city = s.toLowerCase();

            if(!cache.contains(city)){
                if(cache.size() >= cacheSize){
                    cache.remove(0);
                }
                cache.add(city);
                answer += 5;
            }else{
                cache.remove(city);
                cache.add(city);
                answer += 1;
            }

        }

        return answer;
    }
}