package algorithm.y2024.month2.week3.java0221;
class PackOfCards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int idx1=0, idx2=0;

        for(String data : goal){
            if(cards1[idx1].equals(data)){
                if(idx1+1 < cards1.length)
                    idx1++;
            }else if(cards2[idx2].equals(data)){
                if(idx2+1 < cards2.length)
                    idx2++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}