package algorithm.y2024.month4.week11.java0409;

//기지국 설치(효율성 실패)

class StationInstall {
    public int solution(int n, int[] stations, int w) {
        int[] line = new int[n];
        int answer = 0;
        int dist = w * 2 + 1;
        for(int station : stations){
            int start = (station - 1) - w;
            int end = start + dist;
            if(start<0)
                start = 0;
            if(end>n)
                end = n;
            for(int i=start; i<end; i++){
                line[i] = 1;
            }
        }

        int cnt=0;
        for(int i=0; i<n; i++){
            if(line[i] == 0)
                cnt++;
            if(line[i] == 1 || i == (n-1)){
                int val = cnt / dist;
                if(cnt % dist != 0)
                    val += 1;
                answer += val;
                cnt = 0;
            }
        }

        return answer;
    }
}