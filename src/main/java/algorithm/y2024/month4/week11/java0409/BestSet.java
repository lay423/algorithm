package algorithm.y2024.month4.week11.java0409;


//최고의 집합

class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s<n)
            return new int[]{-1};
        else if(n == 1)
            return new int[]{s};

        int other = s % n;
        int val = s / n;
        for(int i=0; i<n; i++){
            int num = val;
            if(i >= n - other)
                num++;
            answer[i] = num;
        }
        return answer;
    }
}