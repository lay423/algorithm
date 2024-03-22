package algorithm.y2024.month3.week8.java0322;

//N-Queen
class NQueen {
    static int[] arr;
    static int N;
    static int cnt;
    public int solution(int n) {
        arr = new int[n];
        N = n;
        cnt = 0;

        nQueen(0);

        return cnt;
    }
    private static void nQueen(int depth){
        if(depth == N){
            cnt++;
            return;
        }
        for(int i=0; i<N; i++){
            arr[depth] = i;
            if(possible(depth)){
                nQueen(depth+1);
            }
        }
    }
    private static boolean possible(int col){
        for(int i=0; i<col; i++){
            if(arr[i] == arr[col])
                return false;
            else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        return true;
    }
}