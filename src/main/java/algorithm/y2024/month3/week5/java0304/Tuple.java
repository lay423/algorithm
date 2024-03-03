package algorithm.y2024.month3.week5.java0304;

import java.util.*;

//튜플
class Tuple {
    public List<Integer> solution(String s) {
        List<Integer> list = new ArrayList<>();

        s = s.replace("},{", " ");
        s = s.replace("{", "");
        s = s.replace("}", "");

        String[] sArr = s.split(" ");
        Arrays.sort(sArr, (o1, o2) -> o1.length() - o2.length());

        for(String str : sArr){
            str = str.replace(",", " ");
            String[] sArr2 = str.split(" ");

            for(String str2 : sArr2){
                int num = Integer.parseInt(str2);
                if(!list.contains(num))
                    list.add(num);
            }

        }

        return list;
    }
}