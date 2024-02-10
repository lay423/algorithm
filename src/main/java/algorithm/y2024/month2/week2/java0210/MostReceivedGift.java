package algorithm.y2024.month2.week2.java0210;

import java.util.*;

//2024 KAKAO WINTER INTERNSHIP 가장 많이 받은 선물
class MostReceivedGift {
    int[][] giftScore;
    int[][] giftScoreCal;
    int[] giftToReceive;
    public int solution(String[] friends, String[] gifts) {

        //선물 받은 횟수 2차원배열 초기화
        giftScore = new int[friends.length][friends.length];
        for(int i=0; i<giftScore.length; i++){
            for(int j=0; j<giftScore.length; j++){
                giftScore[i][j] = 0;
            }
        }
        //선물지수 계산 배열 초기화
        giftScoreCal = new int[friends.length][2];
        for(int i=0; i<giftScore.length; i++){
            giftScoreCal[i][0] = 0;
            giftScoreCal[i][1] = 0;
        }

        //받아야 할 선물 갯수 배열 초기화
        giftToReceive = new int[friends.length];
        Arrays.fill(giftToReceive, 0);

        //선물 주고받은 횟수
        for (String gift : gifts) {
            String[] spl = gift.split(" ");
            String person_gave = spl[0];
            String person_recieve = spl[1];

            int[] idx = getIdxByName(person_gave, person_recieve, friends);
            int idx1 = idx[0];  //선물 주는 사람
            int idx2 = idx[1];  //선물 받는 사람
            giftScore[idx1][idx2]++;  //선물 주고받은 횟수 증감
            giftScoreCal[idx1][0]++;
            giftScoreCal[idx2][1]++;
        }

        //선물 지수
        for(int i=0; i<giftScoreCal.length; i++){
            giftScoreCal[i][0] = giftScoreCal[i][0] - giftScoreCal[i][1];
        }

        //선물 계산 시작
        for(int i=0; i<giftScore.length; i++){
            for(int j=i+1; j<giftScore[i].length; j++){
                if(giftScore[i][j]>giftScore[j][i]){
                    giftToReceive[i]++;
                }else if(giftScore[j][i]>giftScore[i][j]){
                    giftToReceive[j]++;
                }else{
                    if(giftScoreCal[i][0]>giftScoreCal[j][0]){
                        giftToReceive[i]++;
                    }else if(giftScoreCal[i][0]<giftScoreCal[j][0]){
                        giftToReceive[j]++;
                    }
                }
            }
        }
        int MAX = 0;

        for (int j : giftToReceive) {
            if (j > MAX)
                MAX = j;
        }

        return MAX;



    }

    public int[] getIdxByName(String p1, String p2, String[] friends){
        int idx1=0, idx2=0;
        for(int i=0; i<friends.length; i++){
            if(friends[i].equals(p1)){
                idx1 = i;
            }else if(friends[i].equals(p2)){
                idx2 = i;
            }
        }

        return new int[] {idx1, idx2};
    }
}
