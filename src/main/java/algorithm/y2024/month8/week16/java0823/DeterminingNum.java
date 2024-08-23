package algorithm.y2024.month8.week16.java0823;

class DeterminingNum {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            answer++;
            String s = ""+answer;
            while(answer %3 == 0 || isContainNum(s)){
                answer++;
                s = ""+answer;
            }
        }
        return answer;
    }
    public boolean isContainNum(String s){
        for(int j=0; j<s.length(); j++){
            if(s.charAt(j) == '3')
                return true;
        }
        return false;
    }
}