package algorithm.y2024.month4.week12.java0419;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//베스트 앨범

class BestAlbum {
    static class Music{
        String genre;
        int play;
        int num;
        public Music(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
        public Music(int play, int num){
            this.play = play;
            this.num = num;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        List<Music> sumList = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            if(!map.containsKey(genre)){
                map.put(genre, new ArrayList<>());
                sum.put(genre, 0);
            }
            List<Music> list = map.get(genre);
            list.add(new Music(play, i));
            map.put(genre, list);
            sum.put(genre, sum.get(genre) + play);
        }

        for(Map.Entry<String, Integer> entry : sum.entrySet()){
            sumList.add(new Music(entry.getKey(), entry.getValue()));
        }
        sumList.sort((o1, o2) -> o2.play - o1.play);

        for (Music music : sumList) {
            List<Music> list = map.get(music.genre);
            list.sort((o1, o2) -> o2.play - o1.play);
            Music listMusic = list.get(0);
            answer.add(listMusic.num);
            if (list.size() > 1) {
                listMusic = list.get(1);
                answer.add(listMusic.num);
            }
        }

        int[] arr = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            arr[i] = answer.get(i);
        }
        return arr;
    }
}