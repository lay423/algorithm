package algorithm.y2024.month4.week12.java0420;

//기지국 설치

class StationInstall2 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int next = 1;
        int block = 2 * w + 1;

        for(int station : stations){
            int start = station - w;
            int end = station + w;
            if(next < start){
                int dist = start - next;
                answer += dist / block;
                if(dist % block != 0)
                    answer += 1;
            }
            next = end + 1;
        }
        if(next <= n){
            int dist = n - next + 1;
            answer += dist / block;
            if(dist % block != 0)
                answer += 1;
        }
        return answer;
    }
}