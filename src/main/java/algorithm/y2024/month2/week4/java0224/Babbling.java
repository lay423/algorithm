package algorithm.y2024.month2.week4.java0224;

//옹알이 (2)
class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = new String[] {"aya", "ye", "woo", "ma"};
        for(int i=0; i<babbling.length; i++){
            boolean flag=false;
            for(int j=0; j<4; j++){
                if(babbling[i].contains(str[j]+str[j]))
                    flag = true;
            }
            if(!flag){
                for(int j=0; j<4; j++){
                    babbling[i] = babbling[i].replace(str[j], "1");
                }
            }
            babbling[i] = babbling[i].replace("1", "");
            if(babbling[i].equals(""))
                answer++;
        }
        return answer;
    }
}
