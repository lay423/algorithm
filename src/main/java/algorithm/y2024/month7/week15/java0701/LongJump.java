package algorithm.y2024.month7.week15.java0701;

class LongJump {
    public long solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<dp.length; i++){
            int num = dp[i-1] + dp[i-2];
            dp[i] = num % 1234567;
        }
        return dp[n];
    }
}