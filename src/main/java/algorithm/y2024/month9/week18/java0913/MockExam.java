package algorithm.y2024.month9.week18.java0913;

import java.util.*;

class MockExam {
    public int[] solution(int[] answers) {
        int[] std1 = {1, 2, 3, 4, 5};
        int[] std2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] std3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int sum1=0, sum2=0, sum3=0;
        int idx1=0, idx2=0, idx3=0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] == std1[idx1++])
                sum1++;
            if(answers[i] == std2[idx2++])
                sum2++;
            if(answers[i] == std3[idx3++])
                sum3++;

            if(idx1 == std1.length)
                idx1 = 0;
            if(idx2 == std2.length)
                idx2 = 0;
            if(idx3 == std3.length)
                idx3 = 0;
        }

        int MAX = 0;
        int[] sumArr = new int[] {sum1, sum2, sum3};
        for(int sum : sumArr){
            MAX = Math.max(sum, MAX);
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<sumArr.length; i++){
            if(sumArr[i] == MAX)
                list.add(i+1);
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}