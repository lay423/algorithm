package algorithm.y2024.month3.week6.java0314;

//배달
class Delivery {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                arr[i][j] = 500001;
            }
        }

        for (int i = 0; i < road.length; i++) {
            int idx1 = road[i][0] - 1;
            int idx2 = road[i][1] - 1;
            int cost = road[i][2];
            if (arr[idx1][idx2] >= cost) {
                arr[idx1][idx2] = cost;
                arr[idx2][idx1] = cost;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (arr[0][i] <= K)
                answer++;
        }
        return answer;
    }
}
