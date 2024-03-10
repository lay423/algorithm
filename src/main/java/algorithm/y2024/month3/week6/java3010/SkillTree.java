package algorithm.y2024.month3.week6.java3010;

import java.util.ArrayList;
import java.util.List;

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        for(int i=0; i<skill.length(); i++){
            list.add(skill.charAt(i));
        }

        for(String tree : skill_trees){
            int idx = 0;
            boolean flag = false;
            for(int i=0; i<tree.length(); i++){

                if(idx < skill.length() &&
                        list.contains(tree.charAt(i)) && tree.charAt(i) != skill.charAt(idx)){
                    flag = true;
                    break;
                }
                if(idx < skill.length() && tree.charAt(i) == skill.charAt(idx)){
                    idx++;
                }
            }
            if(!flag){
                answer++;
            }

        }
        return answer;
    }
}