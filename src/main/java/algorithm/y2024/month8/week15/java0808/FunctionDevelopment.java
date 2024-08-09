package algorithm.y2024.month8.week15.java0808;


import java.util.*;

public class FunctionDevelopment {

    public static void main(String[] args) {
        FunctionDevelopment m = new FunctionDevelopment();
        int[] solution = m.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(solution));

    }
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int extraTaskVal = 100 - progresses[i];
            if (extraTaskVal % speeds[i] == 0) {
                q.add(extraTaskVal / speeds[i]);
            } else {
                q.add(extraTaskVal / speeds[i] + 1);
            }
        }

        int now = q.poll();
        int count = 1;
        while (!q.isEmpty()) {
            if (now >= q.peek()) {
                count++;
                q.poll();
            } else {
                list.add(count);
                count = 1;
                now = q.poll();
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
