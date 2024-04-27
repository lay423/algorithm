package algorithm.y2024.month4.week13.java0427;

class S2 {
    public int solution(String s) {

        if(s.isEmpty())
            return -1;

        char now = s.charAt(0);
        int max = -1;
        int cnt = 1;

        for (int i = 1; i < s.length(); i++) {
            char next = s.charAt(i);
            if (now == next) {
                cnt++;
            }else{
                cnt = 1;
                now = next;
            }
            if (cnt == 3) {
                max = Math.max(max, now - '0');
                cnt = 0;
            }
        }
        if(max == -1)
            return -1;
        return max * 100 + max * 10 + max;
    }
}