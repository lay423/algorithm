package algorithm.y2024.month3.week7.java0321;

import java.util.*;

//과제 진행하기
class Assignment {

    static class Plan{
        String name;
        int start;
        int playTime;
        public Plan(String[] plan){
            this.name = plan[0];
            this.start = convertTime(plan[1]);
            this.playTime = Integer.parseInt(plan[2]);
        }
        public Plan(String name, int playTime){
            this.name = name;
            this.playTime = playTime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer1 = new String[plans.length];
        List<String> answer = new ArrayList<>();
        List<Plan> list = new ArrayList<>();
        Queue<Plan> q = new LinkedList<>();
        Stack<Plan> stack = new Stack<>();

        for(String[] plan : plans){
            list.add(new Plan(plan));
        }
        Collections.sort(list, (o1, o2) -> o1.start - o2.start);
        q.addAll(list);

        while(!q.isEmpty()){
            Plan now = q.poll();

            int time = now.start;

            //다음 과제가 남은 경우
            if(!q.isEmpty()){
                Plan next = q.peek();

                if(time + now.playTime < next.start){
                    answer.add(now.name);
                    time += now.playTime;

                    while(!stack.isEmpty()){
                        Plan rem = stack.pop();

                        if(time + rem.playTime <= next.start){
                            time += rem.playTime;
                            answer.add(rem.name);
                            continue;
                        }
                        else{
                            int t = rem.playTime - (next.start - time);
                            stack.push(new Plan(rem.name, t));
                            break;
                        }
                    }

                }else if(now.start + now.playTime == next.start){
                    answer.add(now.name);
                    continue;
                }else{
                    int t = (next.start - time);
                    stack.push(new Plan(now.name, now.playTime - t));
                }

            }else{ //다음과제가 없는 경우
                if(stack.isEmpty()){
                    time += now.playTime;
                    answer.add(now.name);
                }else{
                    answer.add(now.name);

                    while(!stack.isEmpty()){
                        Plan rem = stack.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }

        for(int i=0; i<answer.size(); i++){
            answer1[i] = answer.get(i);
        }
        return answer1;
    }
    private static int convertTime(String str){
        String[] split = str.split(":");
        return Integer.parseInt(split[1]) + 60 * Integer.parseInt(split[0]);
    }
}