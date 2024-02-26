package algorithm.y2024.month2.week4.java0226;

class SplitString {
    public int solution(String s) {
        int answer=0;
        int cnt1=0, cnt2=0;
        char c1 = 'A';
        for(int i=0; i<s.length(); i++){
            if(c1 == 'A'){
                c1 = s.charAt(i);
                cnt1++;
                continue;
            }
            if(c1 == s.charAt(i)){
                cnt1++;
            }else{
                cnt2++;
            }

            if(cnt1 == cnt2){
                answer++;
                c1 = 'A';
                cnt1 = 0;
                cnt2 = 0;
            }


        }
        if(c1 != 'A')
            return answer+1;
        return answer;
    }
}