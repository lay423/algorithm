package algorithm.y2024.month8.week16.java0822;

class NationalCompetitionTest {
    public int solution(int[] rank, boolean[] attendance) {
        int[] student = new int[rank.length];
        for(int i=0; i<student.length; i++){
            student[i] = i;
        }

        for(int i=0; i<rank.length-1; i++){
            for(int j=i+1; j<rank.length; j++){
                if(rank[i] > rank[j]){
                    int tmp = rank[i];
                    rank[i] = rank[j];
                    rank[j] = tmp;

                    tmp = student[i];
                    student[i] = student[j];
                    student[j] = tmp;
                }
            }
        }
        int j=0;
        int[] answer = new int[3];
        for (int now : student) {
            if (attendance[now]) {
                answer[j] = now;
                j++;
            }
            if (j >= answer.length)
                break;
        }

        return 10000 * answer[0] + 100 * answer[1] + answer[2];
    }
}