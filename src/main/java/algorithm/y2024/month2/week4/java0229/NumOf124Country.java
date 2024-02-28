package algorithm.y2024.month2.week4.java0229;
class NumOf124Country {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        if(n==0)
            return "1";
        while(n!=0){
            int num = n%3;
            sb.append(num);
            n /= 3;
            if(num == 0)
                n--;
        }
        String str = sb.toString();

        sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            char c = str.charAt(i);
            if(c == '0')
                sb.append("4");
            else if(c == '1')
                sb.append("1");
            else
                sb.append("2");
        }
        return sb.toString();

    }
}